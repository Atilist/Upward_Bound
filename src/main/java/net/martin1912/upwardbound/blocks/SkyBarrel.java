package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.tileentity.TileEntityChest;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;

@HasMetaNamedBlockItem
public class SkyBarrel extends TemplateBlockWithEntity {
    public SkyBarrel(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(WOOD_SOUNDS);
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x, y, z);
        ItemInstance playerItem = player.getHeldItem();
        if (tileEntitySkyBarrel.getBarrelItem() == null && playerItem != null) {
            int id = playerItem.itemId;
            int meta = playerItem.getDamage();
            tileEntitySkyBarrel.setBarrelItem(new ItemInstance(id, 0, meta));
            return true;
        }
        return false;
    }

    @Override
    public int droppedMeta(int i) {
        return 0;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0: // Z-
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrelBottom; // Bottom
                    case 1:
                        return TextureListener.SkyBarrelBottom; // Top
                    case 2:
                        return TextureListener.SkyBarrel; // Z-
                    case 3:
                        return TextureListener.SkyBarrel; // Z+
                    case 4:
                        return TextureListener.SkyBarrelRight; // X-
                    case 5:
                        return TextureListener.SkyBarrelLeft; // X+
                }
            case 1: // Z+
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrelTop; // Bottom
                    case 1:
                        return TextureListener.SkyBarrelTop; // Top
                    case 2:
                        return TextureListener.SkyBarrel; // Z-
                    case 3:
                        return TextureListener.SkyBarrel; // Z+
                    case 4:
                        return TextureListener.SkyBarrelLeft; // X-
                    case 5:
                        return TextureListener.SkyBarrelRight; // X+
                }
            case 2: // X-
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrelRight; // Bottom
                    case 1:
                        return TextureListener.SkyBarrelRight; // Top
                    case 2:
                        return TextureListener.SkyBarrelLeft; // Z-
                    case 3:
                        return TextureListener.SkyBarrelRight; // Z+
                    case 4:
                        return TextureListener.SkyBarrel; // X-
                    case 5:
                        return TextureListener.SkyBarrel; // X+
                }
            case 3: //X+
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrelLeft; // Bottom
                    case 1:
                        return TextureListener.SkyBarrelLeft; // Top
                    case 2:
                        return TextureListener.SkyBarrelRight; // Z-
                    case 3:
                        return TextureListener.SkyBarrelLeft; // Z+
                    case 4:
                        return TextureListener.SkyBarrel; // X-
                    case 5:
                        return TextureListener.SkyBarrel; // X+
                }
            case 4: // Y-
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrel; // Bottom
                    case 1:
                        return TextureListener.SkyBarrel; // Top
                    case 2:
                        return TextureListener.SkyBarrelBottom; // Z-
                    case 3:
                        return TextureListener.SkyBarrelBottom; // Z+
                    case 4:
                        return TextureListener.SkyBarrelBottom; // X-
                    case 5:
                        return TextureListener.SkyBarrelBottom; // X+
                }
            case 5: // Y+
                switch (side) {
                    case 0:
                        return TextureListener.SkyBarrel; // Bottom
                    case 1:
                        return TextureListener.SkyBarrel; // Top
                    case 2:
                        return TextureListener.SkyBarrelTop; // Z-
                    case 3:
                        return TextureListener.SkyBarrelTop; // Z+
                    case 4:
                        return TextureListener.SkyBarrelTop; // X-
                    case 5:
                        return TextureListener.SkyBarrelTop; // X+
                }
            case 6:
                return TextureListener.SkyBarrel;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        if (level.hasRedstonePower(x, y, z)) {
            int selfMeta = level.getTileMeta(x, y, z);
            int xOffset = 0;
            int yOffset = 0;
            int zOffset = 0;
            switch (selfMeta) {
                case 0:
                    zOffset = 1;
                    break;
                case 1:
                    zOffset = -1;
                    break;
                case 2:
                    xOffset = 1;
                    break;
                case 3:
                    xOffset = -1;
                    break;
                case 4:
                    yOffset = 1;
                    break;
                case 5:
                    yOffset = -1;
                    break;
                case 6:
                    return;
            }
            if (level.getTileId(x + xOffset, y + yOffset, z + zOffset) == BlockBase.CHEST.id && level.getTileEntity(x + xOffset, y + yOffset, z + zOffset) != null) {
                TileEntitySkyBarrel barrelTileEntity = (TileEntitySkyBarrel) level.getTileEntity(x, y, z);
                TileEntityChest tileEntityChest = (TileEntityChest) level.getTileEntity(x + xOffset, y + yOffset, z + zOffset);
                for (int i = 0; i < tileEntityChest.getInventorySize(); i++) {
                    if (tileEntityChest.getInventoryItem(i) != null) {
                        if (barrelTileEntity.getBarrelItem() == null) {
                            barrelTileEntity.setBarrelItem(tileEntityChest.getInventoryItem(i));
                            tileEntityChest.setInventoryItem(i, null);
                            break;
                        } else if (tileEntityChest.getInventoryItem(i).itemId == barrelTileEntity.getBarrelItem().itemId && tileEntityChest.getInventoryItem(i).getDamage() == barrelTileEntity.getBarrelItem().getDamage()) {
                            int chestItemCount = tileEntityChest.getInventoryItem(i).count;
                            int barrelItemCount = barrelTileEntity.getBarrelItem().count;
                            if (chestItemCount + barrelItemCount > barrelTileEntity.getBarrelItem().getMaxStackSize() * 32) {
                                barrelTileEntity.setBarrelItem(new ItemInstance(tileEntityChest.getInventoryItem(i).itemId, barrelTileEntity.getBarrelItem().getMaxStackSize() * 32, tileEntityChest.getInventoryItem(i).getDamage()));
                                tileEntityChest.setInventoryItem(i, new ItemInstance(tileEntityChest.getInventoryItem(i).itemId, chestItemCount + barrelItemCount - barrelTileEntity.getBarrelItem().getMaxStackSize() * 32, tileEntityChest.getInventoryItem(i).getDamage()));
                            } else {
                                barrelTileEntity.setBarrelItem(new ItemInstance(tileEntityChest.getInventoryItem(i).itemId, barrelItemCount + chestItemCount, tileEntityChest.getInventoryItem(i).getDamage()));
                                tileEntityChest.setInventoryItem(i, null);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return new TileEntitySkyBarrel();
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

}
