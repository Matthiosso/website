export default { 
    branches: ['main', 'dev'],
    plugins: [
        [
            '@codedependant/semantic-release-docker', 
            {
                dockerTags: ['latest', '{{version}}', '{{major}}-latest', '{{major}}.{{minor}}', '{{major}}.{{minor}}.{{patch}}'],
                dockerFile: 'Dockerfile',
                dockerRegistry: 'ghcr.io',
                dockerRepository: 'matthiosso/website/frontend',
                dockerPlatform: ['linux/amd64', 'linux/arm64'],
                dockerBuildFlags: {
                    pull: null
                , target: 'release'
                },
                dockerArgs: {
                    API_TOKEN: null, 
                    RELEASE_DATE: new Date().toISOString(), 
                    RELEASE_VERSION: '{{next.version}}'
                },
                dockerLabels: {
                    'org.opencontainers.image.title': 'Portfolio Website Frontend',
                    'org.opencontainers.image.description': 'Portfolio Website Frontend using Vue.js and Vite',
                    'org.opencontainers.image.version': '{{next.version}}',
                    'org.opencontainers.image.created': new Date().toISOString(),
                }
            }
        ]
    ]
};