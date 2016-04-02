package tk.spongenetwork.newoace.events;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CheckItem implements Listener {
    File playerLevelYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerLevel.yml");
    FileConfiguration playerLevelConfig = YamlConfiguration.loadConfiguration(playerLevelYml);
    File playerExpYml = new File(Bukkit.getPluginManager().getPlugin("test").getDataFolder() + "/PlayerExp.yml");
    FileConfiguration playerExpConfig = YamlConfiguration.loadConfiguration(playerExpYml);

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Entity damager = event.getDamager();
            Entity damagee = event.getEntity();
            Player player = (Player) damager;
            if ((damager.getType() == (EntityType.PLAYER)) && (damagee.getType() == EntityType.PLAYER)) {
                if (!(player.getItemInHand().getType().equals(Material.AIR))) {
                    if (player.getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
                        if (playerLevelConfig.getInt(player.getName()) < 50) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GOLD + "You are not high enough level");
                        }
                    } else if (player.getItemInHand().getType().equals(Material.GOLD_SWORD)) {
                        if (playerLevelConfig.getInt(player.getName()) < 10) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GOLD + "You are not high enough level");
                        }
                    } else if (player.getItemInHand().getType().equals(Material.IRON_SWORD)) {
                        if (playerLevelConfig.getInt(player.getName()) < 25) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GOLD + "You are not high enough level");
                        }
                    } else if (player.getItemInHand().getType().equals(Material.STONE_SWORD)) {
                        if (playerLevelConfig.getInt(player.getName()) < 5) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GOLD + "You are not high enough level");
                        }
                    } else if (player.getItemInHand().getType().equals(Material.WOOD_SWORD)) {
                        if (playerLevelConfig.getInt(player.getName()) < 1) {
                            event.setCancelled(true);
                            player.sendMessage(ChatColor.GOLD + "You are not high enough level");
                        }
                    }
                }
            }
        }
    }
}