package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class SkyDirt extends TemplateBlockBase {
    public SkyDirt(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(DIRT.sounds);
    }

    @Override
    public SkyDirt setHardness(float Hardness) {
        return (SkyDirt) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.SkyDirt;
            case 1:
                return TextureListener.SkyDirtMinorDrain;
            case 2:
                return TextureListener.SkyDirtMediumDrain;
            case 3:
                return TextureListener.SkyDirtMajorDrain;
            case 4:
                return TextureListener.SkyDirtHighDrain;
            case 5:
                return TextureListener.SkyDirtMaximumDrain;
            default:
                return super.getTextureForSide(side, meta);}
    }
}
