# Contributing to Kingdom Clans V16

**We love contributions!** 🎉

---

## 🤝 How to Contribute

### 1. Report Bugs

```
GitHub Issues → New Issue

Include:
- What you did
- What happened
- What should happen
- Device & Android version
- Screenshots/logs
```

### 2. Suggest Features

```
GitHub Discussions → New Discussion

Describe:
- Feature idea
- Why it's useful
- Example usage
- How to implement (optional)
```

### 3. Submit Code

```bash
# 1. Fork repository
# 2. Create branch
git checkout -b feature/my-feature

# 3. Make changes
# 4. Test thoroughly
# 5. Commit with clear message
git commit -m "Add: New feature description"

# 6. Push to fork
git push origin feature/my-feature

# 7. Create Pull Request
# 8. Describe changes
# 9. Wait for review
```

---

## 📋 Contribution Guidelines

### Code Style
```java
// Classes: PascalCase
public class GameManager { }

// Methods: camelCase
public void startGame() { }

// Variables: camelCase
private int playerLevel;

// Constants: UPPER_SNAKE_CASE
private static final int MAX_LEVEL = 14;
```

### Commit Messages
```
Format: <type>: <description>

Types:
  Add    → New feature
  Fix    → Bug fix
  Docs   → Documentation
  Style  → Code style
  Test   → Test code
  Refactor → Code refactor

Examples:
Add: New hero system
Fix: Building placement bug
Docs: Update installation guide
```

### Pull Request Process
```
1. Fork repo
2. Create feature branch
3. Write code & tests
4. Update documentation
5. Commit & push
6. Create PR with description
7. Wait for review
8. Fix feedback if needed
9. Merge when approved
```

---

## 🐛 Bug Reporting Template

```markdown
## Description
Clear description of the bug

## Steps to Reproduce
1. First step
2. Second step
3. ...

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Screenshots/Logs
Attach if relevant

## Device Info
- Device: [e.g., Samsung Galaxy S10]
- Android: [e.g., 12.0]
- App Version: [e.g., 1.0.0]
```

---

## 💡 Feature Request Template

```markdown
## Feature Description
Clear description of feature

## Motivation
Why is this useful?

## Implementation Ideas
How could it work?

## Additional Context
Any other information
```

---

## 🏗️ Development Setup

```bash
# 1. Clone your fork
git clone https://github.com/YOUR-USERNAME/KingdomClans-V16.git
cd KingdomClans-V16

# 2. Add upstream
git remote add upstream https://github.com/ruffhf08-del/KingdomClans-V16.git

# 3. Create feature branch
git checkout -b feature/my-feature

# 4. Setup environment
bash setup.sh

# 5. Make changes
# 6. Test everything
bash build.sh

# 7. Commit & push
git add .
git commit -m "Add: My feature"
git push origin feature/my-feature
```

---

## ✅ Testing Checklist

Before submitting PR:

- [ ] Code compiles without errors
- [ ] No warnings in build
- [ ] All tests pass
- [ ] APK builds successfully
- [ ] Feature works on device
- [ ] No performance issues
- [ ] Documentation updated
- [ ] Code style followed

---

## 📚 Documentation

### Update Needed For:
- New features → Add to README.md
- API changes → Update docs/
- Bug fixes → Add to CHANGELOG
- New guides → Create new .md file

---

## 🎯 Areas We Need Help

### High Priority
- [ ] Multiplayer implementation
- [ ] Graphics improvements
- [ ] Performance optimization
- [ ] Bug fixes

### Medium Priority
- [ ] Additional buildings
- [ ] More troops
- [ ] New features
- [ ] UI improvements

### Low Priority
- [ ] Documentation
- [ ] Examples
- [ ] Tutorials
- [ ] Community content

---

## 💬 Community

- **Issues**: Report bugs
- **Discussions**: Ask questions
- **Pull Requests**: Submit code
- **Wiki**: Add documentation
- **Email**: Contact maintainers

---

## 📝 License

By contributing, you agree your code will be under MIT License.

---

**Thank you for contributing!** 🙏❤️
