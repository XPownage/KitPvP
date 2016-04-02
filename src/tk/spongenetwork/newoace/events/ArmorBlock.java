package tk.spongenetwork.newoace.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ArmorBlock implements Listener {
    File playerArmorLevelYml = new File(
            Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerArmorLevel.yml");
    FileConfiguration playerArmorLevelConfig = YamlConfiguration.loadConfiguration(playerArmorLevelYml);
    File playerArmorExpYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder()+"/PlayerArmorExp.yml") ;
    FileConfiguration playerArmorExpConfig = YamlConfiguration.loadConfiguration(playerArmorExpYml) ;

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) throws IOException {
        if (e.getEntity().getType() == (EntityType.PLAYER) && e.getDamager().getType() == EntityType.PLAYER) {
            Player attacked = (Player) e.getEntity();
            Player attacke = (Player) e.getDamager();
            Material heldItem = attacke.getItemInHand().getType();
            double deflectChance = 1 * playerArmorLevelConfig.getInt(e.getEntity().getName()) * 0.03;
            if (!(attacked.getInventory().getBoots() == null)) {
                if (attacked.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS) {
                    deflectChance *= 2;
                } else if (attacked.getInventory().getBoots().getType() == Material.GOLD_BOOTS) {
                    deflectChance *= 1;
                } else if (attacked.getInventory().getBoots().getType() == Material.IRON_BOOTS) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
                    deflectChance *= 1;
                }
            }
            if (!(attacked.getInventory().getChestplate() == null)) {
                if (attacked.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
                    deflectChance *= 2;
                } else if (attacked.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE) {
                    deflectChance *= 1;
                } else if (attacked.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                    deflectChance *= 1;
                }
            }
            if (!(attacked.getInventory().getLeggings() == null)) {
                if (attacked.getInventory().getLeggings().getType() == Material.CHAINMAIL_LEGGINGS) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getLeggings().getType() == Material.DIAMOND_LEGGINGS) {
                    deflectChance *= 2;
                } else if (attacked.getInventory().getLeggings().getType() == Material.GOLD_LEGGINGS) {
                    deflectChance *= 1;
                } else if (attacked.getInventory().getLeggings().getType() == Material.IRON_LEGGINGS) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS) {
                    deflectChance *= 1;
                }
            }
            if (!(attacked.getInventory().getHelmet() == null)) {
                if (attacked.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET) {
                    deflectChance *= 2;
                } else if (attacked.getInventory().getHelmet().getType() == Material.GOLD_HELMET) {
                    deflectChance *= 1;
                } else if (attacked.getInventory().getHelmet().getType() == Material.IRON_HELMET) {
                    deflectChance *= 1.5;
                } else if (attacked.getInventory().getHelmet().getType() == Material.LEATHER_HELMET) {
                    deflectChance *= 1;
                }
            }
            if (heldItem == Material.DIAMOND_SWORD || heldItem == Material.GOLD_SWORD || heldItem == Material.IRON_SWORD
                    || heldItem == Material.STONE_SWORD || heldItem == Material.WOOD_SWORD) {
                if (heldItem == Material.DIAMOND_SWORD) {
                    deflectChance *= .9;
                } else if (heldItem == Material.GOLD_SWORD) {
                    deflectChance *= .98;
                } else if (heldItem == Material.IRON_SWORD) {
                    deflectChance *= .95;
                } else if (heldItem == Material.STONE_SWORD) {
                    deflectChance *= .97;
                } else if (heldItem == Material.WOOD_SWORD) {
                    deflectChance *= .98;
                }
            }
            Random random = new Random();
            int chance = random.nextInt(1000);
            if (chance > (deflectChance * 10)) {

            } else {
                e.setCancelled(true);
                e.getEntity().sendMessage(ChatColor.GOLD + "You successfully blocked a hit");
                int level = playerArmorLevelConfig.getInt(e.getEntity().getName()) ;
                int origionalExp = playerArmorExpConfig.getInt(e.getEntity().getName()) ;
                double expNextLevel = 0 ;
                expNextLevel = level * 1.5 * 250;
                origionalExp += 50;
                if (!(level >= 50)) {
                    if (origionalExp >= expNextLevel) {
                        level += 1 ;
                        origionalExp -= expNextLevel ;
                        e.getEntity().sendMessage(ChatColor.GOLD + "Defense leveled up");
                    }
                }
                playerArmorLevelConfig.set(e.getEntity().getName(), level);
                playerArmorExpConfig.set(e.getEntity().getName(), origionalExp);
                playerArmorExpConfig.save(playerArmorExpYml);
                playerArmorLevelConfig.save(playerArmorLevelYml);
            }
        }
    }
}
