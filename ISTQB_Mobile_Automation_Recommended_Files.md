# ISTQB Advanced Test Automation: Mobile Automation Project File Checklist

## 1. Documentation
- README.md
- test_automation_strategy.md
- /docs/ (architecture diagrams, tool evaluations, setup guides)
- CONTRIBUTING.md
- CHANGELOG.md

## 2. Configuration & Environment
- requirements.txt / package.json / build.gradle
- /config/ (capabilities.json, config.yaml, .env.example)

## 3. Test Data Management
- /data/ (test_data.csv/json/yaml)
- test_data_strategy.md

## 4. Test Design & Implementation
- /page_objects/ or /locators/
- /tests/
- conftest.py (or equivalent test setup/teardown)

## 5. Utilities & Base Classes
- /utils/ or /helpers/
- base_test.py / base_page.py

## 6. Continuous Integration
- .github/workflows/ / Jenkinsfile
- ci_setup.md

## 7. Reporting & Logging
- /reports/
- logging.conf / log4j.properties
- reporting_strategy.md

## 8. Test Maintenance & Governance
- test_maintenance_plan.md
- static_analysis.md
- .gitignore
- .pylintrc / .eslintrc

## 9. Traceability & Coverage
- traceability_matrix.xlsx/csv
- /coverage/

---

## Locators/XPath Best Practices
- Dedicated /page_objects/ or /locators/ folder
- Locator best practices/naming conventions doc

---

**You can use this as a reference for what your repo should contain for ISTQB-aligned best practices.**

If you want, I can help you:
- Scan which of these files are present/missing in your repo (if you provide structure or upload a file list)
- Generate templates for any missing files
- Advise on how to implement or organize any of these areas

Let me know how you’d like to proceed!
