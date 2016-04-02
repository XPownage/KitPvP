package tk.spongenetwork.newoace.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Rank implements CommandExecutor {
    File playerLevelYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerLevel.yml");
    FileConfiguration playerLevelConfig = YamlConfiguration.loadConfiguration(playerLevelYml);
    File playerArmorLevelYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerArmorLevel.yml");
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            try {
                playerArmorLevelConfig.load(playerArmorLevelYml);
            } catch (IOException | InvalidConfigurationException e1) {
                e1.printStackTrace();
            }
            try {
                playerLevelConfig.load(playerLevelYml);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
            Player player = (Player) sender;
            player.sendMessage(
                    ChatColor.BLUE + "Armor Level is [" + playerArmorLevelConfig.getString(player.getName())
                            + "], Sword Level is [" + playerLevelConfig.getString(player.getName()) + "]");
            return true;

        } else {
            return false ;
        }
    }

}
