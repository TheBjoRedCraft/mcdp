package dev.thebjoredcraft.mcdp

import com.github.retrooper.packetevents.event.PacketListenerAbstract
import com.github.retrooper.packetevents.event.PacketReceiveEvent
import com.github.retrooper.packetevents.protocol.packettype.PacketType
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPluginMessage
import org.bukkit.Bukkit

object ModListener : PacketListenerAbstract() {
    override fun onPacketReceive(event: PacketReceiveEvent) {
        if (event.packetType != PacketType.Play.Client.PLUGIN_MESSAGE) {
            return
        }

        val packet = WrapperPlayClientPluginMessage(event)

        if (packet.channelName == "minecraft:register") {
            val mods = String(packet.data)
                .split("\u0000")
                .mapNotNull { entry ->
                    val mod = entry.substringBefore(":", "").trim()

                    mod.ifBlank {
                        null
                    }
                }
                .distinct()
                .sorted()


            plugin.logger.info("Found ${mods.size} mod channels for ${event.user.name}: ${mods.joinToString(", ")}")
        }
    }
}