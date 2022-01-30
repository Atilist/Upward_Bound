package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BigMachines extends TemplateBlockBase {
    public BigMachines(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public BigMachines setHardness(float Hardness) {
        return (BigMachines) super.setHardness(Hardness);
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
                        return TextureListener.BlockBreakerTop;
                    case 1:
                        return TextureListener.BarrelOutput;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.BlockBreakerSide;
                }
            case 1:
                switch (side) {
                    case 0:
                        return TextureListener.BarrelInput;
                    case 1:
                        return TextureListener.BlockPlacerTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.BlockPlacerSide;
                }
            case 2:
                switch (side) {
                    case 0:
                        return TextureListener.AmidiaBlock;
                    case 1:
                        return TextureListener.SqueezerTop;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SqueezerSide;
                }
            case 3:
                switch (side) {
                    case 0:
                        return TextureListener.AmidiaBlock;
                    case 1:
                        return TextureListener.SqueezerTopActive;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SqueezerSideActive;
                }
            case 4:
                switch (side) {
                    case 0:
                    case 1:
                        return TextureListener.AmidiaBlock;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SqueezerWeightSide;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        int selfMeta = level.getTileMeta(x, y, z);
        if (level.hasRedstonePower(x, y, z)) {
            switch (selfMeta) {
                case 0:
                    if (level.getTileId(x, y + 1, z) == BlockListener.skyBarrel.id && level.getTileId(x, y - 1, z) != 0) {
                        TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x, y + 1, z);
                        if (tileEntitySkyBarrel.getBarrelItem() == null) {
                            //BlockRegistry.INSTANCE.get(level.getTileId(x, y - 1, z));
                            tileEntitySkyBarrel.setBarrelItem(new ItemInstance(level.getTileId(x, y - 1, z), 1, level.getTileMeta(x, y - 1, z)));
                            level.setTileWithMetadata(x, y - 1, z, 0, 0);
                        } else if (tileEntitySkyBarrel.getBarrelItem().itemId == level.getTileId(x, y - 1, z) && tileEntitySkyBarrel.getBarrelItem().getDamage() == level.getTileMeta(x, y - 1, z)) {
                            if (tileEntitySkyBarrel.changeItemCount(1)) {
                                level.setTileWithMetadata(x, y - 1, z, 0, 0);
                            }
                        }
                    }
                    break;
                case 1:
                    if (level.getTileId(x, y - 1, z) == BlockListener.skyBarrel.id && level.getTileId(x, y + 1, z) == 0) {
                        TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x, y - 1, z);
                        if (tileEntitySkyBarrel.getBarrelItem() != null) {
                            if (tileEntitySkyBarrel.getBarrelItem().itemId < 256 && tileEntitySkyBarrel.getBarrelItem().count > 0) {
                                level.setTileWithMetadata(x, y + 1, z, tileEntitySkyBarrel.getBarrelItem().itemId, tileEntitySkyBarrel.getBarrelItem().getDamage());
                                tileEntitySkyBarrel.changeItemCount(-1);
                            }
                        }
                    }
                    break;
                case 2:
                    if (level.getTileId(x, y - 1, z) == 0) {
                        level.setTileWithMetadata(x, y, z, BlockListener.bigMachines.id, 3);
                        level.setTileWithMetadata(x, y - 1, z, BlockListener.bigMachines.id, 4);
                    } else if (level.getTileId(x, y - 1, z) == BlockListener.farmBlocks.id) {
                        if (level.getTileId(x, y - 2, z) == BlockBase.SPONGE.id) {
                            level.setTileWithMetadata(x, y, z, BlockListener.bigMachines.id, 3);
                            level.setTileWithMetadata(x, y - 1, z, BlockListener.bigMachines.id, 4);
                            level.setTileWithMetadata(x, y - 2, z, BlockListener.soakedSponges.id, 0);
                        }
                    }
                    break;
            }
        } else {
            if (selfMeta == 3) {
                level.setTile(x, y - 1, z, 0);
                level.setTileWithMetadata(x, y, z, BlockListener.bigMachines.id, 2);
            }
        }
    }
}
