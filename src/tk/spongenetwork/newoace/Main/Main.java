package tk.spongenetwork.newoace.Main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import tk.spongenetwork.newoace.commands.Money;
import tk.spongenetwork.newoace.commands.Rank;
import tk.spongenetwork.newoace.commands.SetArmorLevel;
import tk.spongenetwork.newoace.commands.SetLevel;
import tk.spongenetwork.newoace.events.ArmorBlock;
import tk.spongenetwork.newoace.events.ArmorEquipEvent;
import tk.spongenetwork.newoace.events.CheckItem;
import tk.spongenetwork.newoace.events.LevelUp;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin implements Listener {
    File playerLevelYml = new File(this.getDataFolder()+"/PlayerLevel.yml");
    FileConfiguration playerLevelConfig = YamlConfiguration.loadConfiguration(playerLevelYml);
    File playerExpYml = new File(this.getDataFolder()+"/PlayerExp.yml") ;
    FileConfiguration playerExpConfig = YamlConfiguration.loadConfiguration(playerExpYml) ;
    File playerArmorLevelYml = new File(this.getDataFolder()+"/PlayerArmorLevel.yml") ;
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml) ;
    File playerArmorExpYml = new File(this.getDataFolder()+"/PlayerArmorExp.yml") ;
    FileConfiguration playerArmorExpConfig = YamlConfiguration.loadConfiguration(playerArmorExpYml) ;
    File playerMoneyYml = new File(this.getDataFolder()+"/PlayerMoney.yml") ;
    FileConfiguration playerMoneyConfig = YamlConfiguration.loadConfiguration(playerMoneyYml) ;
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults();
        getServer().getPluginManager().registerEvents(new ArmorEquipEvent(), this);
        getServer().getPluginManager().registerEvents(new ArmorBlock(), this);
        getServer().getPluginManager().registerEvents(new LevelUp(), this);
        getServer().getPluginManager().registerEvents(new CheckItem(), this);
        getServer().getPluginManager().registerEvents(this, this);
        saveCustomYml(playerLevelConfig, playerLevelYml);
        saveCustomYml(playerExpConfig, playerExpYml);
        saveCustomYml(playerArmorLevelConfig, playerArmorLevelYml);
        saveCustomYml(playerArmorExpConfig, playerArmorExpYml);
        saveCustomYml(playerMoneyConfig, playerMoneyYml);
        this.getCommand("rank").setExecutor(new Rank());
        this.getCommand("money").setExecutor(new Money());
        this.getCommand("setswordlevel").setExecutor(new SetLevel());
        this.getCommand("setarmorlevel").setExecutor(new SetArmorLevel());
    }

    public void onDisable() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!(event.getPlayer().hasPlayedBefore())) {
            this.playerLevelConfig.createSection(event.getPlayer().getName()) ;
            this.playerLevelConfig.set(event.getPlayer().getName(), 1);
            this.playerExpConfig.createSection(event.getPlayer().getName()) ;
            this.playerExpConfig.set(event.getPlayer().getName(), 0);
            this.playerArmorLevelConfig.createSection(event.getPlayer().getName()) ;
            this.playerArmorLevelConfig.set(event.getPlayer().getName(), 1);
            this.playerArmorExpConfig.createSection(event.getPlayer().getName()) ;
            this.playerArmorExpConfig.set(event.getPlayer().getName(), 1);
            this.playerMoneyConfig.createSection(event.getPlayer().getName()) ;
            this.playerMoneyConfig.set(event.getPlayer().getName(), 0);
            saveCustomYml(playerMoneyConfig, playerMoneyYml);
            saveCustomYml(playerArmorLevelConfig, playerArmorLevelYml);
            saveCustomYml(playerLevelConfig, playerLevelYml);
            saveCustomYml(playerExpConfig, playerExpYml);
            saveCustomYml(playerArmorExpConfig, playerArmorExpYml);
        }
    }

    public void saveCustomYml(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
