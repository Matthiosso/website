export default {
    linkedInUrl : import.meta.env.VITE_LINKEDIN_URL,
    githubUrl : import.meta.env.VITE_GITHUB_URL,
    downloadResumeAPIUrl : import.meta.env.VITE_API_URL + '/download/resume',
    versionAPIUrl : import.meta.env.VITE_API_URL + '/version',
    sendMailAPIUrl : import.meta.env.VITE_API_URL + '/mail/send',
    plausibleUrl : import.meta.env.VITE_PLAUSIBLE_URL,
    plausibleSecretKey : import.meta.env.VITE_PLAUSIBLE_SECRET_KEY,
    frontendUrl : import.meta.env.VITE_FRONTEND_URL,
};