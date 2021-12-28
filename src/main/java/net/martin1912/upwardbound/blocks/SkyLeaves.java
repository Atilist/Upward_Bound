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
public class SkyLeaves extends TemplateBlockBase {
    SkySeasonsCalculator seasonsCalculator = new SkySeasonsCalculator();
    public SkyLeaves(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GRASS.sounds);
        this.setTicksRandomly(true);
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
                switch (seasons/50) {
                    case 0:
                        return TextureListener.LushLeaves;
                    case 1:
                        return TextureListener.LushLeavesBloom;
                    case 2:
                        return TextureListener.LushLeavesDrought;
                    case 3:
                        return TextureListener.LushLeavesAncient;
                    case 4:
                        return TextureListener.LushLeavesStorm;
                }
            case 1:
                switch (seasons/50) {
                    case 0:
                        return TextureListener.ColdLeaves;
                    case 1:
                        return TextureListener.ColdLeavesBloom;
                    case 2:
                        return TextureListener.ColdLeavesDrought;
                    case 3:
                        return TextureListener.ColdLeavesAncient;
                    case 4:
                        return TextureListener.ColdLeavesStorm;
                }
            case 2:
                switch (seasons/50) {
                    case 0:
                        return TextureListener.GoldLeaves;
                    case 1:
                        return TextureListener.GoldLeavesBloom;
                    case 2:
                        return TextureListener.GoldLeavesDrought;
                    case 3:
                        return TextureListener.GoldLeavesAncient;
                    case 4:
                        return TextureListener.GoldLeavesStorm;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        seasons = seasonsCalculator.getDay(level.getLevelTime());
        if (level.getTileId(x, y + 1, z) == 0 && rand.nextInt(10) == 0) {
            int selfMeta = level.getTileMeta(x, y, z);
            level.placeBlockWithMetaData(x, y, z, 1, 0);
            level.placeBlockWithMetaData(x, y, z, BlockListener.skyLeaves.id, selfMeta);
        }
    }

    int seasons = 0;
}