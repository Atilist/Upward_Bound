package net.martin1912.upwardbound.travelagent;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.class_467;
import net.minecraft.entity.EntityBase;
import net.minecraft.level.Level;
import net.minecraft.util.maths.MathHelper;

public class SkyTravelAgent extends class_467 {

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
        int x = MathHelper.floor(arg1.x);
        int z = MathHelper.floor(arg1.z);

        for (int height = 127; height >= 20; height--) {
            if (arg.getMaterial(x, height, z).isSolid() || height == 20) {
                arg.setTileWithMetadata(x, height, z, BlockListener.skyBed.id, 0);
                arg.setTileWithMetadata(x, height, z + 1, BlockListener.skyBed.id, 8);

                arg.setTileWithMetadata(x, height - 1, z - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x, height - 1, z, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x, height - 1, z + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x, height - 1, z + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);

                arg.setTileWithMetadata(x + 1, height - 1, z - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x + 1, height - 1, z, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x + 1, height - 1, z + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x + 1, height - 1, z + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);

                arg.setTileWithMetadata(x - 1, height - 1, z - 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x - 1, height - 1, z, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x - 1, height - 1, z + 1, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                arg.setTileWithMetadata(x - 1, height - 1, z + 2, net.martin1912.BetaExtras.Block.BlockListener.thiccBriccs.id, 15);
                break;
            }
        }
        return true;
    }

}
