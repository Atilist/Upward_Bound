package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.skyseasons.SkySeasonsCalculator;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.monster.MonsterBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class SkyShroom extends TemplateBlockBase {
    public SkyShroom(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD.sounds);
        this.setTicksRandomly(true);
    }

    @Override
    public SkyShroom setHardness(float Hardness) {
        return (SkyShroom) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        if (i != 2) {
            return 3;
        }
        return 0;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                    case 1:
                        switch (seasons/50) {
                            case 0:
                            case 1:
                            case 2:
                                return TextureListener.SkyShroomInside;
                            case 3:
                                return TextureListener.SkyShroomInsideAncient;
                            case 4:
                                return TextureListener.SkyShroomInsideStorm;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        switch (seasons/50) {
                            case 0:
                            case 1:
                                return TextureListener.SkyShroomStem;
                            case 2:
                                return TextureListener.SkyShroomStemDrought;
                            case 3:
                                return TextureListener.SkyShroomStemAncient;
                            case 4:
                                return TextureListener.SkyShroomStemStorm;
                        }
                }
            case 1:
                switch (side) {
                    case 0:
                        switch (seasons/50) {
                            case 0:
                            case 2:
                                return TextureListener.SkyShroomBottom;
                            case 1:
                                return TextureListener.SkyShroomBottomBloom;
                            case 3:
                                return TextureListener.SkyShroomBottomAncient;
                            case 4:
                                return TextureListener.SkyShroomBottomStorm;
                        }
                    case 1:
                        switch (seasons/50) {
                            case 0:
                            case 1:
                                return TextureListener.SkyShroomTop;
                            case 2:
                                return TextureListener.SkyShroomTopDrought;
                            case 3:
                                return TextureListener.SkyShroomTopAncient;
                            case 4:
                                return TextureListener.SkyShroomTopStorm;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        switch (seasons/50) {
                            case 0:
                                return TextureListener.SkyShroomSide;
                            case 1:
                                return TextureListener.SkyShroomSideBloom;
                            case 2:
                                return TextureListener.SkyShroomSideDrought;
                            case 3:
                                return TextureListener.SkyShroomSideAncient;
                            case 4:
                                return TextureListener.SkyShroomSideStorm;
                        }
                }
            case 2:
                return TextureListener.BalloonBlock;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public int getDropId(int meta, Random rand) {
        if (meta != 2) {
            return BlockListener.coldPlants.id;
        }
        return BlockListener.skyShroom.id;
    }

    @Override
    public void onEntityCollision(Level arg, int x, int y, int z, EntityBase arg1) {
        if (arg1 instanceof MonsterBase && arg.getTileMeta(x, y, z) < 2) {
            arg1.damage(null, 1);
        } else if (arg1 instanceof Item && arg.getTileMeta(x, y, z) == 3) {
            Item item = (Item) arg1;
            ItemInstance itemInstance = item.item;
        }
    }


    @Override
    public Box getCollisionShape(Level level, int x, int y, int z) {
        float var5 = 0.01F;
        return Box.create((double) x, (double) y, (double) z, (double) ((float) (x + 1)), (double) ((float) (y + 1) - var5), (double) ((float) (z + 1)));
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        seasons = SkySeasonsCalculator.getDay(level.getLevelTime());
        if (level.getTileId(x, y + 1, z) == 0 && rand.nextInt(10) == 0) {
            int selfMeta = level.getTileMeta(x, y, z);
            level.placeBlockWithMetaData(x, y, z, 1, 0);
            level.placeBlockWithMetaData(x, y, z, BlockListener.skyShroom.id, selfMeta);
        }
    }

    int seasons = 0;
}
