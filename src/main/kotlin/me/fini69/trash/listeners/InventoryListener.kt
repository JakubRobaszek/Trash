@file:Suppress("DEPRECATION")

package me.fini69.trash.listeners

import me.fini69.trash.Trash
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import java.lang.reflect.Method

class InventoryListener(private val plugin: Trash) : Listener {
    // Reflection method to get the title of an inventory view (we are checking this because the method is not available in all versions)
    private val getTitleMethod: Method? = try {
        val method = Class.forName("org.bukkit.inventory.InventoryView").getMethod("getTitle")
        // Make the method accessible
        method.isAccessible = true
        method
    } catch (_: Exception) {
        // If the method is not found, set it to null
        null
    }

    @EventHandler
    fun onInventoryClose(event: InventoryCloseEvent) {
        // Get the inventory title
        val inventoryTitle = ChatColor.translateAlternateColorCodes('&', plugin.config.getString("trash.inventoryTitle", "Trash bin").toString())
        val title = getTitleMethod?.invoke(event.view) as? String ?: event.view.title
        // Clear any remaining items in the trash inventory when closed
        if (title == inventoryTitle) {
            event.inventory.clear()
        }
    }
}