# Utilities Module

The **Utilities** module is a core package of the framework that provides common reusable components and helper classes shared across other modules.  
It aims to improve **code reusability**, **maintainability**, and **consistency** throughout the framework.

---

## 🧩 Overview

Currently, this package focuses on **Configuration Helpers**, which simplify loading, accessing, and managing configuration values across different modules of the framework.  
As the framework evolves, this package can be extended to include other common utilities and base classes.

---

## ⚙️ Features

- Centralized configuration management for the framework
- Easy loading of configuration files (e.g., `.properties`, `.yaml`, `.json`)
- Custom exception handling for configuration-related issues
- Decoupled from logging — logging utilities are handled by a separate package

---

## 📦 Installation

Clone the repository:

```bash
git clone https://github.com/parmar-mohit/Brick-Utilities.git
cd Brick-Utilities
```

Build with Maven/Gradle (depending on your project setup):

```bash
mvn clean install
```

or

```bash
gradle build
```

Add it as a dependency in your project:

```xml
<dependency>
    <groupId>com.brick</groupId>
    <artifactId>com.brick.utilities</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## 🤝 Contributing

Contributions are welcome!  
Feel free to open issues, submit pull requests, or suggest improvements.

---
