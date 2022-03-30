package com.un2dies;

import com.un2dies.events.RegisterEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class pack extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        System.out.println("[Un2dies] onEnable");
        RegisterEvent();
    }

    @Override
    public void onDisable() {
        System.out.println("[Un2dies] onDisable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            player.sendMessage(args[0]);
        }
        return super.onCommand(sender, command, label, args);
    }

    public void RegisterEvent(){
        new RegisterEvents(this);
//        getServer().getPluginManager().registerEvents(new main(this),this);
    }
}
