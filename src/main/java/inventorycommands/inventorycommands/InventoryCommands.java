package inventorycommands.inventorycommands;

import inventorycommands.inventorycommands.commands.*;
import net.md_5.bungee.api.plugin.Plugin;

public final class InventoryCommands extends Plugin {
    public PlayerInventoryExample inventoryExample;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getProxy().getPluginManager().registerCommand(this, new Test(this));

        inventoryExample = new PlayerInventoryExample(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getProxy().getPluginManager().unregisterCommands(this);
    }
}
