package me.fini69.trash

import me.fini69.trash.commands.TrashCommand
import me.fini69.trash.commands.TrashReloadCommand
import me.fini69.trash.listeners.InventoryListener
import org.bukkit.plugin.java.JavaPlugin

class Trash : JavaPlugin() {

    override fun onEnable() {
        // Load config
        saveDefaultConfig()

        // Register commands
        getCommand("trash")?.setExecutor(TrashCommand(this))
        getCommand("trashreload")?.setExecutor(TrashReloadCommand(this))

        // Register listeners
        server.pluginManager.registerEvents(InventoryListener(this), this)

        // Plugin startup logic
        logger.info("Trash plugin enabled")
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Trash plugin disabled")
    }
}
