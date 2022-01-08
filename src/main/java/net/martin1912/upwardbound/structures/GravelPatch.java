package net.martin1912.upwardbound.structures;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public abstract class GravelPatch {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int randomXWidth = rand.nextInt(10) + 5;
        int randomZWidth = rand.nextInt(10) + 5;
        for (int xWidth = -randomXWidth; xWidth < randomXWidth; xWidth++) {
            for (int zWidth = -randomZWidth; zWidth < randomZWidth; zWidth++) {
                for (int depth = 0; depth >= -rand.nextInt(3); depth--) {
                    double pythagorasThing = Math.sqrt(xWidth * xWidth + zWidth + zWidth);
                    double xDiameter = randomXWidth / Math.sqrt(xWidth * xWidth);
                    double zDiameter = randomZWidth / Math.sqrt(zWidth * zWidth);
                    if (level.getTileId(x + xWidth, y + depth, z + zWidth) == BlockBase.SAND.id && pythagorasThing < xDiameter + zDiameter) {
                        level.setTile(x + xWidth, y + depth, z + zWidth, BlockBase.GRAVEL.id);
                    }
                }
            }
        }
    }
}
