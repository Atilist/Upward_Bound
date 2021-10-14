package net.martin1912.upwardbound.items;

import net.martin1912.BetaExtras.Block.BlockListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.MathHelper;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class SkyBedItem extends TemplateItemBase {

    public SkyBedItem(Identifier identifier) {
        super(identifier);
        this.maxStackSize = 1;
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (facing != 1) {
            return false;
        } else {
            ++y;
            int var9 = MathHelper.floor((double)(player.yaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte var10 = 0;
            byte var11 = 0;
            if (var9 == 0) {
                var11 = 1;
            }

            if (var9 == 1) {
                var10 = -1;
            }

            if (var9 == 2) {
                var11 = -1;
            }

            if (var9 == 3) {
                var10 = 1;
            }

            if (level.isAir(x, y, z) && level.isAir(x + var10, y, z + var11) && level.canSuffocate(x, y - 1, z) && level.canSuffocate(x + var10, y - 1, z + var11)) {
                level.placeBlockWithMetaData(x, y, z, net.martin1912.upwardbound.events.init.BlockListener.skyBed.id, var9);
                level.placeBlockWithMetaData(x + var10, y, z + var11, net.martin1912.upwardbound.events.init.BlockListener.skyBed.id, var9 + 8);
                --item.count;
                return true;
            } else {
                return false;
            }
        }
    }
}
