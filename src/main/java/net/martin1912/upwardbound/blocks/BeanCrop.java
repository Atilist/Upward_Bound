package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplatePlant;

import java.util.Random;

@HasMetaNamedBlockItem
public class BeanCrop extends TemplatePlant {
    public BeanCrop(Identifier identifier) {
        super(identifier, 0);
        this.setTicksRandomly(true);
        setSounds(GRASS.sounds);
        float var3 = 0.5F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
    }

    @Override
    protected boolean canPlantOnTopOf(int id) {
        return id == BlockListener.skyFarmland.id || id == BlockListener.beanCrop.id;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 6;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.BeanCropBud;
            case 1:
                return TextureListener.BeanCropTiny;
            case 2:
                return TextureListener.BeanCropSmall;
            case 3:
                return TextureListener.BeanCrop;
            case 4:
                return TextureListener.BeanCropBigBottom;
            case 5:
                return TextureListener.BeanCropBigTop;
            case 6:
                return TextureListener.BeanCropMatureBottom;
            case 7:
                return TextureListener.BeanCropMatureTop;
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        int randomizer = rand.nextInt(2);
        if (randomizer == 1) {
            this.growCropStage(level, x, y, z);
        }
    }

    private void growCropStage(Level arg, int x, int y, int z) {
        int aboveCheck = arg.getTileId(x, y + 1, z);
        int selfCheck = arg.getTileMeta(x, y, z);
        if (selfCheck < 3) {
            arg.placeBlockWithMetaData(x, y, z, BlockListener.beanCrop.id, selfCheck + 1);
        }
        else if (selfCheck == 3 && aboveCheck == 0) {
            arg.setTileWithMetadata(x, y, z, BlockListener.beanCrop.id, 4);
            arg.setTileWithMetadata(x, y + 1, z, BlockListener.beanCrop.id, 5);
        }
        else if (selfCheck == 4 && aboveCheck == BlockListener.beanCrop.id) {
            arg.setTileWithMetadata(x, y, z, BlockListener.beanCrop.id, 6);
            arg.setTileWithMetadata(x, y + 1, z, BlockListener.beanCrop.id, 7);
        }
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return ItemListener.skyBean.id;
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        int selfCheck = level.getTileMeta(x, y, z);
        int aboveCheck = level.getTileId(x, y + 1, z);
        int belowCheck = level.getTileId(x, y - 1, z);
        if (selfCheck == 4 && aboveCheck == 0 || selfCheck == 6 && aboveCheck == 0) {
            level.placeBlockWithMetaData(x, y, z, 0, 0);
            if (selfCheck == 6) {
                Item drop = new Item(level, x + 0.5, y + 0.5, z + 0.5, new ItemInstance(ItemListener.skyBean));
                drop.pickupDelay = 10;
                level.spawnEntity(drop);
                Item drop2 = new Item(level, x + 0.5, y + 0.5, z + 0.5, new ItemInstance(ItemListener.robustString, 3));
                drop2.pickupDelay = 10;
                level.spawnEntity(drop2);
            }
        } else if (selfCheck == 5 && belowCheck == 0 || selfCheck == 7 && belowCheck == 0) {
            level.placeBlockWithMetaData(x, y, z, 0, 0);
            if (selfCheck == 7) {
                Item drop = new Item(level, x + 0.5, y + 0.5, z + 0.5, new ItemInstance(ItemListener.skyBean));
                drop.pickupDelay = 10;
                level.spawnEntity(drop);
                Item drop2 = new Item(level, x + 0.5, y + 0.5, z + 0.5, new ItemInstance(ItemListener.robustString, 3));
                drop2.pickupDelay = 10;
                level.spawnEntity(drop2);
            }
        }
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }
}
