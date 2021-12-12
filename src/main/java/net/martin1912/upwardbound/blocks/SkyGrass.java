package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.skyseasons.SkySeasonsCalculator;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.animal.AnimalBase;
import net.minecraft.entity.animal.Chicken;
import net.minecraft.entity.animal.Cow;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.DimensionData;
import net.minecraft.level.dimension.Skylands;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.level.dimension.VanillaDimensions;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class SkyGrass extends TemplateBlockBase {
    SkySeasonsCalculator seasonsCalculator = new SkySeasonsCalculator();

    public SkyGrass(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTicksRandomly(true);
        setSounds(GRASS.sounds);
    }

    @Override
    public SkyGrass setHardness(float Hardness) {
        return (SkyGrass) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return BlockListener.skyDirt.id;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        switch (seasons / 50) {
                            case 0:
                                return TextureListener.StoneGardensGrassTop;
                            case 1:
                                return TextureListener.SkyShroomStem;
                            case 2:
                                return TextureListener.SkyShroomSide;
                            case 3:
                                return TextureListener.SkyShroomBottom;
                            case 4:
                                return TextureListener.SkyShroomInside;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.StoneGardensGrassSide;
                }
            case 1:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.ColdGrassTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.ColdGrassSide;
                }
            case 2:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.LushGrassTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.LushGrassSide;
                }
            case 3:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.BalloonGrassTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.BalloonGrassSide;
                }
            case 4:
                switch (side) {
                    case 0:
                        return TextureListener.SkyDirt;
                    case 1:
                        return TextureListener.GoldGrassTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.GoldGrassSide;
                }
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {

        seasons = seasonsCalculator.getDay(level.getLevelTime());
        if (level.getTileId(x, y + 1, z) == 0 ) {
            int selfMeta = level.getTileMeta(x, y, z);
            level.placeBlockWithMetaData(x, y, z, 1, 0);
            level.placeBlockWithMetaData(x, y, z, BlockListener.skyGrass.id, selfMeta);
        }
        System.out.println(seasons);
        level.getLevelTime();
        if (!level.isClient) {
            if (level.placeTile(x, y + 1, z) < 4 && BlockBase.LIGHT_OPACITY[level.getTileId(x, y + 1, z)] > 2) {
                if (rand.nextInt(4) != 0) {
                    return;
                }
                level.setTile(x, y, z, BlockListener.skyDirt.id);
            } else if (level.placeTile(x, y + 1, z) >= 9) {
                int var6 = x + rand.nextInt(3) - 1;
                int var7 = y + rand.nextInt(5) - 3;
                int var8 = z + rand.nextInt(3) - 1;
                int var9 = level.getTileId(var6, var7 + 1, var8);
                if (level.getTileId(var6, var7, var8) == BlockListener.skyDirt.id && level.placeTile(var6, var7 + 1, var8) >= 4 && BlockBase.LIGHT_OPACITY[var9] <= 2) {
                    level.setTileWithMetadata(var6, var7, var8, BlockListener.skyGrass.id, level.getTileMeta(x, y, z));
                }
            }
            if (level.dimension instanceof Skylands && level.getTileMeta(x, y, z) == 0 && level.canSpawnEntity(Box.create(x - 1, y + 1, z - 1, x + 1, y + 2, z + 1))) {
                Chicken moo = new Chicken(level);
                int randomizer = rand.nextInt(1000);
                if (randomizer == 0) {
                    moo.setPosition(x + 0.5, y + 1, z + 0.5);
                    level.spawnEntity(moo);
                }
            }
        }
    }
    int seasons = 0;
}
