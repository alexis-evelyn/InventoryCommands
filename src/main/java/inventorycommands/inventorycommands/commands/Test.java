package inventorycommands.inventorycommands.commands;

import inventorycommands.inventorycommands.InventoryCommands;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Test extends Command {
    InventoryCommands main;

    public Test(InventoryCommands passed) {
        super("inventorycommands");

        this.main = passed;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(new ComponentBuilder("Hello world!").color(ChatColor.GREEN).create());

        if (sender instanceof ProxiedPlayer) {
            this.main.inventoryExample.setItems((ProxiedPlayer) sender);
        }
    }
}