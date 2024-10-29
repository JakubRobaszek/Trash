package me.fini69.trash.listeners

import me.fini69.trash.Trash
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

@Suppress("DEPRECATION")
class InventoryListener(private val plugin: Trash): Listener {
    @EventHandler
    fun onInventoryClose(event: InventoryCloseEvent) {
        // Clear any remaining items in the trash inventory when closed
        val inventoryTitle = plugin.config.getString("trash.inventoryTitle", "Trash bin")
        if (event.view.title == inventoryTitle.toString()) {
            event.inventory.clear()
        }
    }
}