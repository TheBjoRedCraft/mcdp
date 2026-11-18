package dev.thebjoredcraft.mcdp

import com.github.retrooper.packetevents.PacketEvents
import com.github.retrooper.packetevents.PacketEventsAPI
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(PluginMain::class.java)

class PluginMain : JavaPlugin(), Listener {
    override fun onEnable() {
        PacketEvents.getAPI().eventManager.registerListener(ModListener)
    }
}