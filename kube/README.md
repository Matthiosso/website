# Install frontend on server with Kube and nginx

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
kubectl apply -f kube/prod-frontend-deployment.yaml
kubectl apply -f kube/prod-backend-deployment.yaml
```

### Update deployment

To make sure the old pod is killed only when the new one is up :

```bash
kubectl rollout restart deployment website-frontend
kubectl rollout restart deployment website-backend
```

## Dev (with locally built docker image)

```bash
docker build -f ./frontend/Dockerfile -t website-frontend:dev ./frontend
docker save website-frontend:dev | sudo k3s ctr images import -
kubectl apply -f kube/dev-frontend-deployment.yaml

docker build -f ./backend/Dockerfile -t website-backend:dev ./backend
docker save website-backend:dev | sudo k3s ctr images import -
kubectl apply -f kube/dev-backend-deployment.yaml
```

### Update dev deployment

```bash
kubectl -n dev rollout restart deployment website-frontend
kubectl -n dev rollout restart deployment website-backend
```
