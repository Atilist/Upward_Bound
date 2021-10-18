package net.martin1912.upwardbound.items;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.entity.player.PlayerBase;

import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class DungeonKey extends TemplateItemBase {


    public DungeonKey(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        int var8 = level.getTileId(x, y, z);
        int var9 = level.getTileMeta(x, y, z);
        if (var8 == BlockListener.unbreakableDungeonBlocks.id && var9 == 2) {
            level.placeBlockWithMetaData(x, y, z, 0, 0);
            level.placeBlockWithMetaData(x, y + 1, z, 0, 0);
            level.placeBlockWithMetaData(x, y - 1, z, 0, 0);

            level.placeBlockWithMetaData(x, y, z + 1, 0, 0);
            level.placeBlockWithMetaData(x, y + 1, z + 1, 0, 0);
            level.placeBlockWithMetaData(x, y - 1, z + 1, 0, 0);

            level.placeBlockWithMetaData(x, y, z - 1, 0, 0);
            level.placeBlockWithMetaData(x, y + 1, z - 1, 0, 0);
            level.placeBlockWithMetaData(x, y - 1, z - 1, 0, 0);
            --item.count;
            return true;
        }
        else {
            return false;
        }
    }
}
