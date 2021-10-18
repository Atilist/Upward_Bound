package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class EnergiumiteCrystal extends Structure {

    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        float brightness = level.getBrightness(x, y, z);
        if (brightness > 0.9F) {
            for (int i = -3; i <= 3; i++) {
                for (int j = -3; j <= 3; j++) {
                    if (level.getBrightness(x + i, y - 5, z + j) < 0.9 || level.getMaterial(x + i, y - 5, z + j).isSolid()) {
                        return false;
                    }
                }
            }

            buildCrystal(level, rand, x, y, z, rand.nextInt(5) + 1, 1 - rand.nextInt(2) * 2);

            return true;
        }
        return false;
    }

    private void buildCrystal(Level level, Random rand, int x, int y, int z, int size, int rotation) {
        for (int xOffset = -size; xOffset <= size; xOffset++) {
            for (int height = 0; height <= size * 5; height++) {
                for (int zOffset = -size; zOffset <= size; zOffset++) {
                    if (xOffset > -size && zOffset > -size && xOffset < size && zOffset < size) {
                        level.setTileWithMetadata(x + xOffset, y + height, z + zOffset, BlockListener.energiumiteBlocks.id, 0);
                    } else {
                        level.setTileWithMetadata(x + xOffset, y + height, z + zOffset, BlockListener.energiumiteBlocks.id, 1);
                    }
                }
            }
        }
        for (int length = -size; length <= size; length++) {
            for (int height = 0; height < size * 2 + 1; height++) {
                for (int width = - size; width <= height - size; width++) {
                    level.setTileWithMetadata(x + length, y + height - (size * 2 + 1), z + width * rotation, BlockListener.energiumiteBlocks.id, 1);
                    level.setTileWithMetadata(x + length, y + height * -1 + (size * 5 + (size * 2 + 1)), z + width * -1 * rotation, BlockListener.energiumiteBlocks.id, 1);
                }
            }
        }
    }
}