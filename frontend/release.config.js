export default { 
    branches: ['main', 'dev'],
    plugins: [
        [
            '@codedependant/semantic-release-docker', 
            {
                dockerTags: ['latest', '{{version}}', '{{major}}-latest', '{{major}}.{{minor}}', '{{major}}.{{minor}}.{{patch}}'],
                dockerImage: 'frontend',
                dockerFile: 'Dockerfile',
                dockerRegistry: 'ghcr.io',
                dockerProject: 'matthiosso/website',
                dockerPlatform: ['linux/amd64'],
                dockerBuildFlags: {
                    pull: null, 
                    target: 'release',
                    label: 'org.opencontainers.image.title=Portfolio Website Frontend',
                    label: 'org.opencontainers.image.description=Portfolio Website Frontend using Vue.js and Vite',
                    label: 'org.opencontainers.image.version={{next.version}}',
                    label: 'org.opencontainers.image.created=' + new Date().toISOString()
                },
                dockerArgs: {
                    API_TOKEN: null, 
                    RELEASE_DATE: new Date().toISOString(), 
                    RELEASE_VERSION: '{{next.version}}'
                },
            }
        ]
    ]
};