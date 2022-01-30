package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class SkyLogs extends TemplateBlockBase {
    public SkyLogs(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD.sounds);
    }

    @Override
    public SkyLogs setHardness(float Hardness) {
        return (SkyLogs) super.setHardness(Hardness);
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
                    case 1:
                        return TextureListener.LushLogTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.LushLog;
                }
            case 1:
                switch (side) {
                    case 0:
                    case 1:
                        return TextureListener.ColdLogTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.ColdLog;
                }
            case 2:
                switch (side) {
                    case 0:
                    case 1:
                        return TextureListener.GoldLogTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.GoldLog;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }
}

