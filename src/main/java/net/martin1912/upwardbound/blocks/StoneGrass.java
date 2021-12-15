package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class StoneGrass extends TemplateBlockBase {
    public StoneGrass(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public StoneGrass setHardness(float Hardness) {
        return (StoneGrass) super.setHardness(Hardness);
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
                        return STONE.texture;
                    case 1:
                        return TextureListener.StoneGardensGrassTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.StoneGrassGardensSide;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }
}
