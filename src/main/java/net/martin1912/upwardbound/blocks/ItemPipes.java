package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.BlockView;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class ItemPipes extends TemplateBlockBase {
    public ItemPipes(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Environment(EnvType.CLIENT)
    public Box getOutlineShape(Level level, int x, int y, int z) {
        float var5 = 0.0625F;
        return Box.create((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)(y + 1), (double)((float)(z + 1) - var5));
    }

    @Override
    public void updateBoundingBox(BlockView tileView, int x, int y, int z) {
        this.method_1060(tileView.getTileMeta(x, y, z));
    }

    public void method_1060(int i) {
        switch (i) {
            case 0:
                setBoundingBox(0.1875F, 0.1875F, 0.0F, 0.8F, 0.8125F, 1.0F);
                break;
            case 1:
                setBoundingBox(0.1875F, 0.1875F, 0.0F, 0.8F, 0.8125F, 1.0F);
                break;
            case 2:
                setBoundingBox(0.0F, 0.1875F, 0.1875F, 1.0F, 0.8125F, 0.8F);
                break;
            case 3:
                setBoundingBox(0.0F, 0.1875F, 0.1875F, 1.0F, 0.8125F, 0.8F);
                break;
            case 4:
                setBoundingBox(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
                break;
            case 5:
                setBoundingBox(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
                break;
            case 6:
                setBoundingBox(0.1875F, 0.1875F, 0.0F, 0.8F, 0.8125F, 1.0F);
                break;
            case 7:
                setBoundingBox(0.1875F, 0.1875F, 0.0F, 0.8F, 0.8125F, 1.0F);
                break;
            case 8:
                setBoundingBox(0.0F, 0.1875F, 0.1875F, 1.0F, 0.8125F, 0.8F);
                break;
            case 9:
                setBoundingBox(0.0F, 0.1875F, 0.1875F, 1.0F, 0.8125F, 0.8F);
                break;
            case 10:
                setBoundingBox(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
                break;
            case 11:
                setBoundingBox(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
                break;
        }

    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0: // Z-
                switch (side) {
                    case 0:
                        return TextureListener.PipeUp; // Bottom
                    case 1:
                        return TextureListener.PipeUp; // Top
                    case 2:
                        return TextureListener.PipeHole; // Z-
                    case 3:
                        return TextureListener.PipeHole; // Z+
                    case 4:
                        return TextureListener.PipeRight; // X-
                    case 5:
                        return TextureListener.PipeLeft; // X+
                }
            case 1: // Z+
                switch (side) {
                    case 0:
                        return TextureListener.PipeDown; // Bottom
                    case 1:
                        return TextureListener.PipeDown; // Top
                    case 2:
                        return TextureListener.PipeHole; // Z-
                    case 3:
                        return TextureListener.PipeHole; // Z+
                    case 4:
                        return TextureListener.PipeLeft; // X-
                    case 5:
                        return TextureListener.PipeRight; // X+
                }
            case 2: // X-
                switch (side) {
                    case 0:
                        return TextureListener.PipeRight; // Bottom
                    case 1:
                        return TextureListener.PipeRight; // Top
                    case 2:
                        return TextureListener.PipeLeft; // Z-
                    case 3:
                        return TextureListener.PipeRight; // Z+
                    case 4:
                        return TextureListener.PipeHole; // X-
                    case 5:
                        return TextureListener.PipeHole; // X+
                }
            case 3: //X+
                switch (side) {
                    case 0:
                        return TextureListener.PipeLeft; // Bottom
                    case 1:
                        return TextureListener.PipeLeft; // Top
                    case 2:
                        return TextureListener.PipeRight; // Z-
                    case 3:
                        return TextureListener.PipeLeft; // Z+
                    case 4:
                        return TextureListener.PipeHole; // X-
                    case 5:
                        return TextureListener.PipeHole; // X+
                }
            case 4: // Y-
                switch (side) {
                    case 0:
                        return TextureListener.PipeHole; // Bottom
                    case 1:
                        return TextureListener.PipeHole; // Top
                    case 2:
                        return TextureListener.PipeDown; // Z-
                    case 3:
                        return TextureListener.PipeDown; // Z+
                    case 4:
                        return TextureListener.PipeDown; // X-
                    case 5:
                        return TextureListener.PipeDown; // X+
                }
            case 5: // Y+
                switch (side) {
                    case 0:
                        return TextureListener.PipeHole; // Bottom
                    case 1:
                        return TextureListener.PipeHole; // Top
                    case 2:
                        return TextureListener.PipeUp; // Z-
                    case 3:
                        return TextureListener.PipeUp; // Z+
                    case 4:
                        return TextureListener.PipeUp; // X-
                    case 5:
                        return TextureListener.PipeUp; // X+
                }
            case 6: // Z-
                switch (side) {
                    case 0:
                        return TextureListener.PipeFirstUp; // Bottom
                    case 1:
                        return TextureListener.PipeFirstUp; // Top
                    case 2:
                        return TextureListener.PipeHole; // Z-
                    case 3:
                        return TextureListener.PipeHole; // Z+
                    case 4:
                        return TextureListener.PipeFirstRight; // X-
                    case 5:
                        return TextureListener.PipeFirstLeft; // X+
                }
            case 7: // Z+
                switch (side) {
                    case 0:
                        return TextureListener.PipeFirstDown; // Bottom
                    case 1:
                        return TextureListener.PipeFirstDown; // Top
                    case 2:
                        return TextureListener.PipeHole; // Z-
                    case 3:
                        return TextureListener.PipeHole; // Z+
                    case 4:
                        return TextureListener.PipeFirstLeft; // X-
                    case 5:
                        return TextureListener.PipeFirstRight; // X+
                }
            case 8: // X-
                switch (side) {
                    case 0:
                        return TextureListener.PipeFirstRight; // Bottom
                    case 1:
                        return TextureListener.PipeFirstRight; // Top
                    case 2:
                        return TextureListener.PipeFirstLeft; // Z-
                    case 3:
                        return TextureListener.PipeFirstRight; // Z+
                    case 4:
                        return TextureListener.PipeHole; // X-
                    case 5:
                        return TextureListener.PipeHole; // X+
                }
            case 9: //X+
                switch (side) {
                    case 0:
                        return TextureListener.PipeFirstLeft; // Bottom
                    case 1:
                        return TextureListener.PipeFirstLeft; // Top
                    case 2:
                        return TextureListener.PipeFirstRight; // Z-
                    case 3:
                        return TextureListener.PipeFirstLeft; // Z+
                    case 4:
                        return TextureListener.PipeHole; // X-
                    case 5:
                        return TextureListener.PipeHole; // X+
                }
            case 10: // Y-
                switch (side) {
                    case 0:
                        return TextureListener.PipeHole; // Bottom
                    case 1:
                        return TextureListener.PipeHole; // Top
                    case 2:
                        return TextureListener.PipeFirstDown; // Z-
                    case 3:
                        return TextureListener.PipeFirstDown; // Z+
                    case 4:
                        return TextureListener.PipeFirstDown; // X-
                    case 5:
                        return TextureListener.PipeFirstDown; // X+
                }
            case 11: // Y+
                switch (side) {
                    case 0:
                        return TextureListener.PipeHole; // Bottom
                    case 1:
                        return TextureListener.PipeHole; // Top
                    case 2:
                        return TextureListener.PipeFirstUp; // Z-
                    case 3:
                        return TextureListener.PipeFirstUp; // Z+
                    case 4:
                        return TextureListener.PipeFirstUp; // X-
                    case 5:
                        return TextureListener.PipeFirstUp; // X+
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        if (id > 0 && level.hasRedstonePower(x, y, z)) {
            int selfMeta = level.getTileMeta(x, y, z);
            if (selfMeta >= 6) {
                int pipeLengthZ = 0;
                int pipeLengthX = 0;
                int pipeLengthY = 0;
                System.out.println("Meow");
                switch (selfMeta) {
                    case 6:
                        pipeLengthZ = 1;
                        break;
                    case 7:
                        pipeLengthZ = -1;
                        break;
                    case 8:
                        pipeLengthX = 1;
                        break;
                    case 9:
                        pipeLengthX = -1;
                        break;
                    case 10:
                        pipeLengthY = 1;
                        break;
                    case 11:
                        pipeLengthY = -1;
                        break;
                }
                if (level.getTileId(x + pipeLengthX, y + pipeLengthY, z + pipeLengthZ) == BlockBase.CHEST.id) {
                    System.out.println("Reee");
                    TileEntityChest inputChest = (TileEntityChest) level.getTileEntity(x + pipeLengthX, y + pipeLengthY, z + pipeLengthZ);
                    ItemInstance inventoryItem = inputChest.getInventoryItem(0);
                    int inventorySlot = 0;
                    for (; inventorySlot < inputChest.getInventorySize(); inventorySlot++) {
                        if (inputChest.getInventoryItem(inventorySlot) != null) {
                            inventoryItem = inputChest.getInventoryItem(inventorySlot);
                            break;
                        }
                    }
                    if (inventoryItem != null) {
                        System.out.println("Ahhh");
                        int itemId = inventoryItem.itemId;
                        int itemMeta = inventoryItem.getDamage();
                        int itemCount = inventoryItem.count;
                        switch (selfMeta) {
                            case 6:
                                pipeLengthZ = -1;
                                for (; pipeLengthZ > -25; pipeLengthZ--) {
                                    if (level.getTileMeta(x, y, z + pipeLengthZ) == 0 && level.getTileId(x, y, z + pipeLengthZ) != BlockListener.itemPipes.id || level.getTileMeta(x, y, z + pipeLengthZ) != 0 && level.getTileId(x, y, z + pipeLengthZ) == BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                            case 7:
                                pipeLengthZ = 1;
                                for (; pipeLengthZ < 25; pipeLengthZ++) {
                                    if (level.getTileMeta(x, y, z + pipeLengthZ) != 1 && level.getTileId(x, y, z + pipeLengthZ) != BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                            case 8:
                                pipeLengthX = -1;
                                for (; pipeLengthX > -25; pipeLengthX--) {
                                    if (level.getTileMeta(x + pipeLengthX, y, z) != 2 && level.getTileId(x + pipeLengthX, y, z) != BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                            case 9:
                                pipeLengthX = 1;
                                for (; pipeLengthX < 25; pipeLengthX++) {
                                    if (level.getTileMeta(x + pipeLengthX, y, z) != 3 && level.getTileId(x + pipeLengthX, y, z) != BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                            case 10:
                                pipeLengthY = -1;
                                for (; pipeLengthY > -25; pipeLengthY--) {
                                    if (level.getTileMeta(x, y + pipeLengthY, z) != 4 && level.getTileId(x, y + pipeLengthY, z) != BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                            case 11:
                                pipeLengthY = 1;
                                for (; pipeLengthY < 25; pipeLengthY++) {
                                    if (level.getTileMeta(x, y + pipeLengthY, z) != 5 && level.getTileId(x, y + pipeLengthY, z) != BlockListener.itemPipes.id) {
                                        System.out.println("Kek");
                                        break;
                                    }
                                }
                                break;
                        }
                        if (level.getTileId(x + pipeLengthX, y + pipeLengthY, z + pipeLengthZ) == 0) {
                            System.out.println("Amogus");
                            inputChest.setInventoryItem(inventorySlot, null);
                            Item drop = new Item(level, x + 0.5 + pipeLengthX, y + 0.5 + pipeLengthY, z + 0.5 + pipeLengthZ, new ItemInstance(itemId, itemCount, itemMeta));
                            drop.pickupDelay = 10;
                            level.spawnEntity(drop);
                        } else if (level.getTileId(x + pipeLengthX, y + pipeLengthY, z + pipeLengthZ) == BlockBase.CHEST.id) {
                            TileEntityChest outputChest = (TileEntityChest) level.getTileEntity(x + pipeLengthX, y + pipeLengthY, z + pipeLengthZ);
                            int outputInventorySlot = 0;
                            for (; outputInventorySlot < outputChest.getInventorySize(); outputInventorySlot++) {
                                if (outputChest.getInventoryItem(outputInventorySlot) == null) {
                                    outputChest.setInventoryItem(outputInventorySlot, inventoryItem);
                                    inputChest.setInventoryItem(inventorySlot, null);
                                    break;
                                } else if (outputChest.getInventoryItem(outputInventorySlot).itemId == itemId && outputChest.getInventoryItem(outputInventorySlot).getDamage() == itemMeta && outputChest.getInventoryItem(outputInventorySlot).count < 64) {
                                    int totalItems = itemCount + outputChest.getInventoryItem(outputInventorySlot).count;
                                    if (totalItems <= 64) {
                                        outputChest.setInventoryItem(outputInventorySlot, new ItemInstance(itemId, totalItems, itemMeta));
                                        inputChest.setInventoryItem(inventorySlot, null);
                                    } else {
                                        int leftovers = totalItems - 64;
                                        outputChest.setInventoryItem(outputInventorySlot, new ItemInstance(itemId, 64, itemMeta));
                                        inputChest.setInventoryItem(inventorySlot, new ItemInstance(itemId, leftovers, itemMeta));
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Box getCollisionShape(Level level, int x, int y, int z) {
        float var5 = 0.0625F;
        return Box.create((double)((float)x + var5), (double)y, (double)((float)z + var5), (double)((float)(x + 1) - var5), (double)((float)(y + 1) - var5), (double)((float)(z + 1) - var5));
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
