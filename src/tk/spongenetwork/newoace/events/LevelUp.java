package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.IOException;

public class LevelUp implements Listener {
    File playerLevelYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerLevel.yml");
    FileConfiguration playerLevelConfig = YamlConfiguration.loadConfiguration(playerLevelYml);
    File playerExpYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerExp.yml");
    FileConfiguration playerExpConfig = YamlConfiguration.loadConfiguration(playerExpYml);

    @EventHandler
    public void onKill(PlayerDeathEvent e) throws IOException {
        double exp = playerExpConfig.getInt(e.getEntity().getKiller().getName());
        Integer level = playerLevelConfig.getInt(e.getEntity().getKiller().getName());
        double expNextLevel = 0 ;
        for (int i = 0 ; i <= level ; i++) {
            expNextLevel = 1.6 * 250;
        }
        exp += 50;
        if (!(level >= 50)) {
            if (exp >= expNextLevel) {
                level += 1;
                exp -= expNextLevel;
                e.getEntity().getKiller().sendMessage(ChatColor.GOLD + "You Leveled up to Level: " + level);
            }
        }
        playerExpConfig.set(e.getEntity().getKiller().getName(), exp);
        playerLevelConfig.set(e.getEntity().getKiller().getName(), level);
        playerExpConfig.save(playerExpYml);
        playerLevelConfig.save(playerLevelYml);
    }
}
