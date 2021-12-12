package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class SkyShroom extends TemplateBlockBase {
    public SkyShroom(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD.sounds);
    }

    @Override
    public SkyShroom setHardness(float Hardness) {
        return (SkyShroom) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return 3;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                    case 1:
                        return TextureListener.SkyShroomInside;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyShroomStem;
                }
            case 1:
                switch (side) {
                    case 0:
                        return TextureListener.SkyShroomBottom;
                    case 1:
                        return TextureListener.SkyShroomTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyShroomSide;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    public int getDropId(int meta, Random rand) {
        return BlockListener.coldPlants.id;
    }
}
