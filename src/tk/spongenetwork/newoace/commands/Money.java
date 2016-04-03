package tk.spongenetwork.newoace.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Money implements CommandExecutor {
    File playerMoneyYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerMoney.yml");
    FileConfiguration playerMoneyConfig = YamlConfiguration.loadConfiguration(playerMoneyYml);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(("Balance: $") + playerMoneyConfig.getString(sender.getName()));
            return true;
        }
        return false;
    }
}
