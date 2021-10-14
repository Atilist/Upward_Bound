package net.martin1912.upwardbound.travelagent;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.class_467;
import net.minecraft.entity.EntityBase;
import net.minecraft.level.Level;
import net.minecraft.util.maths.MathHelper;

import java.util.Random;

public class SkyTravelAgent extends class_467 {
    private Random rand = new Random();

    public void method_1530(Level arg, EntityBase arg1) {
        if (!this.method_1531(arg, arg1)) {
            this.method_1532(arg, arg1);
            this.method_1531(arg, arg1);
        }
    }

    public boolean method_1531(Level arg, EntityBase arg1) {
        short var3 = 128;
        double var4 = -1.0D;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        int var9 = MathHelper.floor(arg1.x);
        int var10 = MathHelper.floor(arg1.z);

        double var18;
        for(int var11 = var9 - var3; var11 <= var9 + var3; ++var11) {
            double var12 = (double)var11 + 0.5D - arg1.x;

            for(int var14 = var10 - var3; var14 <= var10 + var3; ++var14) {
                double var15 = (double)var14 + 0.5D - arg1.z;

                for(int var17 = 127; var17 >= 0; --var17) {
                    if (arg.getTileId(var11, var17, var14) == BlockListener.skyBed.id) {
                        while(arg.getTileId(var11, var17 - 1, var14) == BlockListener.skyBed.id) {
                            --var17;
                        }

                        var18 = (double)var17 + 0.5D - arg1.y;
                        double var20 = var12 * var12 + var18 * var18 + var15 * var15;
                        if (var4 < 0.0D || var20 < var4) {
                            var4 = var20;
                            var6 = var11;
                            var7 = var17;
                            var8 = var14;
                        }
                    }
                }
            }
        }

        if (var4 >= 0.0D) {
            double var22 = (double)var6 + 0.5D;
            double var16 = (double)var7 + 0.5D;
            var18 = (double)var8 + 0.5D;
            if (arg.getTileId(var6 - 1, var7, var8) == BlockListener.skyBed.id) {
                var22 -= 0.5D;
            }

            if (arg.getTileId(var6 + 1, var7, var8) == BlockListener.skyBed.id) {
                var22 += 0.5D;
            }

            if (arg.getTileId(var6, var7, var8 - 1) == BlockListener.skyBed.id) {
                var18 -= 0.5D;
            }

            if (arg.getTileId(var6, var7, var8 + 1) == BlockListener.skyBed.id) {
                var18 += 0.5D;
            }

            arg1.setPositionAndAngles(var22, var16 + 0.5, var18, arg1.yaw, 0.0F);
            arg1.velocityX = arg1.velocityY = arg1.velocityZ = 0.0D;
            return true;
        } else {
            return false;
        }

    }

