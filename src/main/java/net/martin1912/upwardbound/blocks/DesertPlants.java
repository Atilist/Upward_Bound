package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class DesertPlants extends TemplateBlockBase {
    public DesertPlants(Identifier identifier, Material material) {
        super(identifier, material);
        this.setBoundingBox(0.0625F, 0.0F, 0.0625F, 1.0F - 0.0625F, 1.0F, 1.0F - 0.0625F);
        this.setTicksRandomly(true);
        setSounds(WOOD.sounds);
    }

    @Environment(EnvType.CLIENT)
    public Box getOutlineShape(Level level, int x, int y, int z) {
        float var5 = 0.0625F;
        return Box.create((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)(y + 1), (double)((float)(z + 1) - var5));
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return TextureListener.DesertCactusBottom;
                    case 1:
                        return TextureListener.DesertCactusTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.DesertCactusSide;
                }
            case 1:
                return TextureListener.PoolPlantRoots;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public Box getCollisionShape(Level level, int x, int y, int z) {
        float var5 = 0.0625F;
        return Box.create((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)((float)(y + 1) - var5), (double)((float)(z + 1) - var5));
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
