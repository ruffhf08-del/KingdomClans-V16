# Contributing to Kingdom Clans V16

Thank you for your interest in contributing! This document provides guidelines for contributing to the project.

## Code of Conduct

Be respectful, inclusive, and constructive in all interactions.

## How to Contribute

### 1. Fork & Clone
```bash
git clone https://github.com/YOUR_USERNAME/KingdomClans-V16.git
cd KingdomClans-V16
git remote add upstream https://github.com/ruffhf08-del/KingdomClans-V16.git
```

### 2. Create Feature Branch
```bash
git checkout -b feature/YourFeatureName
```

### 3. Make Changes
- Follow existing code style
- Write clean, commented code
- Add tests for new features
- Update documentation

### 4. Commit
```bash
git commit -m "Add: Description of changes"
```

### 5. Push & Pull Request
```bash
git push origin feature/YourFeatureName
```

Then create a Pull Request on GitHub.

## Coding Standards

### Java Code Style
- Use 4 spaces for indentation
- Follow Java naming conventions (camelCase for methods/variables)
- Add JavaDoc comments for public methods
- Keep methods focused and under 50 lines

### Commit Messages
```
Add: New feature description
Fix: Bug fix description
Refactor: Code refactoring description
Docs: Documentation updates
Test: Test additions/improvements
```

## Testing

Before submitting PR:
```bash
./gradlew test
./gradlew check
```

## Documentation

Update relevant documentation files:
- README.md - Major features
- ARCHITECTURE.md - System changes
- docs/GAMEPLAY.md - Game mechanic changes

## Areas for Contribution

### Code
- [ ] New building types
- [ ] New troop types
- [ ] Battle AI improvements
- [ ] Network features
- [ ] Performance optimizations

### Art & Design
- [ ] Building sprites
- [ ] Troop animations
- [ ] UI improvements
- [ ] Visual effects

### Documentation
- [ ] Gameplay guides
- [ ] API documentation
- [ ] Tutorial content
- [ ] Architecture diagrams

### Testing
- [ ] Test cases
- [ ] Bug reports
- [ ] Performance testing

## Pull Request Checklist

- [ ] Code follows style guidelines
- [ ] All tests pass
- [ ] Documentation updated
- [ ] No new warnings introduced
- [ ] Commits are meaningful
- [ ] PR description is clear

## Questions?

Open a discussion or issue on GitHub!
