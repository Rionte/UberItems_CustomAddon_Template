package items;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import net.minecraft.server.v1_16_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_16_R3.Particles;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import sun.plugin2.main.client.PluginMain;
import thirtyvirus.uber.UberItem;
import thirtyvirus.uber.UberItems;
import thirtyvirus.uber.helpers.*;

public class hyperion extends UberItem {

    public hyperion(Material material, String name, UberRarity rarity, boolean stackable, boolean oneTimeUse, boolean hasActiveEffect, List<UberAbility> abilities, UberCraftingRecipe craftingRecipe) {
        super(material, name, rarity, stackable, oneTimeUse, hasActiveEffect, abilities, craftingRecipe);
    }
    public void onItemStackCreate(ItemStack item) {
        item.addEnchantment(Enchantment.MENDING, 1);
    }
    public void getSpecificLorePrefix(List<String> lore, ItemStack item) { }
    public void getSpecificLoreSuffix(List<String> lore, ItemStack item) { }

    public boolean leftClickAirAction(Player player, ItemStack item) { return false; }
    public boolean leftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { return false; }
    public boolean rightClickAirAction(Player player, ItemStack item) {
        if (Utilities.enforceCooldown(player, "name", 3, item, false)) return false;
        Location location = player.getLocation();
        PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(Particles.EXPLOSION, true, location.getX(), location.getY(), location.getZ(),1,1,1,3,8);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(particles);
        player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 1);
        List<Entity> nearby =  player.getNearbyEntities(5,5,5);
        for (Entity tmp: nearby)
            if (tmp instanceof Damageable)
                ((Damageable) tmp).damage(50);
        player.setAbsorptionAmount(4.0);
        player.setHealth(player.getHealth()+4);
        return false;
    }
    public boolean rightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
        if (Utilities.enforceCooldown(player, "name", 3, item, false)) return false;
        Location location = player.getLocation();
        PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(Particles.EXPLOSION, true, location.getX(), location.getY(), location.getZ(),1,1,1,3,8);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(particles);
        player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 1);
        List<Entity> nearby =  player.getNearbyEntities(5,5,5);
        for (Entity tmp: nearby)
            if (tmp instanceof Damageable)
                ((Damageable) tmp).damage(50);
        player.setAbsorptionAmount(4.0);
        player.setHealth(player.getHealth()+4);
        return false;
    }
    public boolean shiftLeftClickAirAction(Player player, ItemStack item) { return false; }
    public boolean shiftLeftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { return false; }
    public boolean shiftRightClickAirAction(Player player, ItemStack item) { return false; }
    public boolean shiftRightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { return false; }

    public boolean middleClickAction(Player player, ItemStack item) { return false; }
    public boolean hitEntityAction(Player player, EntityDamageByEntityEvent event, Entity target, ItemStack item) { return false; }
    public boolean breakBlockAction(Player player, BlockBreakEvent event, Block block, ItemStack item) {
        for(BlockFace face : BlockFace.values()) {
            if (event.getBlock().getRelative(face).getType() == Material.BIRCH_LOG) {
                Block adjacent = event.getBlock().getRelative(face);
            }
        }
        return false;
    }
    public boolean clickedInInventoryAction(Player player, InventoryClickEvent event, ItemStack item, ItemStack addition) { return false; }
    public boolean activeEffect(Player player, ItemStack item) { return false; }
}
