package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public abstract class VanillaGrassPatch {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        for (int xOffset = -3; xOffset <= 3; xOffset++) {
            for (int yOffset = -10; yOffset <= 10; yOffset++) {
                for (int zOffset = -3; zOffset <= 3; zOffset++) {
                    if (level.getTileId(x + xOffset, y + yOffset, z + zOffset) == BlockListener.skyGrass.id && level.getTileMeta(x + xOffset, y + yOffset, z + zOffset) == 0) {
                        level.setTile(x + xOffset, y + yOffset, z + zOffset, BlockBase.GRASS.id);
                        if (rand.nextBoolean()) {
                            level.setTile(x + xOffset, y + yOffset + 1, z + zOffset, BlockBase.ROSE.id);
                        }
                    }
                }
            }
        }
    }
}
