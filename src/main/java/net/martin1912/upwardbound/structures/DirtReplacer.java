package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;
import net.minecraft.util.noise.SimplexOctaveNoise;

import java.util.Random;

public class DirtReplacer extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {

        for (int height = y; height > 19; height--) {
            for (int xOffset = 0; xOffset <= 15; xOffset++) {
                for (int zOffset = 0; zOffset <= 15; zOffset++) {
                    if (level.getTileId(x + xOffset, height, z + zOffset) == BlockBase.DIRT.id) {
                        if (height < 72) {
                            level.setTile(x + xOffset, height, z + zOffset, BlockListener.skyDirt.id);
                        } else {
                            if (height < 95) {
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseSnow.id, 1);
                            } else {
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseIce.id, 1);
                            }
                        }
                    } else if (level.getTileId(x + xOffset, height, z + zOffset) == BlockBase.GRASS.id) {
                        SimplexOctaveNoise pseudoBiome = new SimplexOctaveNoise(new Random(level.getSeed() * 420L), 4);
                        double[] biomeVariable = new double[1];
                        biomeVariable = pseudoBiome.sample(biomeVariable, (double) x + xOffset, (double) z + zOffset, 1, 1, 0.02500000037252903D, 0.02500000037252903D, 0.5D);
                        if (height < 72) {
                            if (biomeVariable[0] < -0.5) {
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 1);
                                System.out.println(biomeVariable[0]);
                            } else if (biomeVariable[0] > 1.0){
                                level.setTile(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id);
                            } else if (biomeVariable[0] <= 1.0) {
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 2);
                            }

                        } else {
                            if (height < 95) {
                                level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseSnow.id);
                            } else {
                                level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseIce.id);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
