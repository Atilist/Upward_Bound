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
        }
        //Input -> Output
        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(new ItemInstance(ItemListener.coldEnergiumite), new ItemInstance(ItemListener.energiumite));
        }
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(ItemListener.skyBedItem), new ItemInstance(ItemListener.rodOfDreams), new ItemInstance(ItemBase.bed));
        }
    }
}
