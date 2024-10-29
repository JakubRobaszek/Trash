@file:Suppress("DEPRECATION")

package me.fini69.trash.commands

import me.fini69.trash.Trash
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class TrashReloadCommand(private val plugin: Trash) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        // Reload config
        plugin.reloadConfig()
        val prefix = plugin.config.getString("trash.prefix", "&8[&bTrash&8] &r")
        val trashMessage = plugin.config.getString("trash.reloadMessage", "Trash config reloaded!")
        // Send message when config is reloaded
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + trashMessage.toString()))
        return true
    }
}