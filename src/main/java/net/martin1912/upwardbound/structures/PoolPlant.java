package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public abstract class PoolPlant {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int randomWidth = rand.nextInt(4) + 1;
        for (int xGroundCheck = -randomWidth; xGroundCheck <= randomWidth; xGroundCheck++) {
            for (int zGroundCheck = -randomWidth; zGroundCheck <= randomWidth; zGroundCheck++) {
                if (!level.getMaterial(x + xGroundCheck, y - 1, z + zGroundCheck).isSolid()) {
                    return;
                }
            }
        }
        for (int xAirCheck = -randomWidth - 1; xAirCheck <= randomWidth + 1; xAirCheck++) {
            for (int zAirCheck = -randomWidth - 1; zAirCheck <= randomWidth + 1; zAirCheck++) {
                for (int heightAirCheck = 0; heightAirCheck <= 5; heightAirCheck++) {
                    if (level.getTileId(x + xAirCheck, y + heightAirCheck, z + zAirCheck) != 0) {
                        return;
                    }
                }
            }
        }
        for (int height = 0; height <= 2; height++) {
            for (int xOffset = -randomWidth; xOffset <= randomWidth; xOffset++) {
                for (int zOffset = -randomWidth; zOffset <= randomWidth; zOffset++) {
                    switch (height) {
                        case 0:
                            level.setTileWithMetadata(x + xOffset, y, z + zOffset, BlockListener.desertPlants.id, 1);
                        case 1:
                            level.setTileWithMetadata(x + xOffset, y + 1, z + zOffset, BlockListener.poolPlants.id, 1);
                        case 2:
                            level.setTile(x + xOffset, y + 2, z + zOffset, BlockBase.STILL_WATER.id);
                    }
                }
            }
        }
        for (int xOffsetBigger = -randomWidth - 1; xOffsetBigger <= randomWidth + 1; xOffsetBigger++) {
            for (int zOffsetBigger = -randomWidth - 1; zOffsetBigger <= randomWidth + 1; zOffsetBigger++) {
                if (((xOffsetBigger == -randomWidth - 1 || xOffsetBigger == randomWidth + 1) && zOffsetBigger < randomWidth + 1 && zOffsetBigger > -randomWidth - 1) || ((zOffsetBigger == -randomWidth - 1 || zOffsetBigger == randomWidth + 1) && xOffsetBigger < randomWidth + 1 && xOffsetBigger > -randomWidth -1)) {
                    level.setTile(x + xOffsetBigger, y + 2, z + zOffsetBigger, BlockListener.poolPlants.id);
                }
            }
        }
    }
}
