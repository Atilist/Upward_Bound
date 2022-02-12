package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.structures.TreePlacer;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.martin1912.upwardbound.events.init.TextureListener;

import java.util.Random;

@HasMetaNamedBlockItem
public class Saplings extends TemplateBlockBase {
    public Saplings(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(LEAVES.sounds);
        this.setTicksRandomly(true);
    }

    @Override
    public TemplateBlockBase setHardness(float Hardness) {
        return (TemplateBlockBase) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        if (i > 7) {
            return i - 8;
        }
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.SmallLushSapling;
            case 1:
                return TextureListener.SmallColdSapling;
            case 2:
                return TextureListener.SmallGoldSapling;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return TextureListener.LushSapling;
            case 9:
                return TextureListener.ColdSapling;
            case 10:
                return TextureListener.GoldSapling;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && this.canPlantOnTopOf(level.getTileId(x, y - 1, z));
    }

    protected boolean canPlantOnTopOf(int id) {
        return id == BlockListener.skyGrass.id || id == BlockListener.skyDirt.id || id == BlockListener.skyFarmland.id;
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        int selfMeta = level.getTileMeta(x, y, z);
        if (selfMeta < 8) {
            level.setTileMeta(x, y, z, selfMeta + 8);
        } else {
            level.setTile(x, y, z, 0);
            TreePlacer.generate(level, rand, x, y, z, selfMeta - 8);
            if (level.getTileId(x, y, z) != BlockListener.skyLogs.id) {
                level.setTileWithMetadata(x, y, z, BlockListener.saplings.id, selfMeta);
            }
        }
    }

    public Box getCollisionShape(Level level, int x, int y, int z) {
        return null;
    }

}
