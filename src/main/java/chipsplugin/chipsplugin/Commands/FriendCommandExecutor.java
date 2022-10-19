package chipsplugin.chipsplugin.Commands;

import chipsplugin.chipsplugin.Main;
import chipsplugin.chipsplugin.Utils.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FriendCommandExecutor implements CommandExecutor {
    Config config;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        config = Main.getInstance().getConfiguration();

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage:\n/" + label + " accept <name>\n/" + label + " remove <name>\n/" + label + " list");
            return true;
        }

        switch (args[0]) {
            case "accept": {

                break;
            }
            case "remove":{
                if (args.length == 1){
                    sender.sendMessage("You have no friend :(");
                }
                break;
            }
            case "list": {
                if (!config.getConfig().contains("friends." + sender.getName())) {
                    sender.sendMessage("You have no friends :(");
                }
                for (String name : config.getConfig().getStringList("friends." + sender.getName())) {
                    sender.sendMessage(name);
                }
                break;
            }
        }

        return false;
    }
}
