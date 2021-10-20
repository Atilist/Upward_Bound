package net.martin1912.upwardbound.items;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class SkyBean extends TemplateItemBase {
    public SkyBean(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        int blockCheck = level.getTileId(x, y, z);
        int aboveCheck = level.getTileId(x, y + 1, z);
        if (blockCheck == BlockListener.skyFarmland.id && aboveCheck == 0) {
            level.placeBlockWithMetaData(x, y + 1, z, BlockListener.beanCrop.id, 0);
            --item.count;
            return true;
        }
        return false;
    }
}
