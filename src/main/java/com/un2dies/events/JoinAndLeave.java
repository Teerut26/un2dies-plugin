package com.un2dies.events;

import com.un2dies.pack;
import com.un2dies.util.DiscordWebhook;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class JoinAndLeave implements Listener {
    private String webhook_url;
    private String avatar_url;
    public pack plugin;

    public JoinAndLeave(pack plugin) {
        this.plugin = plugin;
        this.getConfigFile();
    }

    public void getConfigFile() {
        FileConfiguration config = this.plugin.getConfig();
        this.webhook_url = config.getString("webhook_url");
        this.avatar_url = config.getString("avatar_url");
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) throws IOException {
        System.out.println("PlayerDropItemEvent");
        DiscordWebhook discordWebhook = new DiscordWebhook(webhook_url);
        discordWebhook.setAvatarUrl(avatar_url);
        discordWebhook.setUsername("un2dies");
        String content = event.getPlayer().getName() + " Join To Server";
        discordWebhook.setContent(content);
        discordWebhook.execute();
    }

    @EventHandler
    public void PlayerDropItemEvent(PlayerQuitEvent event) throws IOException {
        System.out.println("PlayerDropItemEvent");
        DiscordWebhook discordWebhook = new DiscordWebhook(webhook_url);
        discordWebhook.setAvatarUrl(avatar_url);
        discordWebhook.setUsername("un2dies");
        String content = event.getPlayer().getName() + " Quit From Server";
        discordWebhook.setContent(content);
        discordWebhook.execute();
    }
}
