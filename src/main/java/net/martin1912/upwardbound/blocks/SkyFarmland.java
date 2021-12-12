package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.animal.Cow;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Skylands;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class SkyFarmland extends TemplateBlockBase {
    public SkyFarmland(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(DIRT.sounds);
        this.setTicksRandomly(true);
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    @Override
    public SkyFarmland setHardness(float Hardness) {
        return (SkyFarmland) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmland;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 1:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmlandWet;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 2:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmland;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 3:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmlandWet;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 4:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmland;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 5:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmlandWet;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 6:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmland;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            case 7:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.SkyFarmlandWet;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyDirt;
                }
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return BlockListener.skyDirt.id;
    }

    private boolean hasCrops(Level arg, int x, int y, int z) {
        byte var5 = 0;

        for(int var6 = x - var5; var6 <= x + var5; ++var6) {
            for(int var7 = z - var5; var7 <= z + var5; ++var7) {
                if (arg.getTileId(var6, y + 1, var7) == net.minecraft.block.BlockBase.CROPS.id) {
                    return true;
                }
            }
        }

        return false;
    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (rand.nextInt(5) == 0) {
            if (!this.isHydrated(level, x, y, z) && !level.canRainAt(x, y + 1, z)) {
                int var6 = level.getTileMeta(x, y, z);
                if (var6 > 0) {
                    level.setTileMeta(x, y, z, var6 - 1);
                } else if (!this.hasCrops(level, x, y, z)) {
                    level.setTile(x, y, z, BlockListener.skyDirt.id);
                }
            } else {
                level.setTileMeta(x, y, z, 7);
            }
        }
    }

    private boolean isHydrated(Level arg, int x, int y, int z) {
        for(int var5 = x - 4; var5 <= x + 4; ++var5) {
            for(int var6 = y; var6 <= y + 1; ++var6) {
                for(int var7 = z - 4; var7 <= z + 4; ++var7) {
                    if (arg.getMaterial(var5, var6, var7) == Material.WATER) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isFullOpaque() {
        return false;
    }

    public boolean isFullCube() {
        return false;
    }

    public Box getCollisionShape(Level level, int x, int y, int z) {
        return Box.create((double)(x), (double)(y), (double)(z), (double)(x + 1), (double)(y + 1), (double)(z + 1));
    }

    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        super.onAdjacentBlockUpdate(level, x, y, z, id);
        Material var6 = level.getMaterial(x, y + 1, z);
        if (var6.isSolid()) {
            level.setTile(x, y, z, BlockListener.skyDirt.id);
        }

    }
}
