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
public class ThinBalloonShroom extends TemplateBlockBase {
    public ThinBalloonShroom(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTicksRandomly(true);
        float var3 = 0.2F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
        setSounds(GRASS.sounds);
    }

    @Override
    public ThinBalloonShroom setHardness(float Hardness) {
        return (ThinBalloonShroom) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.SmallBalloonShroom;
            case 1:
                return TextureListener.ThinStem;
            case 2:
                return TextureListener.ThinStemAdapter;
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
    }

    protected boolean canPlantOnTopOf(int id) {
        return id == BlockListener.skyGrass.id || id == BlockListener.skyDirt.id || id == BlockListener.skyFarmland.id || id == BlockListener.thinBalloonShroom.id;
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        super.onAdjacentBlockUpdate(level, x, y, z, id);
        this.breakIfIncorrect(level, x, y, z);
        if (level.getTileId(x, y + 1, z) == 0 && level.getTileId(x, y - 1, z) != 0) {
            switch (level.getTileMeta(x, y, z)) {
                case 1:
                case 2:
                    level.setTileWithMetadata(x, y, z, BlockListener.thinBalloonShroom.id, 0);
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
        if (belowId == BlockListener.thinBalloonShroom.id) {
            switch (belowMeta) {
                case 0:
                case 2:
                    level.setTileWithMetadata(x, y - 1, z, BlockListener.thinBalloonShroom.id, 1);
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
        return (level.getLightLevel(x, y, z) >= 0 || level.isAboveGroundCached(x, y, z)) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
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
