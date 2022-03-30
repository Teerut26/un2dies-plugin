package com.un2dies.events;

import com.un2dies.pack;

public class RegisterEvents {
    public pack plugin;

    public RegisterEvents(pack pack) {
        plugin = pack;
        this.plugin.getServer().getPluginManager().registerEvents(new JoinAndLeave(this.plugin), this.plugin);
    }
}
