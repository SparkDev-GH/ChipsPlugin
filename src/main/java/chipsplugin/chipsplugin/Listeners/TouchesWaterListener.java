package chipsplugin.chipsplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TouchesWaterListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (e.getPlayer().getLocation().getBlock().isLiquid()) {
            e.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 127, 154, 151));
        }
    }
}
