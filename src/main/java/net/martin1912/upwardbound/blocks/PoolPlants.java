package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class PoolPlants extends TemplateBlockBase {
    public PoolPlants(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD_SOUNDS);
    }

    @Override
    public PoolPlants setHardness(float Hardness) {
        return (PoolPlants) super.setHardness(Hardness);
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
                    case 1:
                        return TextureListener.PoolPlantTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.PoolPlantSide;
                }
            case 1:
                switch (side) {
                    case 0:
                        return TextureListener.PoolPlantTop;
                    case 1:
                        return TextureListener.PoolPlantTopWet;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.PoolPlantSide;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }
}
