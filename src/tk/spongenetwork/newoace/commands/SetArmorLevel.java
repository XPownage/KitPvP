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

public class SetArmorLevel implements CommandExecutor {
    File playerArmorLevelYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerArmorLevel.yml");
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String args, String[] arg3) {
        if (sender instanceof Player) {
            playerArmorLevelConfig.set(sender.getName(), arg3[0]);
            try {
                playerArmorLevelConfig.save(playerArmorLevelYml);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

}
