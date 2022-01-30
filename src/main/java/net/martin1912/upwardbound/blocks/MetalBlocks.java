package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class MetalBlocks extends TemplateBlockBase {
    public MetalBlocks(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(IRON_BLOCK.sounds);
    }

    @Override
    public MetalBlocks setHardness(float Hardness) {
        return (MetalBlocks) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return TextureListener.AmidiaBlock;
    }
}
