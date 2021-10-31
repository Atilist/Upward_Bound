package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class ProcessedAlphium extends TemplateBlockBase {
    public ProcessedAlphium(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public ProcessedAlphium setHardness(float Hardness) {
        return (ProcessedAlphium) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.EnergizedAlphium;
            case 1:
                return TextureListener.PureAlphiumCompound;
            case 2:
                return TextureListener.PureAlphiumBlock;
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        int meta = level.getTileMeta(x, y, z);
        if (meta == 0 && id > 0 && BlockBase.BY_ID[id].getEmitsRedstonePower()) {
            level.placeBlockWithMetaData(x, y, z, BlockListener.processedAlphium.id, 1);
            for (int i = 0; i < 10; i++) {
                level.addParticle("reddust", x + 0.8, y + 1, z + 0.2, 0, 0, 0);
                level.addParticle("reddust", x + 0.8, y + 1, z + 0.8, 0, 0, 0);
                level.addParticle("reddust", x + 0.2, y + 1, z + 0.2, 0, 0, 0);
                level.addParticle("reddust", x + 0.2, y + 1, z + 0.8, 0, 0, 0);

                level.addParticle("smoke", x + 0.5 , y + 1, z + 0.5, 0, 0, 0);
            }
        }
    }

    public int getDropId(int meta, Random rand) {
        if (meta == 1) {
            return ItemListener.pureAlphium.id;
        }
        else {
            return BlockListener.processedAlphium.id;
        }
    }
}
