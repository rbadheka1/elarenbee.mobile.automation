# Test Data Strategy

## Principles
- No user secrets or production data in repo.
- Test data is isolated by environment and scenario.
- **Sensitive test data is encrypted at rest and decrypted only as needed in CI or locally.**

## Sources
- `/data/test_data.csv`: Main static data for most test flows.
- Factories or fixtures for dynamic/randomized data.
- **Encrypted test data files (e.g., `/data/test_data.csv.gpg`) for sensitive information.**

## Management
- Version control for all test data files.
- Mask/anonymize sensitive data.
- **Encryption keys are managed securely and never committed.**

## Maintenance
- Review and update test data quarterly or after major features.
- Data clean-up scripts as needed.
- **Regularly rotate encryption keys and audit access.**

---

_Add or update as your data needs evolve._
