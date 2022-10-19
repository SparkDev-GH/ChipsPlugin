package chipsplugin.chipsplugin.scoreboard;

import chipsplugin.chipsplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MainScoreboard extends ScoreboardBuilder{

    private int infoID;

    public MainScoreboard(Player player) {
        super(player, ChatColor.WHITE.toString() + ChatColor.BOLD + "CHIPSMINE.NET");
        infoID = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.RED.toString(), 4);
        setScore(ChatColor.BLUE.toString(), 3);
        setScore(ChatColor.RESET.toString(), 2);
        setScore(ChatColor.GRAY + "Server IP:", 1);
        setScore(ChatColor.DARK_GRAY + "chipsmine.net", 0);
    }


    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (infoID) {
                    case 0:
                        setScore(ChatColor.DARK_BLUE.toString(), 6);
                        setScore(ChatColor.GREEN + "chipsmine.net                ",5);
                        break;
                    case 1:
                        setScore(ChatColor.DARK_BLUE + "Discord", 6);
                        setScore(ChatColor.DARK_BLUE + "https://discord.gg/Wv74hBc28R", 5);
                        break;
                }
                infoID++;

                if (infoID >= 2) {
                    infoID = 0;
                }

            }
        }.runTaskTimer(Main.getInstance(), 60, 60);
    }
}
