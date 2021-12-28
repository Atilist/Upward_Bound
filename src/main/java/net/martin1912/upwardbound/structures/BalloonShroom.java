package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class BalloonShroom {
    public void buildShroom(Level level, int x, int y, int z, Random random) {
        int randomHeight = random.nextInt(10) + 1;
        for (int heightCheck = 0; heightCheck <= randomHeight; heightCheck++) {
            if (level.getTileId(x, y + heightCheck, z) != 0) {
                return;
            }
        }
        for (int height = 0; height < randomHeight; height++) {
            level.setTileWithMetadata(x, y + height, z, BlockListener.thinBalloonShroom.id, 1);
        }
        if (random.nextBoolean()) {
            level.setTileWithMetadata(x, y + randomHeight - 1, z, BlockListener.thinBalloonShroom.id, 2);
            level.setTileWithMetadata(x, y + randomHeight, z, BlockListener.skyShroom.id, 2);
        } else {
            level.setTileWithMetadata(x, y + randomHeight, z,BlockListener.thinBalloonShroom.id, 0);
        }
    }
}
