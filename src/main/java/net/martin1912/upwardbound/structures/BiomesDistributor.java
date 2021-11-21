package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.DimensionData;
import net.minecraft.level.gen.FixedBiomeSource;
import net.minecraft.level.structure.Structure;
import net.minecraft.util.noise.SimplexOctaveNoise;
import net.modificationstation.stationapi.api.level.dimension.DimensionHelper;

import java.util.Random;

public class BiomesDistributor extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        for (int xOffset = 0; xOffset <= 15; xOffset++) {
            for (int zOffset = 0; zOffset <= 15; zOffset++) {
                SimplexOctaveNoise pseudoBiome = new SimplexOctaveNoise(new Random(level.getSeed() * 1000L), 4);
                double[] biomeVariable = new double[1];
                biomeVariable = pseudoBiome.sample(biomeVariable, (double) x + xOffset, (double) z + zOffset, 16, 16, 0.02500000037252903D, 0.02500000037252903D, 0.5D);
                System.out.println(biomeVariable[0]);
                for (int height = y; height > 19; height--) {
                    TreePlacer treeThing = new TreePlacer();
                    int randomizer = rand.nextInt(20);
                    if (level.getTileId(x + xOffset, height, z + zOffset) == BlockBase.DIRT.id) {
                        if (height < 72) { //Grassy Biomes (Ground)
                            if (biomeVariable[0] < 3.75) {
                                level.setTile(x + xOffset, height, z + zOffset, BlockListener.skyDirt.id);
                            } else { //Sky Desert (Ground)
                                level.setTile(x + xOffset, height, z + zOffset, BlockBase.SANDSTONE.id);
                            }
                        } else {
                            if (height < 95) { //Mountain Slopes (Ground)
                                if (biomeVariable[0] < 3.0)
                                    level.setTileWithMetadata(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseSnow.id, 1);
                                else if (biomeVariable[0] < 3.75)
                                    level.setTile(x + xOffset, height, z + zOffset, BlockBase.STONE.id);
                                else
                                    level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.uncoloredTerracotta.id);
                            } else {
                                if (biomeVariable[0] < 3.75)
                                    level.setTileWithMetadata(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseIce.id, 1);
                            }
                        }
                    } else if (level.getTileId(x + xOffset, height, z + zOffset) == BlockBase.GRASS.id) {
                        if (level.getTileId(x + xOffset, height + 1, z + zOffset) == BlockBase.DANDELION.id || level.getTileId(x + xOffset, height + 1, z + zOffset) == BlockBase.ROSE.id) {
                            level.setTile(x + xOffset, height + 1, z + zOffset, 0);
                        }
                        if (height < 72) {
                            if (biomeVariable[0] < -2.0) { //Cold Forest
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 1);
                                if (randomizer == 0 && level.getBrightness(x + xOffset, height + 1, z + zOffset) > 0.9) {
                                    treeThing.setMeta(1);
                                    treeThing.generate(level, rand, x + xOffset, height + 1, z + zOffset);
                                }
                            } else if (biomeVariable[0] < -0.5) { //Balloon Biome
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 3);
                            } else if (biomeVariable[0] < 2.0){ //Stone Gardens
                                level.setTile(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id);
                            } else if (biomeVariable[0] < 3.0) { //Lush Forest
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 2);
                                if (randomizer == 0 && level.getBrightness(x + xOffset, height + 1, z + zOffset) > 0.9) {
                                    treeThing.setMeta(0);
                                    treeThing.generate(level, rand, x + xOffset, height + 1, z + zOffset);
                                }
                            } else if (biomeVariable[0] < 3.75) { //Golden Forest
                                if (level.getTileId(x + xOffset, height + 1, z + zOffset) == BlockBase.SNOW.id)
                                    level.setTile(x + xOffset, height + 1, z + zOffset, 0);
                                level.setTileWithMetadata(x + xOffset, height, z + zOffset, BlockListener.skyGrass.id, 4);
                                if (randomizer == 0 && level.getBrightness(x + xOffset, height + 1, z + zOffset) > 0.9) {
                                    treeThing.setMeta(2);
                                    treeThing.generate(level, rand, x + xOffset, height + 1, z + zOffset);
                                }
                            } else {  //Sky Desert (Surface)
                                if (level.getTileId(x + xOffset, height + 1, z + zOffset) == BlockBase.SNOW.id)
                                    level.setTile(x + xOffset, height + 1, z + zOffset, 0);
                                level.setTile(x + xOffset, height, z + zOffset, BlockBase.SAND.id);
                            }
                        } else {
                            if (height < 95) { //Mountain Slopes (Surface)
                                if (level.getTileId(x + xOffset, height + 1, z + zOffset) == BlockBase.SNOW.id)
                                    level.setTile(x + xOffset, height + 1, z + zOffset, 0);
                                if (biomeVariable[0] < 3.0)
                                    level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseSnow.id);
                                else if (biomeVariable[0] < 3.75)
                                    level.setTile(x + xOffset, height, z + zOffset, BlockBase.COBBLESTONE.id);
                                else
                                    level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.redSandstone.id);
                            } else { //Mountain Peaks
                                if (biomeVariable[0] < 3.0)
                                    level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.denseIce.id);
                                else if (biomeVariable[0] < 3.75)
                                    level.setTileWithMetadata(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.volcanoBlocks.id, 8);
                                else
                                    level.setTile(x + xOffset, height, z + zOffset, net.martin1912.BetaExtras.Block.BlockListener.coloredTerracotta.id);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
