package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;

import java.util.Random;

public class StoneGardensRock {
    public void buildRock(Level level, int x, int y, int z, Random random) {
        for (int xCheck = -2; xCheck <= 2; xCheck++)
            for (int zCheck = -2; zCheck <= 2; zCheck++)
                if (level.getTileId(x + xCheck, y, z + zCheck) != 0) {
                    return;
        }
        int randomLength = random.nextInt(3) + 1;
        for (int xOffset = -randomLength; xOffset <= randomLength; xOffset++) {
            int randomWidth = random.nextInt(3) + 1;
            for (int zOffset = -randomWidth; zOffset <= randomWidth; zOffset++) {
                int randomHeight = random.nextInt(7) + 2;
                for (int height = -3 + random.nextInt(5); height <= randomHeight ; height++) {
                    if (height < randomHeight) {
                        level.setTile(x + xOffset, y + height, z + zOffset, BlockBase.STONE.id);
                    } else {
                        level.setTile(x + xOffset, y + height, z + zOffset, BlockListener.stoneGrass.id);
                    }
                }
            }
        }
    }
}
