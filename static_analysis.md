# Static Analysis Policy

## Tools
- Python: flake8, pylint
- JavaScript: ESLint
- Java: Checkstyle

## Standards
- Enforce via CI before merge.
- Fail builds on critical rule violations.

## Configuration
- Linting configs: `.pylintrc`, `.eslintrc`, etc.
- Custom rules documented in `/docs/` if needed.

---

_Review and update linting rules regularly._
