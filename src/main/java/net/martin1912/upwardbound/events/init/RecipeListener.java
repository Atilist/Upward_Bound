package net.martin1912.upwardbound.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {

        Identifier type = event.recipeId;
        //Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.dungeonKey), "XY ", 'X', new ItemInstance(ItemListener.dungeonKeyBody), 'Y', new ItemInstance(ItemListener.dungeonKeyHead));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.processedAlphium), "XYX", "YZY", "XYX", 'X', new ItemInstance(ItemListener.energiumite), 'Y', new ItemInstance(ItemBase.glowstoneDust), 'Z', new ItemInstance(net.martin1912.BetaExtras.Block.BlockListener.alphiumOre, 1, 1));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.rodOfDreams), " XZ", " YX", "Y  ", 'X', new ItemInstance(ItemListener.energiumite), 'Y', new ItemInstance(ItemListener.pureAlphium), 'Z', new ItemInstance(ItemBase.diamond));
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemListener.alphiumHoe), " ZZ", " Y ", " X ", 'X', new ItemInstance(ItemBase.stick), 'Y', new ItemInstance(ItemListener.pureAlphium), 'Z', new ItemInstance(ItemBase.ironIngot));
            CraftingRegistry.addShapedRecipe(new ItemInstance(BlockListener.metalBlocks), "XXX", "XXX", "XXX", 'X', new ItemInstance(ItemListener.amidiaIngot));
        }
        //Input -> Output
        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemInstance(ItemListener.coldEnergiumite), new ItemInstance(ItemListener.energiumite));
            SmeltingRegistry.addSmeltingRecipe(new ItemInstance(BlockListener.skyOres), new ItemInstance(ItemListener.amidiaIngot));
            SmeltingRegistry.addSmeltingRecipe(new ItemInstance(BlockListener.soakedSponges), new ItemInstance(ItemListener.sensitiveDust));
        }
        //Output <- Input
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.skyBedItem), new ItemInstance(ItemListener.rodOfDreams), new ItemInstance(ItemBase.bed));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.skyPlanks, 4), new ItemInstance(BlockListener.skyLogs));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.amidiaIngot, 9), new ItemInstance(BlockListener.metalBlocks));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.sensorCrystal), new ItemInstance(ItemListener.sensitiveDust), new ItemInstance(ItemListener.energiumite));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 0), new ItemInstance(BlockListener.itemPipes, 1, 0));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 1), new ItemInstance(BlockListener.itemPipes, 1, 1));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 2), new ItemInstance(BlockListener.itemPipes, 1, 2));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 3), new ItemInstance(BlockListener.itemPipes, 1, 3));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 4), new ItemInstance(BlockListener.itemPipes, 1, 4));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 5), new ItemInstance(BlockListener.itemPipes, 1, 5));

            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 6), new ItemInstance(BlockListener.itemPipes, 1, 6));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 7), new ItemInstance(BlockListener.itemPipes, 1, 7));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 8), new ItemInstance(BlockListener.itemPipes, 1, 8));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 9), new ItemInstance(BlockListener.itemPipes, 1, 9));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 10), new ItemInstance(BlockListener.itemPipes, 1, 10));
            CraftingRegistry.addShapelessRecipe(new ItemInstance(BlockListener.itemPipes, 1, 11), new ItemInstance(BlockListener.itemPipes, 1, 11));
        }
    }
}
