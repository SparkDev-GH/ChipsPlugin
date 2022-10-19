package chipsplugin.chipsplugin.Listeners;

import chipsplugin.chipsplugin.scoreboard.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        int max, onlinecount;
        max = Bukkit.getMaxPlayers();
        onlinecount = Bukkit.getOnlinePlayers().size();

        event.setJoinMessage(ChatColor.GOLD + player.getName()+ChatColor.YELLOW + " just showed up! " + ChatColor.AQUA + "(" + ChatColor.YELLOW + onlinecount + ChatColor.GOLD + "/" + ChatColor.YELLOW + max + ChatColor.AQUA + ")");
        player.teleport(new Location(Bukkit.getWorld("world"), -71, 72, 128));

        new MainScoreboard(player);
    }
}
