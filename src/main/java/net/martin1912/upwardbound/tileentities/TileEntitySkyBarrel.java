package net.martin1912.upwardbound.tileentities;

import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;

public class TileEntitySkyBarrel extends TileEntityBase {
    ItemInstance barrelItem;
    int count = 0;

    public ItemInstance getBarrelItem() {
        return barrelItem;
    }

    public int getCount() {
        return count;
    }

    public void setBarrelItem(ItemInstance pBarrelItem) {
        barrelItem = pBarrelItem;
    }

    public void setCount(int pCount) {
        count = pCount;
    }
}
