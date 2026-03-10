# Deploying Umami

An issue has been raised here : <https://github.com/umami-software/umami/issues/4064>

In the meantime, here's how to build your own umami image with a specific base_path :

```bash
# Download official umami repo : 
git clone https://github.com/umami-software/umami.git
cd umami

# Here replace with your variables : 
USERNAME="<my github username>"
REPO="<my github project>"
SUB_BASE_PATH="<my base_path (ex: stats for /stats)>"
CR_PAT="<my github deploy token>" # see https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens to generate token

# Login to github with docker, in order to push the new image
echo $CR_PAT | docker login ghcr.io -u ${USERNAME} --password-stdin 

# Build and push the image, making sure to have compatibility with different platforms : 
docker buildx build --platform linux/amd64,linux/arm64 --build-arg BASE_PATH=/${SUB_BASE_PATH} -t ghcr.io/${USERNAME}/${REPO}/umami:path-${SUB_BASE_PATH} --push .
```

