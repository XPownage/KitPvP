package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArmorEquipEvent implements Listener {
    File playerArmorLevelYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerArmorLevel.yml");
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
    public void onArmorEquip (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked() ;
        List<Material> blackList = new ArrayList<>() ;
        List<Material> diamond = new ArrayList<>() ;
        List<Material> iron = new ArrayList<>() ;
        List<Material> gold = new ArrayList<>() ;
        List<Material> chain = new ArrayList<>() ;
        blackList.add(Material.DIAMOND_CHESTPLATE) ;
        blackList.add(Material.DIAMOND_HELMET  ) ;
        blackList.add(Material.DIAMOND_LEGGINGS) ;
        blackList.add(Material.DIAMOND_BOOTS) ;
        blackList.add(Material.IRON_HELMET) ;
        blackList.add(Material.IRON_CHESTPLATE) ;
        blackList.add(Material.IRON_LEGGINGS) ;
        blackList.add(Material.IRON_BOOTS) ;
        blackList.add(Material.GOLD_HELMET) ;
        blackList.add(Material.GOLD_CHESTPLATE) ;
        blackList.add(Material.GOLD_LEGGINGS) ;
        blackList.add(Material.GOLD_BOOTS) ;
        blackList.add(Material.CHAINMAIL_BOOTS) ;
        blackList.add(Material.CHAINMAIL_CHESTPLATE) ;
        blackList.add(Material.CHAINMAIL_HELMET) ;
        blackList.add(Material.CHAINMAIL_LEGGINGS) ;
        diamond.add(Material.DIAMOND_CHESTPLATE);
        diamond.add(Material.DIAMOND_HELMET);
        diamond.add(Material.DIAMOND_LEGGINGS);
        diamond.add(Material.DIAMOND_BOOTS);
        iron.add(Material.IRON_HELMET);
        iron.add(Material.IRON_CHESTPLATE);
        iron.add(Material.IRON_LEGGINGS);
        iron.add(Material.IRON_BOOTS);
        gold.add(Material.GOLD_HELMET);
        gold.add(Material.GOLD_CHESTPLATE);
        gold.add(Material.GOLD_LEGGINGS);
        gold.add(Material.GOLD_BOOTS);
        chain.add(Material.CHAINMAIL_HELMET);
        chain.add(Material.CHAINMAIL_CHESTPLATE);
        chain.add(Material.CHAINMAIL_LEGGINGS);
        chain.add(Material.CHAINMAIL_BOOTS);
        for (Material i : blackList) {
            if (event.getCurrentItem().getType().equals(i)) {
                if (!(playerArmorLevelConfig.getInt(player.getName()) >= 50)) {

                }
            }
        }
    }
}
