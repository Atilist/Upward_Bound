package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class SkyLeaves extends TemplateBlockBase {
    public SkyLeaves(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GRASS.sounds);
    }

    @Override
    public SkyLeaves setHardness(float Hardness) {
        return (SkyLeaves) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public int getTextureForSide(int side, int meta) {

        switch (meta) {
            case 0:
                return TextureListener.LushLeaves;
            case 1:
                return TextureListener.ColdLeaves;
            case 2:
                return TextureListener.GoldLeaves;
            default:
                return super.getTextureForSide(side, meta);
        }
    }
}