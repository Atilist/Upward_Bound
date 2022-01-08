package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class LushPlants extends TemplateBlockBase {
    public LushPlants(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTicksRandomly(true);
        float var3 = 0.2F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
        setSounds(GRASS.sounds);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.LushTallGrass;
            case 1:
                return TextureListener.LushFern;
            case 2:
                return TextureListener.LushBigFernBottom;
            case 3:
                return TextureListener.LushBigFernTop;
            case 4:
                return TextureListener.LushFernMiddle;
            case 5:
                return TextureListener.LushFernToTallGrass;
            case 6:
                return TextureListener.LushTallGrassMiddle;
            case 7:
                return TextureListener.LushTallGrassToFern;
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
    }

    protected boolean canPlantOnTopOf(int id) {
        return id == BlockListener.skyGrass.id || id == BlockListener.skyDirt.id || id == BlockListener.skyFarmland.id || id == BlockListener.lushPlants.id;
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        super.onAdjacentBlockUpdate(level, x, y, z, id);
        this.breakIfIncorrect(level, x, y, z);
        if (level.getTileId(x, y + 1, z) == 0 && level.getTileId(x, y - 1, z) != 0) {
            switch (level.getTileMeta(x, y, z)) {
                case 0:
                case 6:
                case 7:
                    level.setTileWithMetadata(x, y, z, BlockListener.lushPlants.id, 0);
                    break;
                case 1:
                case 4:
                case 5:
                    level.setTileWithMetadata(x, y, z, BlockListener.lushPlants.id, 1);
                    break;
                case 2:
                    level.setTile(x, y, z, 0);
                    break;
            }
        }
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        this.breakIfIncorrect(level, x, y, z);
    }

    @Override
    public void onBlockPlaced(Level level, int x, int y, int z) {
        int belowId = level.getTileId(x, y - 1, z);
        int belowMeta = level.getTileMeta(x, y - 1, z);
        int selfMeta = level.getTileMeta(x, y, z);
        if (belowId == BlockListener.lushPlants.id) {
            switch (selfMeta) {
                case 0:
                    switch (belowMeta) {
                        case 0:
                            level.setTileWithMetadata(x, y -1, z, BlockListener.lushPlants.id, 6);
                            break;
                        case 1:
                        case 3:
                            level.setTileWithMetadata(x, y -1, z, BlockListener.lushPlants.id, 5);
                            break;
                    }
                    break;
                case 1:
                    switch (belowMeta) {
                        case 0:
                            level.setTileWithMetadata(x, y -1, z, BlockListener.lushPlants.id, 7);
                            break;
                        case 1:
                        case 3:
                            level.setTileWithMetadata(x, y -1, z, BlockListener.lushPlants.id, 4);
                            break;
                    }
                    break;
            }
        }
    }

    protected final void breakIfIncorrect(Level arg, int x, int y, int z) {
        if (!this.canGrow(arg, x, y, z)) {
            this.drop(arg, x, y, z, arg.getTileMeta(x, y, z));
            arg.setTile(x, y, z, 0);
        }

    }

    @Override
    public boolean canGrow(Level level, int x, int y, int z) {
        return (level.getLightLevel(x, y, z) >= 2 || level.isAboveGroundCached(x, y, z)) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
    }

    @Override
    public Box getCollisionShape(Level level, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
}
