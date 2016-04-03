package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ArmorEquipEvent implements Listener {
    File playerArmorLevelYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerArmorLevel.yml");
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
    List<Material> diamond = new ArrayList<>();
    List<Material> iron = new ArrayList<>();
    List<Material> gold = new ArrayList<>();
    List<Material> chain = new ArrayList<>();
    ItemStack[] armor = new ItemStack[0];

    public void onInventoryClick(InventoryClickEvent event) {
        Bukkit.broadcastMessage("event");
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
        armor = event.getWhoClicked().getInventory().getArmorContents();
        for (int i = 0; i > armor.length; i++) {
            for (Material j : diamond) {
                if (!(playerArmorLevelConfig.getInt(event.getWhoClicked().getName()) >= 50) && (armor[i].getType() == j)) {
                    ItemStack item = event.getCurrentItem();
                    event.getCurrentItem().setAmount(0);
                    int firstEmpty = event.getWhoClicked().getInventory().firstEmpty();
                    event.getWhoClicked().getInventory().setItem(firstEmpty, item);
                }
            }
        }
    }

}
