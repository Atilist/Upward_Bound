package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.skyseasons.SkySeasonsCalculator;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.model.Model;
import net.modificationstation.stationapi.api.client.model.block.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.block.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class MediumSkyShroom extends TemplateBlockBase {

    public MediumSkyShroom(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD_SOUNDS);
        this.setTicksRandomly(true);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public MediumSkyShroom setHardness(float Hardness) {return (MediumSkyShroom) super.setHardness(Hardness);}

    @Override
    public int droppedMeta(int i){
        if (i < 2)
            return 3;
        return 0;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 0;
    }

    @Override
    public boolean isFullOpaque() { return false; }

    /*
    @Override
    public Model getInventoryModel(int meta) {
        switch (meta) {
            case 0:
                switch (seasons / 50) {
                    case 0:
                    case 1:
                        return ModelListener.skyStemNarrowBlockModel;
                    case 2:
                        return ModelListener.skyStemNarrowDroughtBlockModel;
                    case 3:
                        return ModelListener.skyStemNarrowAncientBlockModel;
                    case 4:
                        return ModelListener.skyStemNarrowStormBlockModel;
                }
            case 1:
                switch (seasons / 50) {
                    case 0:
                        return ModelListener.skyHatPrematureBlockModel;
                    case 1:
                        return ModelListener.skyHatPrematureBloomBlockModel;
                    case 2:
                        return ModelListener.skyHatPrematureDroughtBlockModel;
                    case 3:
                        return ModelListener.skyHatPrematureAncientBlockModel;
                    case 4:
                        return ModelListener.skyHatPrematureStormBlockModel;
                }
            default:
                return ModelListener.skyStemNarrowBlockModel;
        }
    }

     */

    /*
    @Override
    public Model getCustomWorldModel(BlockView blockView, int x, int y, int z) {
        switch (blockView.getTileMeta(x, y, z)) {
            case 0:
                switch (seasons / 50) {
                    case 0:
                    case 1:
                        return ModelListener.skyStemNarrowBlockModel;
                    case 2:
                        return ModelListener.skyStemNarrowDroughtBlockModel;
                    case 3:
                        return ModelListener.skyStemNarrowAncientBlockModel;
                    case 4:
                        return ModelListener.skyStemNarrowStormBlockModel;
                }
            case 1:
                switch (seasons / 50) {
                    case 0:
                        return ModelListener.skyHatPrematureBlockModel;
                    case 1:
                        return ModelListener.skyHatPrematureBloomBlockModel;
                    case 2:
                        return ModelListener.skyHatPrematureDroughtBlockModel;
                    case 3:
                        return ModelListener.skyHatPrematureAncientBlockModel;
                    case 4:
                        return ModelListener.skyHatPrematureStormBlockModel;
                }
            case 2:
                return ModelListener.balloonStemNarrowBlockModel;
            case 3:
                return ModelListener.balloonStemNarrowVinesBlockModel;
            default:
                return ModelListener.skyStemNarrowBlockModel;
        }
    }

     */

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        seasons = SkySeasonsCalculator.getDay(level.getLevelTime());
        if (level.getTileId(x, y + 1, z) == 0 && rand.nextInt(10) == 0) {
            int selfMeta = level.getTileMeta(x, y, z);
            level.placeBlockWithMetaData(x, y, z, 1, 0);
            level.placeBlockWithMetaData(x, y, z, BlockListener.mediumSkyShroom.id, selfMeta);
        }
    }

    @Override
    public int getDropId(int meta, Random rand) {
        if (meta < 2)
            return BlockListener.coldPlants.id;
        return BlockListener.thinBalloonShroom.id;
    }

    int seasons = 0;
}
