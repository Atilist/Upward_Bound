package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public abstract class SkyDesertCactus {

    public static void generate(Level level, Random rand, int x, int y, int z) {
        int randomHeight = rand.nextInt(10) + 1;
        if (level.getTileId(x, y - 1, z) == BlockBase.GRAVEL.id || level.getTileId(x, y - 1, z) == BlockBase.SAND.id && level.getTileId(x, y - 2, z) != 0) {
            for (int height = 0; height <= randomHeight; height++) {
                level.setTile(x, y + height, z, BlockListener.desertPlants.id);
            }
        }
    }
}
