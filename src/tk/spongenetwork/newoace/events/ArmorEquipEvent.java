package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
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

    public void onInventoryClick(InventoryClickEvent event) {
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
        if (event.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
            for (Material i : diamond) {
                if (!(playerArmorLevelConfig.getInt(event.getWhoClicked().getName()) >= 50) && event.getCurrentItem().getType().equals(i)) {
                    ItemStack item = event.getCurrentItem();
                    event.getCurrentItem().setAmount(0);
                    int firstEmpty = event.getWhoClicked().getInventory().firstEmpty();
                    event.getWhoClicked().getInventory().setItem(firstEmpty, item);
                }
            }
        }
    }

}
