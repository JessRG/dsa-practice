## 📦 What does this PR do?

Brief explanation of what functionality was added, changed, or fixed.

## 🔍 Summary of Changes

- Added new endpoint `/api/users/auth`
- Refactored existing user service for modularity
- Improved error handling with middleware

## 🧰 Technical Details

- Tech used: Node.js, Express, PostgreSQL
- Introduced a new JWT utility for auth token generation
- Updated Sequelize models with new fields

## 🧪 How to Test

> Describe steps:
> 
> 1. Run `npm run db:migrate`
> 2. Start server with `npm run dev`
> 3. Use Postman to POST to `/api/users/auth`
> 4. Check for correct JWT response and proper error handling

## 📚 Documentation

- [ ] I’ve updated the README or API docs (if needed)

## ⚠️ Breaking Changes

> Is this a breaking change? (yes/no)  
> If yes, describe the impact and any necessary migration steps.

## ⏱ Estimated Deployment Time

> E.g., 15 minutes with no downtime

## 🧾 Notes for Reviewers

> Any context or edge cases to be aware of
