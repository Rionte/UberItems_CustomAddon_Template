import items.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import thirtyvirus.uber.UberItems;
import thirtyvirus.uber.UberMaterial;
import thirtyvirus.uber.helpers.AbilityType;
import thirtyvirus.uber.helpers.UberAbility;
import thirtyvirus.uber.helpers.UberCraftingRecipe;
import thirtyvirus.uber.helpers.UberRarity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class UberItemsAddon extends JavaPlugin {

    public void onEnable() {

        // enforce UberItems dependancy
        if (Bukkit.getPluginManager().getPlugin("UberItems") == null) {
            this.getLogger().severe("UberItems Addons requires UberItems! disabled because UberItems dependency not found");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // register events and UberItems
        registerEvents();
        registerUberMaterials();
        registerUberItems();

        // post confirmation in chat
        getLogger().info(getDescription().getName() + " V: " + getDescription().getVersion() + " has been enabled");
    }
    public void onDisable() {
        // posts exit message in chat
        getLogger().info(getDescription().getName() + " V: " + getDescription().getVersion() + " has been disabled");
    }
    private void registerEvents() {

    }

    // NEW UBER ITEM CHECKLIST

    // - make a new class file, named with all lowercase lettering and underscores for spaces
    // - copy the UberItemTemplate class contents into the new class, extend UberItem
    // - make a putItem entry, follow the format of previous items and make sure to give a unique id
    // - write the unique item ability code in the appropriate method

    // - add the following line of code just after executing the item's ability:
    //      onItemUse(player, item); // confirm that the item's ability has been successfully used

    // - if the ability needs a cooldown, prefix it's code with a variation of the following line of code:
    //      if (!Utilities.enforceCooldown(getMain(), player, "name", 1, item, true)) return;

    // - if the item needs work done on create (like adding enchantments, adding other data) refer to onItemStackCreate
    // - if the item needs a prefix or suffix in its description,
    //   refer to the getSpecificLorePrefix and getSpecificLoreSuffix functions, then add the following:
    //      lore.add(ChatColor.RESET + "text goes here");

    // - if you need to store & retrieve ints and strings from items, you can use the following functions:
    //      Utilities.storeIntInItem(getMain(), item, 1, "number tag");
    //      if (Utilities.getIntFromItem(getMain(), item, "number tag") == 1) // { blah blah blah }
    //      (the same case for strings, just storeStringInItem and getStringFromItem)

    private void registerUberItems() {
        UberItems.putItem("empty_item", new empty_item(Material.DIAMOND, "Empty UberItem", UberRarity.COMMON,
                false, false, false, Collections.emptyList(), null));

        UberItems.putItem("sword_of_saturation", new sword_of_saturation(Material.GOLDEN_SWORD, "Sword Of Saturation", UberRarity.RARE,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Saturate", AbilityType.RIGHT_CLICK, "Regen all your hunger.", 20),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.COOKED_PORKCHOP, 64),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.COOKED_PORKCHOP, 64),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STICK),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("guitar", new guitar(Material.WOODEN_SWORD, "Guitar", UberRarity.COMMON,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Bass Note", AbilityType.LEFT_CLICK, "Play the bass note."),
                        new UberAbility("Chime Note", AbilityType.RIGHT_CLICK, "Play the chime note.")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STICK),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STRING),
                        new ItemStack(Material.OAK_PLANKS),
                        new ItemStack(Material.STRING),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.OAK_PLANKS),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("hyperion", new hyperion(Material.IRON_SWORD, "Hyperion", UberRarity.RARE,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Wither Impact", AbilityType.RIGHT_CLICK, "Kill everything in your path!"),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        UberItems.getMaterial("enchanted_iron_block").makeItem(1),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        UberItems.getMaterial("enchanted_iron_block").makeItem(1),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        UberItems.getMaterial("thunderlord_handle").makeItem(1),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("block_annihilator", new block_annihilator(Material.NETHERITE_PICKAXE, "Block Annihilator", UberRarity.RARE,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Block-be-Gone", AbilityType.RIGHT_CLICK, "Instantly break blocks."),
                        new UberAbility("Ore Compactor", AbilityType.NONE, "Turn ores into their block form!")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.NETHERITE_BLOCK),
                        new ItemStack(Material.NETHERITE_BLOCK),
                        new ItemStack(Material.NETHERITE_BLOCK),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STICK),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STICK),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("golden_head", new golden_head(Material.GHAST_TEAR, "Golden Head", UberRarity.RARE,
                false, true, true,
                Arrays.asList(
                        new UberAbility("", AbilityType.NONE, ""),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.PLAYER_HEAD),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT),
                        new ItemStack(Material.GOLD_INGOT)), false, 1 )));

        UberItems.putItem("nuke", new nuke(Material.TNT, "Nuke", UberRarity.RARE,
                true, true, true,
                Arrays.asList(
                        new UberAbility("", AbilityType.NONE, ""),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.TNT)), false, 1 )));

        UberItems.putItem("creeper_charge", new creeper_charge(Material.FIRE_CHARGE, "Creeper Charge", UberRarity.RARE,
                true, true, true,
                Arrays.asList(
                        new UberAbility("", AbilityType.NONE, ""),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.TNT),
                        new ItemStack(Material.FLINT),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("ice_weapon", new ice_weapon(Material.BLAZE_ROD, "Ice Weapon", UberRarity.UNCOMMON,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Freeze", AbilityType.NONE, "Freeze mobs on hit."),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.ICE),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.ICE),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.PRISMARINE_SHARD),
                        new ItemStack(Material.AIR)), false, 1 )));

        UberItems.putItem("cum_sword", new cum_sword(Material.IRON_SWORD, "Cum Sword", UberRarity.COMMON,
                false, false, true,
                Arrays.asList(
                        new UberAbility("Cum-splotion!", AbilityType.NONE, "Cum on your enemies!"),
                        new UberAbility("", AbilityType.NONE, "")),
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.QUARTZ_BLOCK),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.QUARTZ_BLOCK),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.STICK),
                        new ItemStack(Material.AIR)), false, 1 )));

    }
    private void registerUberMaterials() {
        UberItems.putMaterial("enchanted_sponge", new UberMaterial(Material.SPONGE,
                "Enchanted Sponge", UberRarity.RARE, true, false, false,
                "idk why I chose sponge, but hey this demonstrates how to make a custom UberMaterial lol",
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.SPONGE, 32),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.SPONGE, 32),
                        new ItemStack(Material.SPONGE, 32),
                        new ItemStack(Material.SPONGE, 32),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.SPONGE, 32),
                        new ItemStack(Material.AIR)), false, 1)));

        UberItems.putMaterial("enchanted_iron_block", new UberMaterial(Material.IRON_BLOCK,
                "Enchanted Iron Block", UberRarity.RARE, true, true, false,
                "A very compact iron block.",
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.IRON_BLOCK, 16),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.IRON_BLOCK, 16),
                        new ItemStack(Material.IRON_BLOCK, 16),
                        new ItemStack(Material.IRON_BLOCK, 16),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.IRON_BLOCK, 16),
                        new ItemStack(Material.AIR)), false, 1)));

        UberItems.putMaterial("thunderlord_handle", new UberMaterial(Material.STICK,
                "Thunderlord Handle", UberRarity.RARE, true, false, false,
                "Only the strongest can obtain this handle. Use at your own risk.",
                new UberCraftingRecipe(Arrays.asList(
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.CREEPER_HEAD),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.AIR),
                        new ItemStack(Material.BLAZE_ROD, 16),
                        new ItemStack(Material.AIR)), false, 1)));
    }
}