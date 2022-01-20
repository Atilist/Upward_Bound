package net.martin1912.upwardbound.tileentities;

import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;

public class TileEntitySkyBarrel extends TileEntityBase {
    ItemInstance barrelItem;

    public ItemInstance getBarrelItem() {
        return barrelItem;
    }

    public void setBarrelItem(ItemInstance pBarrelItem) {
        barrelItem = pBarrelItem;
    }

    @Override
    public void readIdentifyingData(CompoundTag tag) {
        super.readIdentifyingData(tag);
        if (tag.containsKey("BarrelItem"))
            barrelItem = new ItemInstance(tag.getCompoundTag("BarrelItem"));
    }

    @Override
    public void writeIdentifyingData(CompoundTag tag) {
        super.writeIdentifyingData(tag);
        if (barrelItem != null) {
            CompoundTag barrelItemTag = new CompoundTag();
            barrelItem.toTag(barrelItemTag);
            tag.put("BarrelItem", barrelItemTag);
        }
    }
}
