/*
 * Example Pulled From
 * https://github.com/Exceptionflug/protocolize/blob/master/protocolize-examples/src/main/java/de/exceptionflug/protocolize/example/PlayerInventoryExample.java
 */

package inventorycommands.inventorycommands.inventories;

import de.exceptionflug.protocolize.inventory.Inventory;
import de.exceptionflug.protocolize.inventory.InventoryModule;
import de.exceptionflug.protocolize.inventory.InventoryType;
import de.exceptionflug.protocolize.inventory.event.InventoryClickEvent;
import de.exceptionflug.protocolize.items.InventoryManager;
import de.exceptionflug.protocolize.items.ItemStack;
import de.exceptionflug.protocolize.items.ItemType;
import de.exceptionflug.protocolize.items.PlayerInventory;
import de.exceptionflug.protocolize.items.event.PlayerInteractEvent;
import inventorycommands.inventorycommands.InventoryCommands;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class ChestFour implements Listener {
    public ChestFour(final Plugin plugin) {
        ProxyServer.getInstance().getPluginManager().registerListener(plugin, this);
    }

    public void setItems(final ProxiedPlayer player) {
        // Gets the player inventory
        Inventory inventory = new Inventory(InventoryType.GENERIC_9X4, new TextComponent("§9Inventory title"));

        int protocolversion = player.getPendingConnection().getVersion();
        int size = 36;
        int rows = 4;

        int bottomLeft = (size/rows) * (rows-1);
        int bottomRight = size - 1;

        // A simple item
        final ItemStack item = new ItemStack(ItemType.SPRUCE_SIGN);
        item.setDisplayName("§6Click me (Protocol): " + protocolversion);
        inventory.setItem(bottomLeft, item); // NOTICE: You have to use the minecraft slot indexes! See: https://wiki.vg/Inventory#Windows

        // Another simple item
        final ItemStack item2 = new ItemStack(ItemType.BLUE_WOOL);
        item2.setDisplayName("§aThis is a test");
        inventory.setItem(bottomRight, item2);

        InventoryModule.sendInventory(player, inventory);
    }

    @EventHandler
    public void onClick(final InventoryClickEvent event) {
        final ItemStack itemStack = event.getClickedItem();
        final ProxiedPlayer player = event.getPlayer();
        if(itemStack != null) {
            if(itemStack.getType() == ItemType.SPRUCE_SIGN) {
                player.sendMessage("§6You interacted with a spruce sign!");
            }

            if(itemStack.getType() == ItemType.BLUE_WOOL) {
                player.sendMessage("§6Closing Inventory!");

                InventoryModule.closeAllInventories(player);
            }
        }
    }

}