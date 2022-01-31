package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public abstract class AmidiaCluster {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int width = rand.nextInt(5) + 1;
        for (int xOffset = -width; xOffset <= width; xOffset++)
            for (int zOffset = -width; zOffset <= width; zOffset++)
                if (rand.nextInt(5) + xOffset * xOffset + zOffset * zOffset <= 10)
                    for (int height = -rand.nextInt(width) - 1; height <= rand.nextInt(width) + 1; height++)
                        if (level.getTileId(x + xOffset, y + height, z + zOffset) == BlockBase.STONE.id)
                            level.setTile(x + xOffset, y + height, z + zOffset, BlockListener.skyOres.id);
    }
}
