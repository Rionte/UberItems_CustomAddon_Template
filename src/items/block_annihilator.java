package items;

import java.util.List;

import net.minecraft.server.v1_16_R3.ItemFireworks;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import thirtyvirus.uber.UberItem;
import thirtyvirus.uber.helpers.*;

public class block_annihilator extends UberItem {

    public block_annihilator(Material material, String name, UberRarity rarity, boolean stackable, boolean oneTimeUse, boolean hasActiveEffect, List<UberAbility> abilities, UberCraftingRecipe craftingRecipe) {
        super(material, name, rarity, stackable, oneTimeUse, hasActiveEffect, abilities, craftingRecipe);
    }
    public void onItemStackCreate(ItemStack item) { }
    public void getSpecificLorePrefix(List<String> lore, ItemStack item) { }
    public void getSpecificLoreSuffix(List<String> lore, ItemStack item) { }

    public boolean leftClickAirAction(Player player, ItemStack item) { return false; }
    public boolean leftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
        return false;
    }
    public boolean rightClickAirAction(Player player, ItemStack item) {
        return false;
    }
    public boolean rightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
        block.setType(Material.AIR);
        return false;
    }
    public boolean shiftLeftClickAirAction(Player player, ItemStack item) { return false; }
    public boolean shiftLeftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { return false; }
    public boolean shiftRightClickAirAction(Player player, ItemStack item) { return false; }
    public boolean shiftRightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { return false; }

    public boolean middleClickAction(Player player, ItemStack item) { return false; }
    public boolean hitEntityAction(Player player, EntityDamageByEntityEvent event, Entity target, ItemStack item) { return false; }
    public boolean breakBlockAction(Player player, BlockBreakEvent event, Block block, ItemStack item) {
        if (block.getType().equals(Material.DIAMOND_ORE)) {
            block.setType(Material.DIAMOND_BLOCK);
        } else if (block.getType().equals(Material.IRON_ORE)) {
            block.setType(Material.IRON_BLOCK);
        } else if (block.getType().equals(Material.COAL_ORE)) {
            block.setType(Material.COAL_BLOCK);
        } else if (block.getType().equals(Material.GOLD_ORE)) {
            block.setType(Material.GOLD_BLOCK);
        } else if (block.getType().equals(Material.LAPIS_ORE)) {
            block.setType(Material.LAPIS_BLOCK);
        } else if (block.getType().equals(Material.ANCIENT_DEBRIS)) {
            block.setType(Material.NETHERITE_BLOCK);
        } else if (block.getType().equals(Material.REDSTONE_ORE)) {
            block.setType(Material.REDSTONE_BLOCK);
        } else if (block.getType().equals(Material.EMERALD_ORE)) {
            block.setType(Material.EMERALD_BLOCK);
        } else {
            block.getRelative(BlockFace.NORTH).setType(Material.AIR);
            block.getRelative(BlockFace.SOUTH).setType(Material.AIR);
            block.getRelative(BlockFace.EAST).setType(Material.AIR);
            block.getRelative(BlockFace.WEST).setType(Material.AIR);
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 60, 2));
        return false;
    }
    public boolean clickedInInventoryAction(Player player, InventoryClickEvent event, ItemStack item, ItemStack addition) { return false; }
    public boolean activeEffect(Player player, ItemStack item) { return false; }
}
