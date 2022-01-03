package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public abstract class MediumSkyShroom {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int stemHeight = rand.nextInt(8);
        int hatHeight = rand.nextInt(5) + 1;
        for (int heightCheck = 0; heightCheck < stemHeight + hatHeight; heightCheck++) {
            if (level.getTileId(x, y + heightCheck, z) != 0) {
                return;
            }
        }
        for (int stemPlacer = 0; stemPlacer < stemHeight; stemPlacer++) {
            level.setTile(x, y + stemPlacer, z, BlockListener.mediumSkyShroom.id);
        }
        for (int hatPlacer = 0; hatPlacer < hatHeight; hatPlacer++) {
            level.setTileWithMetadata(x, y + stemHeight + hatPlacer, z, BlockListener.mediumSkyShroom.id, 1);
        }
    }
}
