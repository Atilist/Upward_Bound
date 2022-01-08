package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class GoldPlants extends TemplateBlockBase {
    public GoldPlants(Identifier identifier, Material material) {
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
                return TextureListener.GoldTallGrass;
            case 1:
                return TextureListener.GoldShrub;
            case 2:
                return TextureListener.GoldLettuce;
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
    }

    protected boolean canPlantOnTopOf(int id) {
        return id == BlockListener.skyGrass.id || id == BlockListener.skyDirt.id || id == BlockListener.skyFarmland.id;
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        super.onAdjacentBlockUpdate(level, x, y, z, id);
        this.breakIfIncorrect(level, x, y, z);
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        this.breakIfIncorrect(level, x, y, z);
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

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
}
