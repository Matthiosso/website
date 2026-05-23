# Umami — Kubernetes Deployment

Self-hosted analytics using [Umami](https://umami.is/) backed by PostgreSQL, exposed via nginx Ingress with TLS.

## Architecture

```text
Internet
   │  HTTPS
   ▼
nginx Ingress  ──(TLS via cert-manager/letsencrypt-prod)
   │
   ▼
umami-service :3000
   │
   ▼
umami-svc (Deployment)   ──►  postgres :5432
                                  │
                              postgres-pvc (5 Gi)
```

| Resource | File |
| --- | --- |
| Namespace | `umami-namespace.yaml` |
| Umami Deployment + Service + Ingress | `umami-deployment.yaml` |
| PostgreSQL Deployment + PVC + Service | `umami-postgres.yaml` |
| Secrets | `umami-secrets.yaml` |

## Prerequisites

- `kubectl` configured against the target cluster
- [nginx Ingress Controller](https://kubernetes.github.io/ingress-nginx/) installed
- [cert-manager](https://cert-manager.io/) installed with a `letsencrypt-prod` ClusterIssuer
- `envsubst` available locally (`brew install gettext` on macOS)

## Required Variables

| Variable | Description |
| --- | --- |
| `UMAMI_SERVER_HOSTNAME` | Public hostname for Umami (e.g. `umami.example.com`) |
| `UMAMI_APP_SECRET` | Random secret used to sign sessions |
| `UMAMI_POSTGRES_PASSWORD` | Password for the `umami` PostgreSQL user |

Generate secure values:

```bash
export UMAMI_APP_SECRET=$(openssl rand -hex 32)
export UMAMI_POSTGRES_PASSWORD=$(openssl rand -hex 16)
```

## First-time Deployment

Apply manifests in order — the namespace and secrets must exist before workloads start.

```bash
kubectl apply -f umami-namespace.yaml
envsubst < umami-secrets.yaml | kubectl apply -f -
kubectl apply -f umami-postgres.yaml
envsubst < umami-deployment.yaml | kubectl apply -f -
```

Wait for both pods to be ready:

```bash
kubectl -n umami rollout status deployment/postgres
kubectl -n umami rollout status deployment/umami-svc
```

> **Note:** The liveness probe has a 120 s initial delay to allow Umami time to run database migrations on first boot.

## Updating Umami

Edit the image tag in `umami-deployment.yaml`, then re-apply:

```bash
envsubst < umami-deployment.yaml | kubectl apply -f -
kubectl -n umami rollout status deployment/umami-svc
```

## Backup & Restore

### Create a backup

```bash
kubectl -n umami exec deployment/postgres -- \
  pg_dump -U umami umami > umami-backup-$(date +%Y%m%d).sql
```

### Restore from a backup

```bash
kubectl -n umami exec -i deployment/postgres -- \
  psql -U umami umami < umami-backup-YYYYMMDD.sql
```

## Teardown

```bash
kubectl delete namespace umami
```

> This deletes all resources including the PVC and its data. Export a backup first.
