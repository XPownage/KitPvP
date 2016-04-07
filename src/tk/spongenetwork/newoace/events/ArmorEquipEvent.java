package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.isCancelled()) return;
        playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
        ItemStack[] armor = event.getWhoClicked().getInventory().getArmorContents();
        int size = event.getWhoClicked().getInventory().getSize();
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
        if (event.isShiftClick() || event.isLeftClick() || event.isRightClick()) {
            for (int i = 0; i <= 3; i++) {
                if (event.getCurrentItem() != null) {
                    if ((playerArmorLevelConfig.getInt(event.getWhoClicked().getName())) < 5) {
                        if ((event.getCurrentItem().getType() == gold.get(i))) {
                            event.setCancelled(true);//I got it to work
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getWhoClicked().getName())) < 10) {
                        if ((event.getCurrentItem().getType() == chain.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getWhoClicked().getName())) < 25) {
                        if ((event.getCurrentItem().getType() == iron.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getWhoClicked().getName()) < 50)) {
                        if ((event.getCurrentItem().getType() == diamond.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @Deprecated
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.isCancelled()) return;
        playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
        ItemStack[] armor = event.getPlayer().getInventory().getArmorContents();
        int size = event.getPlayer().getInventory().getSize();
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
        for (int i = 0; i <= 3; i++) {
            if (event.hasBlock() || !(event.hasBlock())) {
                if (event.getItem() != null) {
                    if ((playerArmorLevelConfig.getInt(event.getPlayer().getName())) < 5) {
                        if ((event.getItem().getType() == gold.get(i))) {
                            event.setCancelled(true);//I got it to work
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getPlayer().getName())) < 10) {
                        if ((event.getItem().getType() == chain.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getPlayer().getName())) < 25) {
                        if ((event.getItem().getType() == iron.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                    if ((playerArmorLevelConfig.getInt(event.getPlayer().getName()) < 50)) {
                        if ((event.getItem().getType() == diamond.get(i))) {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
