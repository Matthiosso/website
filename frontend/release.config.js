export default { 
    branches: [
        { name: 'main' },
        { name: 'dev', channel: 'dev', prerelease: true }
    ],
    plugins: [
        '@semantic-release/commit-analyzer',
        '@semantic-release/release-notes-generator',
        '@semantic-release/changelog',
        '@semantic-release/npm',
        ['@semantic-release/git', {
            'assets': ['dist/**/*.{js,css}', 'docs', 'package.json'],
            'message': 'chore(release): ${nextRelease.version} [skip ci]\n\n${nextRelease.notes}'
        }],
        '@semantic-release/github'
    ]
};