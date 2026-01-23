# 💰 ExpenseAura - Personal Finance Manager

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green.svg" alt="Platform">
  <img src="https://img.shields.io/badge/Language-Kotlin-blue.svg" alt="Language">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
</p>

A modern, intuitive Android application for managing personal finances, tracking expenses, setting savings goals, and staying on top of your financial commitments.

## ✨ Features

### 🏠 Dashboard
- Overview of your financial status at a glance
- Visual representation of income vs expenses
- Quick access to key features

### 💸 Expense Tracking
- Record and categorize transactions (income/expenses)
- View transaction history with details
- Color-coded amounts for easy identification
- Multiple categories: Food, Entertainment, Income, and more

### 🎯 Savings Goals
- Set multiple savings goals (e.g., New Bike, Emergency Fund, Vacation)
- Track progress with visual indicators
- Monitor current savings vs target amounts
- Goal-specific icons for easy identification

### 🔔 Smart Reminders
- Set up payment reminders for bills and subscriptions
- Active and recurring reminder categories
- Toggle reminders on/off
- Never miss a payment deadline

### ⚙️ Settings & Account Management
- User profile management
- Secure login and registration system
- Logout functionality with session clearing
- Social login options (Google, Facebook - coming soon)

## 🛠️ Technical Stack

### Core Technologies
- **Language**: Kotlin 100%
- **Min SDK**: Android 7.0 (API 24)
- **Target SDK**: Android 15 (API 35)
- **Build System**: Gradle (Kotlin DSL)

### Key Libraries & Frameworks
- **Jetpack Compose**: Modern declarative UI toolkit
- **Material Design 3**: Beautiful, accessible UI components
- **View Binding**: Type-safe view access
- **AndroidX Core & AppCompat**: Latest Android compatibility
- **Lottie**: High-quality animations
- **MPAndroidChart**: Data visualization for charts
- **Navigation Component**: Fragment navigation

### Architecture
- **Pattern**: Fragment-based navigation with Bottom Navigation
- **UI**: Mix of XML layouts and Jetpack Compose
- **Data Models**: Kotlin data classes (Transaction, Goal, Remind)
- **Adapters**: RecyclerView adapters for lists

## 📱 App Structure

```
ExpenseAura-Mobile_Application/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/royce/expenseaura/
│   │   │   │   ├── adapter/           # RecyclerView adapters
│   │   │   │   │   ├── GoalAdapter.kt
│   │   │   │   │   ├── TransactionAdapter.kt
│   │   │   │   │   └── RemindAdapter.kt
│   │   │   │   ├── model/             # Data models
│   │   │   │   │   ├── Goal.kt
│   │   │   │   │   ├── Transaction.kt
│   │   │   │   │   └── Remind.kt
│   │   │   │   ├── ui/theme/          # Compose theming
│   │   │   │   ├── MainActivity.kt    # Main container activity
│   │   │   │   ├── GetStartedActivity.kt
│   │   │   │   ├── LoginActivity.kt
│   │   │   │   ├── RegisterActivity.kt
│   │   │   │   ├── HomeFragment.kt    # Dashboard
│   │   │   │   ├── ExpenseFragment.kt # Transactions & Goals
│   │   │   │   ├── AddFragment.kt     # Add new entries
│   │   │   │   ├── RemindFragment.kt  # Reminders
│   │   │   │   └── SettingsFragment.kt
│   │   │   └── res/                   # Resources (layouts, drawables, etc.)
│   │   ├── androidTest/               # Instrumentation tests
│   │   └── test/                      # Unit tests
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── LICENSE
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 35
- Kotlin 1.9+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/RoyceAbiel426/ExpenseAura-Mobile_Application.git
   cd ExpenseAura-Mobile_Application
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle files
   - Wait for dependencies to download

4. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button (▶️) or press `Shift + F10`

## 📊 Key Components

### MainActivity
The main container activity using bottom navigation with 5 sections:
- Home (Dashboard)
- Expense (Transactions & Goals)
- Add (Quick entry)
- Remind (Reminders)
- Settings (Account)

### Data Models

**Transaction**
```kotlin
data class Transaction(
    val title: String,
    val category: String,
    val date: String,
    val amount: Double  // Negative for expenses, positive for income
)
```

**Goal**
```kotlin
data class Goal(
    val iconRes: Int,
    val name: String,
    val current: Int,
    val target: Int
)
```

**Remind**
```kotlin
data class Remind(
    val id: Int,
    val title: String,
    val time: String,
    val iconRes: Int,
    var isEnabled: Boolean
)
```

## 🎨 Design Highlights

- **Modern Material Design 3** aesthetics
- **Gradient backgrounds** with custom color schemes
- **Responsive layouts** with ConstraintLayout
- **Smooth animations** using Lottie
- **Intuitive navigation** with bottom navigation bar
- **Card-based UI** for better content organization

## 🔐 Authentication Flow

1. **GetStartedActivity**: Welcome screen with Login/Sign Up options
2. **LoginActivity**: User authentication
3. **RegisterActivity**: New user registration
4. **MainActivity**: Main app (post-authentication)

## 🧪 Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumentation Tests
```bash
./gradlew connectedAndroidTest
```

## 📦 Dependencies

Key dependencies include:
- `androidx.core:core-ktx:1.17.0`
- `androidx.compose.ui:ui` (with BOM 2024.08.00)
- `com.google.android.material:material:1.12.0`
- `com.airbnb.android:lottie:6.4.0`
- `com.github.PhilJay:MPAndroidChart:v3.1.0`

See [build.gradle.kts](app/build.gradle.kts) for the complete list.

## 🛣️ Roadmap

- [ ] Database integration (Room)
- [ ] Cloud sync functionality
- [ ] Google & Facebook authentication
- [ ] Export transactions to CSV/PDF
- [ ] Budget planning features
- [ ] Categories customization
- [ ] Multi-currency support
- [ ] Dark mode support
- [ ] Biometric authentication

## 📄 License

This project is licensed under the Apache-2.0 License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Royce Abiel**
- GitHub: [@RoyceAbiel426](https://github.com/RoyceAbiel426)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/RoyceAbiel426/ExpenseAura-Mobile_Application/issues).

## ⭐ Show Your Support

Give a ⭐️ if this project helped you!

---

<p align="center">Made with ❤️ and Kotlin</p>
