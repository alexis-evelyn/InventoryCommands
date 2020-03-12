package inventorycommands.inventorycommands;

import inventorycommands.inventorycommands.commands.*;
import inventorycommands.inventorycommands.inventories.ChestFour;
import net.md_5.bungee.api.plugin.Plugin;

public final class InventoryCommands extends Plugin {
    public ChestFour inventoryExample;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getProxy().getPluginManager().registerCommand(this, new Test(this));

        inventoryExample = new ChestFour(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getProxy().getPluginManager().unregisterCommands(this);
    }
}
