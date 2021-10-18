package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;


import java.util.Random;
@HasMetaNamedBlockItem
public class DungeonBlocks extends TemplateBlockBase {

    public DungeonBlocks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public DungeonBlocks setHardness(float Hardness) {
        return (DungeonBlocks) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        if (i == 2 || i == 3) {
            return 0;
        }
        else {
            return i;
        }
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.FloorBlock;
            case 1:
                return TextureListener.WallBlock;
            case 2:
                return TextureListener.KeyHeadBlock;
            case 3:
                return TextureListener.KeyBodyBlock;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    public int getDropId(int meta, Random rand) {
        if (meta == 2) {
            return ItemListener.dungeonKeyHead.id;
        }
        if (meta == 3) {
            return ItemListener.dungeonKeyBody.id;
        }
        else {
            return BlockListener.dungeonBlocks.id;
        }
    }
}
