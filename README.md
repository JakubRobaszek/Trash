![Trash](https://github.com/user-attachments/assets/78da9106-8155-46f0-94ef-75d568d1c213)

# Trash Bin Plugin

![Java](https://img.shields.io/badge/Java-21-blue)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.5.3-blue)
![PaperMC](https://img.shields.io/badge/PaperMC-1.21.1--R0.1--SNAPSHOT-blue)
![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-green.svg)

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Commands](#commands)
- [Permissions](#permissions)
- [Configuration](#configuration)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Description

The Trash plugin allows players to easily discard unwanted items using a trash bin inventory. It provides a simple and intuitive way to manage and delete items in-game.

 - Native Minecraft Version:

   - 1.21.1

 - Tested Minecraft Versions:

   - 1.8 1.9 1.10 1.11 1.12 1.13 1.14 1.15 1.16 1.17 1.18 1.19 1.20 1.21

## Features

- **Trash Command**: Opens a menu where players can discard any unwanted items.
- **Reload Command**: Allows reloading the plugin configuration.
- **Permission Checks**: Ensures only authorized players can use the commands.
- **Configurable Inventory Size**: Customize the size of the trash bin inventory.
- **Automatic Inventory Clearing**: Clears the trash inventory when closed.

## Commands

- `/trash` - Opens the trash bin inventory.
  - **Permission**: `trash.use`
  - **Aliases**: `bin`, `trashbin`, `garbage`, `kosz`, `mull`

- `/trashreload` - Reloads the plugin configuration.
  - **Permission**: `trash.reload`

## Permissions

- `trash.use` - Access to the Trash Command.
- `trash.reload` - Allows reloading the plugin configuration.

## Configuration

The `config.yml` file allows you to customize various aspects of the plugin:

```yaml
trash:
  prefix: "&b[&6Trash&b]&r "
  openMessage: "&aTrash bin opened! Put items you want to delete in here."
  inventoryTitle: "&bTrash Bin"
  noPermission: "&cYou do not have permission to use this command."
  notPlayerMessage: "&7You are not a player..."
  reloadMessage: "&aConfiguration reloaded!"
  sendOpenMessage: true
  inventoryRows: 6
```
## Installation

  1. Download the latest release of the plugin from the [releases page](https://github.com/jakubrobaszek/HelloWorld/releases).
  2. Place the plugin JAR file in your server's `plugins` directory.
  3. Start your server to generate the default configuration files.
  4. Customize the config.yml file to your liking.
  5. Reload or restart your server to apply the changes.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request with your changes.

  1. Fork the repository.
  2. Create a new branch (`git checkout -b feature/YourFeature`).
  3. Make your changes and commit them (`git commit -m 'Add your feature'`).
  4. Push to the branch (`git push origin feature/YourFeature`).
  5. Open a pull request.

## License

This project is licensed under the GPL-3.0 License. See the [LICENSE](LICENSE) file for more details.
