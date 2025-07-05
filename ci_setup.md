# CI Setup

## Overview
- Tests run automatically on every push and pull request.

## Tools
- GitHub Actions (`.github/workflows/`) or Jenkins (`Jenkinsfile`).

## Steps
1. Checkout code.
2. Install dependencies (`requirements.txt`, `package.json`, etc.).
3. Start emulator/device or connect to device cloud.
4. Run tests (`pytest`, `npm test`, etc.).
5. Store and publish reports.

## Troubleshooting
- Check runner logs for environment variables and secrets issues.
- Use artifact upload for logs and screenshots.

---

_Keep this file up to date with your latest CI/CD pipeline._
