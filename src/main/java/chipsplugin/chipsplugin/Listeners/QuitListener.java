package chipsplugin.chipsplugin.Listeners;

import chipsplugin.chipsplugin.scoreboard.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        int max, onlinecount;
        max = Bukkit.getMaxPlayers();
        onlinecount = Bukkit.getOnlinePlayers().size();
        event.setQuitMessage(ChatColor.GOLD+player.getName()+ChatColor.YELLOW+" left the server! "+ChatColor.AQUA+"("+ChatColor.YELLOW+ (onlinecount-1) +ChatColor.GOLD+"/"+ChatColor.YELLOW+max+ChatColor.AQUA+")");
        new MainScoreboard(player);
    }
}
