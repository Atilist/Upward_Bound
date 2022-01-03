package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public abstract class BigBalloonShroom {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int randomHeight = rand.nextInt(8) + 1;
        for (int xCheck = -1; xCheck <= 1; xCheck++) {
            for (int heightCheck = 0; heightCheck <= randomHeight + 3; heightCheck++) {
                for (int zCheck = -1; zCheck <= 1; zCheck++) {
                    if (level.getTileId(x + xCheck, y + heightCheck, z + zCheck) != 0) {
                        return;
                    }
                }
            }
        }
        for (int stemHeight = 0; stemHeight < randomHeight; stemHeight++) {
            level.setTileWithMetadata(x, y + stemHeight, z, BlockListener.mediumSkyShroom.id, 2);
        }
        level.setTileWithMetadata(x, y + randomHeight, z, BlockListener.mediumSkyShroom.id, 3);
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int hatHeight = 1; hatHeight <= 3; hatHeight++) {
                for (int zOffset = -1; zOffset <= 1; zOffset++) {
                    level.setTileWithMetadata(x + xOffset, y + randomHeight + hatHeight, z + zOffset, BlockListener.skyShroom.id, 2);
                }
            }
        }
    }
}
