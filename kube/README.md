# Install app on server with Kube and nginx

## Setup

```bash
# Install k3s without traefik
curl -sfL https://get.k3s.io | INSTALL_K3S_EXEC="server" sh -s - --disable-traefik

# Install helm
curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 | bash
helm version

# Install & deploy ingress-nginx
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install ingress-nginx ingress-nginx/ingress-nginx --namespace ingress-nginx --create-namespace

# Import code
git clone https://github.com/Matthiosso/website.git
cd website
```

## Prod (with remote docker image from github)

```bash
kubectl apply -f kube/nginx-website-deployment.yaml
```

### Update deployment

To make sure the old pod is killed only when the new one is up :

```bash
kubectl rollout restart deployment website
```

## Dev (with locally built docker image)

```bash
docker build -f Dockerfile.dev -t app:dev .
docker save app:dev | sudo k3s ctr images import -
kubectl apply -f kube/dev-website-deployment.yaml
```

### Update dev deployment

```bash
kubectl -n dev rollout restart deployment website
```
