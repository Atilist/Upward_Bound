package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class SkyShroom extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        for (int xCheck = -2; xCheck <= 2; xCheck++) {
            for (int zCheck = -2; zCheck <= 2; zCheck++) {
                for (int yCheck = 1; yCheck <= 5; yCheck++) {
                    if (level.getTileId(x + xCheck, yCheck + y, z + zCheck) != 0) {
                        return false;
                    }
                }
            }
        }
        int randomHeight = rand.nextInt(6) + 1;
        for (int buildStem = 0; buildStem <= randomHeight; buildStem++) {
            level.setTile(x, buildStem + y, z, BlockListener.skyShroom.id);
        }
        int randomWidth = rand.nextInt(5) + 1;
        for (int iterations = 0; iterations < randomWidth; iterations++) {
            for (int xOffset = -randomWidth + iterations; xOffset <= randomWidth - iterations; xOffset++) {
                for (int zOffset = -randomWidth + iterations; zOffset <= randomWidth - iterations; zOffset++) {
                    level.setTileWithMetadata(x + xOffset, randomHeight + 1 + iterations * 3 + y, z + zOffset, BlockListener.skyShroom.id, 1);
                }
            }
        }
        for (int extendStem = 0; extendStem <= randomWidth * 3 - 3; extendStem++) {
            level.setTile(x, randomHeight + extendStem + y, z, BlockListener.skyShroom.id);
        }
        return true;
    }
}