    public boolean method_1532(Level arg, EntityBase arg1) {
        byte var3 = 16;
        double var4 = -1.0D;
        int var6 = MathHelper.floor(arg1.x);
        int var7 = MathHelper.floor(arg1.y);
        int var8 = MathHelper.floor(arg1.z);
        int var9 = var6;
        int var10 = var7;
        int var11 = var8;
        int var12 = 0;
        int var13 = this.rand.nextInt(4);

        int var14;
        double var15;
        int var17;
        double var18;
        int var20;
        int var21;
        int var22;
        int var23;
        int var24;
        int var25;
        int var26;
        int var27;
        int var28;
        double var32;
        double var33;
        for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
            var15 = (double)var14 + 0.5D - arg1.x;

            for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
                var18 = (double)var17 + 0.5D - arg1.z;

                label293:
                for(var20 = 127; var20 >= 0; --var20) {
                    if (arg.isAir(var14, var20, var17)) {
                        while(var20 > 0 && arg.isAir(var14, var20 - 1, var17)) {
                            --var20;
                        }

                        for(var21 = var13; var21 < var13 + 4; ++var21) {
                            var22 = var21 % 2;
                            var23 = 1 - var22;
                            if (var21 % 4 >= 2) {
                                var22 = -var22;
                                var23 = -var23;
                            }

                            for(var24 = 0; var24 < 3; ++var24) {
                                for(var25 = 0; var25 < 4; ++var25) {
                                    for(var26 = -1; var26 < 4; ++var26) {
                                        var27 = var14 + (var25 - 1) * var22 + var24 * var23;
                                        var28 = var20 + var26;
                                        int var29 = var17 + (var25 - 1) * var23 - var24 * var22;
                                        if (var26 < 0 && !arg.getMaterial(var27, var28, var29).isSolid() || var26 >= 0 && !arg.isAir(var27, var28, var29)) {
                                            continue label293;
                                        }
                                    }
                                }
                            }

                            var32 = (double)var20 + 0.5D - arg1.y;
                            var33 = var15 * var15 + var32 * var32 + var18 * var18;
                            if (var4 < 0.0D || var33 < var4) {
                                var4 = var33;
                                var9 = var14;
                                var10 = var20;
                                var11 = var17;
                                var12 = var21 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (var4 < 0.0D) {
            for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
                var15 = (double)var14 + 0.5D - arg1.x;

                for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
                    var18 = (double)var17 + 0.5D - arg1.z;

                    label231:
                    for(var20 = 127; var20 >= 0; --var20) {
                        if (arg.isAir(var14, var20, var17)) {
                            while(arg.isAir(var14, var20 - 1, var17)) {
                                --var20;
                            }

                            for(var21 = var13; var21 < var13 + 2; ++var21) {
                                var22 = var21 % 2;
                                var23 = 1 - var22;

                                for(var24 = 0; var24 < 4; ++var24) {
                                    for(var25 = -1; var25 < 4; ++var25) {
                                        var26 = var14 + (var24 - 1) * var22;
                                        var27 = var20 + var25;
                                        var28 = var17 + (var24 - 1) * var23;
                                        if (var25 < 0 && !arg.getMaterial(var26, var27, var28).isSolid() || var25 >= 0 && !arg.isAir(var26, var27, var28)) {
                                            continue label231;
                                        }
                                    }
                                }

                                var32 = (double)var20 + 0.5D - arg1.y;
                                var33 = var15 * var15 + var32 * var32 + var18 * var18;
                                if (var4 < 0.0D || var33 < var4) {
                                    var4 = var33;
                                    var9 = var14;
                                    var10 = var20;
                                    var11 = var17;
                                    var12 = var21 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int var30 = var9;
        int var16 = var10;
        var17 = var11;
        int var31 = var12 % 2;
        int var19 = 1 - var31;
        if (var12 % 4 >= 2) {
            var31 = -var31;
            var19 = -var19;
        }

        boolean var34;
        if (var4 < 0.0D) {
            if (var10 < 70) {
                var10 = 70;
            }

            if (var10 > 118) {
                var10 = 118;
            }

            var16 = var10;
        }

        for(var20 = 0; var20 < 4; ++var20) {
            arg.stopPhysics = true;

            /*
            for(var21 = 0; var21 < 4; ++var21) {
                for(var22 = -1; var22 < 4; ++var22) {
                    var23 = var30 + (var21 - 1) * var31;
                    var24 = var16 + var22;
                    var25 = var17 + (var21 - 1) * var19;
                    var34 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
                    arg.setTile(var23, var24, var25, var34 ? BlockListener.skyBed.id : 0);
                }
            }
            */

            arg.setTileWithMetadata(var30, var10, var17, BlockListener.skyBed.id, 0);
            arg.setTileWithMetadata(var30, var10, var17 + 1, BlockListener.skyBed.id, 8);

            arg.setTileWithMetadata(var30, var10 - 1, var17 - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30, var10 - 1, var17, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30, var10 - 1, var17 + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30, var10 - 1, var17 + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);

            arg.setTileWithMetadata(var30 + 1, var10 - 1, var17 - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 + 1, var10 - 1, var17, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 + 1, var10 - 1, var17 + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 + 1, var10 - 1, var17 + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);

            arg.setTileWithMetadata(var30 - 1, var10 - 1, var17 - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 - 1, var10 - 1, var17, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 - 1, var10 - 1, var17 + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
            arg.setTileWithMetadata(var30 - 1, var10 - 1, var17 + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);

            arg.stopPhysics = false;

            for(var21 = 0; var21 < 4; ++var21) {
                for(var22 = -1; var22 < 4; ++var22) {
                    var23 = var30 + (var21 - 1) * var31;
                    var24 = var16 + var22;
                    var25 = var17 + (var21 - 1) * var19;
                    arg.updateAdjacentBlocks(var23, var24, var25, arg.getTileId(var23, var24, var25));
                }
            }
        }

        return true;
    }

}
