package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.skyseasons.SkySeasonsCalculator;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class StoneGrass extends TemplateBlockBase {
    int seasons = 0;

    public StoneGrass(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTicksRandomly(true);
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
                        switch (seasons / 50) {
                            case 0:
                                return TextureListener.StoneGardensGrassTop;
                            case 1:
                                return TextureListener.StoneGardensGrassTopBloom;
                            case 2:
                                return TextureListener.StoneGardensGrassTopDrought;
                            case 3:
                                return TextureListener.StoneGardensGrassTopAncient;
                            case 4:
                                return TextureListener.StoneGardensGrassTopStorm;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        switch (seasons / 50) {
                            case 0:
                            case 1:
                                return TextureListener.StoneGrassGardensSide;
                            case 2:
                                return TextureListener.StoneGrassGardensSideDrought;
                            case 3:
                                return TextureListener.StoneGrassGardensSideAncient;
                            case 4:
                                return TextureListener.StoneGrassGardensSideStorm;
                        }
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        seasons = SkySeasonsCalculator.getDay(level.getLevelTime());
        if (level.getTileId(x, y + 1, z) == 0 && rand.nextInt(10) == 0) {
            int selfMeta = level.getTileMeta(x, y, z);
            level.placeBlockWithMetaData(x, y, z, 1, 0);
            level.placeBlockWithMetaData(x, y, z, BlockListener.stoneGrass.id, selfMeta);
        }
    }
}
