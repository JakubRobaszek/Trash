@file:Suppress("DEPRECATION")

package me.fini69.trash.commands

import me.fini69.trash.Trash
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class TrashCommand(private val plugin: Trash) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player) {
            // check if player has permission
            if (!sender.hasPermission("trash.use")) {
                val noPermissionMessage = plugin.config.getString("trash.noPermission", "&cYou do not have permission to use this command.")
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', noPermissionMessage.toString()))
                return true
            }
            // open trash inventory
            val inventoryTitle = plugin.config.getString("trash.inventoryTitle", "&bTrash Bin")
            var inventoryRows = plugin.config.getInt("trash.inventoryRows", 6)
            // Checking if inventory rows are between 1 and 6 (it can't be more than 6)
            if (inventoryRows > 6) {
                inventoryRows = 6
            } else if (inventoryRows < 1) {
                inventoryRows = 1
            }
            // create and open inventory
            val trashInventory: Inventory = Bukkit.createInventory(null, 9 * inventoryRows, ChatColor.translateAlternateColorCodes('&', inventoryTitle.toString()))
            sender.openInventory(trashInventory)
            // send message (or not) when trash is opened
            val message = plugin.config.getString("trash.openMessage", "Trash bin opened! Put items you want to delete in here.")
            val prefix = plugin.config.getString("trash.prefix", "&8[&bTrash&8] &r")
            val check = plugin.config.getBoolean("trash.sendOpenMessage", true)
            // check if message should be sent
            if (check) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message.toString()))
            }
            return true
        } else {
            // send message if sender is not a player
            val prefix = plugin.config.getString("trash.prefix", "&8[&bTrash&8] &r")
            val message = plugin.config.getString("trash.notPlayerMessage", "Only players can use this command!")
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message.toString()))
            return false
        }
    }
}