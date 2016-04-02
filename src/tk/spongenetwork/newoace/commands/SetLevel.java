package tk.spongenetwork.newoace.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetLevel implements CommandExecutor {
    File playerLevelYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerLevel.yml");
    FileConfiguration playerLevelConfig = YamlConfiguration.loadConfiguration(playerLevelYml);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String args, String[] arg3) {
        if (sender instanceof Player) {
            playerLevelConfig.set(sender.getName(), arg3[0]);
            try {
                playerLevelConfig.save(playerLevelYml);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true ;
        } else {
            return false ;
        }
    }
}
