package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

import java.util.Random;

public abstract class PipesStressTest {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int random = rand.nextInt(12);
        for (int xOffset = 0; xOffset < 16; xOffset++) {
            for (int height = 0; height < 16; height++) {
                for (int zOffset = 0; zOffset < 16; zOffset++) {
                    if (height > 0) {
                        level.setTileWithMetadata(x + xOffset, y + height, z + zOffset, BlockListener.itemPipes.id, random);
                    } else {
                        level.setTileWithMetadata(x + xOffset, y + height, z + zOffset, BlockListener.skyBarrel.id, random);
                        TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x + xOffset, y + height, z + zOffset);
                        tileEntitySkyBarrel.setBarrelItem(new ItemInstance(ItemListener.energiumite.id, 1024, 0));
                    }
                }
            }
        }
    }
}
