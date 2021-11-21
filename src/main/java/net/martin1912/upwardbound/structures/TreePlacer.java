package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class TreePlacer {
    int meta;
    public void generate(Level level, Random rand, int x, int y, int z) {
        switch (meta) {
            case 0:
                for (int growCheckX = -1; growCheckX <= 1; growCheckX++) {
                    for (int growCheckZ = -1; growCheckZ <= 1; growCheckZ++) {
                        for (int growCheckY = 1; growCheckY <= 16; growCheckY++) {
                            if (level.getTileId(x + growCheckX, y + growCheckY, z + growCheckZ) != 0) {
                                return;
                            }
                        }
                    }
                }
                int treeHeight = rand.nextInt(13) + 4;
                for (int height = 0; height < treeHeight; height++) {
                    level.setTile(x, height + y, z, BlockListener.skyLogs.id);
                }
                for (int leavesHeight = treeHeight; leavesHeight > 0; leavesHeight -= rand.nextInt(3) + 1) {
                    int xzSize = rand.nextInt(4) * -1 - 1;
                    int xShift = rand.nextInt(xzSize * -2) + xzSize;
                    int zShift = rand.nextInt(xzSize * -2) + xzSize;
                    for (int xOffset = xzSize; xOffset <= xzSize * -1; xOffset++) {
                        for (int zOffset = xzSize; zOffset <= xzSize * -1; zOffset++) {
                            if (level.getTileId(x + xOffset + xShift, leavesHeight, z + zOffset + zShift) == 0) {
                                level.setTile(x + xOffset + xShift, leavesHeight + y, z + zOffset + zShift, BlockListener.skyLeaves.id);
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int growCheckX = -1; growCheckX <= 1; growCheckX++) {
                    for (int growCheckZ = -1; growCheckZ <= 1; growCheckZ++) {
                        for (int growCheckY = 1; growCheckY <= 16; growCheckY++) {
                            if (level.getTileId(x + growCheckX, y + growCheckY, z + growCheckZ) != 0) {
                                return;
                            }
                        }
                    }
                }
                int treeHeight1 = rand.nextInt(12) + 2;
                for (int height = 0; height <= treeHeight1; height++) {
                    level.setTileWithMetadata(x, y + height, z, BlockListener.skyLogs.id, 1);
                }
                int cone = -1;
                for (int crownY = treeHeight1 + 3, iterator = 0; crownY >= treeHeight1 - 1; crownY--, iterator++) {
                    if (iterator % 2 == 0) {
                        cone++;
                    }
                    for (int crownX = -cone; crownX <= cone; crownX++) {
                        for (int crownZ = -cone; crownZ <= cone; crownZ++) {
                            if (level.getTileId(x + crownX, y + crownY, z + crownZ) == 0) {
                                level.setTileWithMetadata(x + crownX, y + crownY, z + crownZ, BlockListener.skyLeaves.id, 1);
                            }
                        }
                    }
                }
                for (int ringY = treeHeight1 - 3; ringY > 0; ringY -= 2) {
                    for (int ringX = -1; ringX <= 1; ringX++) {
                        for (int ringZ = -1; ringZ <= 1; ringZ++) {
                            if (level.getTileId(x + ringX, ringY + y, ringZ + z) == 0) {
                                level.setTileWithMetadata(x + ringX, ringY + y, ringZ + z, BlockListener.skyLeaves.id, 1);
                            }
                        }
                    }
                }
                break;
            case 2:
                int var6 = rand.nextInt(3) + 4;
                boolean var7 = true;
                if (y >= 1 && y + var6 + 1 <= 128) {
                    int var8;
                    int var10;
                    int var11;
                    int var12;
                    for (var8 = y; var8 <= y + 1 + var6; ++var8) {
                        byte var9 = 1;
                        if (var8 == y) {
                            var9 = 0;
                        }

                        if (var8 >= y + 1 + var6 - 2) {
                            var9 = 2;
                        }

                        for (var10 = x - var9; var10 <= x + var9 && var7; ++var10) {
                            for (var11 = z - var9; var11 <= z + var9 && var7; ++var11) {
                                if (var8 >= 0 && var8 < 128) {
                                    var12 = level.getTileId(var10, var8, var11);
                                    if (var12 != 0 && var12 != BlockListener.skyLeaves.id) {
                                        var7 = false;
                                    }
                                } else {
                                    var7 = false;
                                }
                            }
                        }
                    }

                    if (var7)  {
                        var8 = level.getTileId(x, y - 1, z);
                        if ((var8 == BlockListener.skyGrass.id || var8 == BlockListener.skyDirt.id) && y < 128 - var6 - 1) {
                            level.setTileInChunk(x, y - 1, z, BlockListener.skyDirt.id);

                            int var16;
                            for (var16 = y - 3 + var6; var16 <= y + var6; ++var16) {
                                var10 = var16 - (y + var6);
                                var11 = 1 - var10 / 2;

                                for (var12 = x - var11; var12 <= x + var11; ++var12) {
                                    int var13 = var12 - x;

                                    for (int var14 = z - var11; var14 <= z + var11; ++var14) {
                                        int var15 = var14 - z;
                                        if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || rand.nextInt(2) != 0 && var10 != 0) && !BlockBase.FULL_OPAQUE[level.getTileId(var12, var16, var14)]) {
                                            level.setTileWithMetadata(var12, var16, var14, BlockListener.skyLeaves.id, 2);
                                        }
                                    }
                                }
                            }

                            for (var16 = 0; var16 < var6; ++var16) {
                                var10 = level.getTileId(x, y + var16, z);
                                if (var10 == 0 || var10 == BlockListener.skyLeaves.id) {
                                    level.setTileWithMetadata(x, y + var16, z, BlockListener.skyLogs.id, 2);
                                }
                            }
                        }
                    }
                }
        }
        }
    public void setMeta(int pMeta) {
        meta = pMeta;
    }
}
