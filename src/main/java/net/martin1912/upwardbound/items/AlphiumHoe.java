package net.martin1912.upwardbound.items;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class AlphiumHoe extends TemplateItemBase {
    public AlphiumHoe(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        int idCheck = level.getTileId(x, y, z);
        if (idCheck == BlockListener.skyDirt.id || idCheck == BlockListener.skyGrass.id) {
            int metaCheck = level.getTileMeta(x, y, z);
            if (metaCheck < 5 && metaCheck > 0) {
                level.placeBlockWithMetaData(x, y, z, BlockListener.skyDirt.id, 1 + metaCheck);
                int randomizer = rand.nextInt(10);
                if (randomizer == 1) {
                    Item drop = new Item(level, x + 0.5, y + 1.5, z + 0.5, new ItemInstance(ItemListener.skyBean));
                    drop.pickupDelay = 10;
                    level.spawnEntity(drop);
                }
            }
            else if (metaCheck == 0) {
                level.placeBlockWithMetaData(x, y, z, BlockListener.skyFarmland.id, 0);
            }
            else {
                level.placeBlockWithMetaData(x, y, z, 0, 0);
                Item drop = new Item(level, x + 0.5, y + 0.5, z + 0.5, new ItemInstance(BlockBase.GRAVEL));
                drop.pickupDelay = 10;
                level.spawnEntity(drop);
            }
            return true;
        }
        else if (idCheck == BlockListener.skyFarmland.id) {
            level.placeBlockWithMetaData(x, y, z, BlockListener.skyDirt.id, 1);
        }
        return false;
    }
}
