package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class FarmBlocks extends TemplateBlockBase {
    public FarmBlocks(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD_SOUNDS);
    }

    @Override
    public FarmBlocks setHardness(float Hardness) {
        return (FarmBlocks) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return TextureListener.SkyBerryBlock;
    }
}
