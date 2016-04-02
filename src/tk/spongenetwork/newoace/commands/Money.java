package tk.spongenetwork.newoace.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Money implements CommandExecutor {

    File PlayerMoneyYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerMoney.yml");
    FileConfiguration PlayerMoney = YamlConfiguration.loadConfiguration(PlayerMoneyYml);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            try {
                PlayerMoney.load(PlayerMoneyYml);
            } catch (IOException | InvalidConfigurationException e1) {
                e1.printStackTrace();
            }
            Player player = (Player) sender;
            player.sendMessage(
                    ChatColor.GOLD + "Money [" + PlayerMoney.getString(player.getName()));
            return true;
        } else {
            return false;
        }
    }

}
