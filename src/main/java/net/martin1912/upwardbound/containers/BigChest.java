package net.martin1912.upwardbound.containers;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;

public class BigChest implements InventoryBase {
    private ItemInstance[] contents = new ItemInstance[9];
    @Override
    public int getInventorySize() {
        return 9;
    }

    @Override
    public ItemInstance getInventoryItem(int index) {
        return this.contents[index];
    }

    @Override
    public ItemInstance takeInventoryItem(int index, int count) {
        if (this.contents[index] != null) {
            ItemInstance var3 = this.contents[index];
            this.contents[index] = null;
            return var3;
        } else {
            return null;
        }
    }

    @Override
    public void setInventoryItem(int slot, ItemInstance stack) {
        this.contents[slot] = stack;
    }

    @Override
    public String getContainerName() {
        return null;
    }

    @Override
    public int getMaxItemCount() {
        return 64;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean canPlayerUse(PlayerBase player) {
        return false;
    }
}
