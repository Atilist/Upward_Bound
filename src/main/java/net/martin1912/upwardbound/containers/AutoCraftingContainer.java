package net.martin1912.upwardbound.containers;

import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;

public class AutoCraftingContainer extends ContainerBase {
    private InventoryBase chestInventory;

    @Override
    public boolean canUse(PlayerBase player) {
        return false;
    }

    public AutoCraftingContainer(InventoryBase chestInventory) {
        this.chestInventory = chestInventory;
        for(int slotIndex = 0; slotIndex < chestInventory.getInventorySize(); ++slotIndex) {
            int xIndex = slotIndex / 3;
            this.addSlot(new Slot(chestInventory, slotIndex, slotIndex - xIndex * 3, xIndex));
        }
    }
}
