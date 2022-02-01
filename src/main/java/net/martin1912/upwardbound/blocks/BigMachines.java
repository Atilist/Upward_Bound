package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.containers.AutoCraftingContainer;
import net.martin1912.upwardbound.containers.BigChest;
import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.mixin.BlockMetaAccessor;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.Chest;
import net.minecraft.inventory.Crafting;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.recipe.RecipeRegistry;
import net.minecraft.tileentity.TileEntityChest;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

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
            case 5:
                switch (side) {
                    case 0:
                        return TextureListener.BarrelOutput;
                    case 1:
                        return TextureListener.BarrelInput;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.AutomaticCraftingTableSide;
                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        Random random = new Random();
        int selfMeta = level.getTileMeta(x, y, z);
        if (level.hasRedstonePower(x, y, z)) {
            switch (selfMeta) {
                case 0:
                    if (level.getTileId(x, y + 1, z) == BlockListener.skyBarrel.id && level.getTileId(x, y - 1, z) != 0) {
                        BlockBase blockBase = BlockBase.BY_ID[level.getTileId(x, y - 1, z)];
                        int dropID = blockBase.getDropId(level.getTileMeta(x, y - 1, z), random);
                        int dropCount = blockBase.getDropCount(random);
                        int dropMeta = ((BlockMetaAccessor) blockBase).upwardbound$invokeDroppedMeta(level.getTileMeta(x, y - 1, z));
                        TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x, y + 1, z);
                        if (tileEntitySkyBarrel.getBarrelItem() == null) {
                            tileEntitySkyBarrel.setBarrelItem(new ItemInstance(dropID, dropCount, dropMeta));
                            level.setTileWithMetadata(x, y - 1, z, 0, 0);
                        } else if (tileEntitySkyBarrel.getBarrelItem().itemId == dropID && tileEntitySkyBarrel.getBarrelItem().getDamage() == dropMeta) {
                            if (tileEntitySkyBarrel.changeItemCount(dropCount)) {
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
                case 3:
                case 4:
                    return;
                case 5:
                    if (level.getTileId(x, y - 1, z) == BlockListener.skyBarrel.id && level.getTileEntity(x, y - 1, z) != null) {

                        TileEntitySkyBarrel outputBarrel = (TileEntitySkyBarrel) level.getTileEntity(x, y - 1, z);

                        InventoryBase inventoryBase = new BigChest();
                        ContainerBase containerBase = new AutoCraftingContainer(inventoryBase);
                        Crafting crafting = new Crafting(containerBase, 3, 3);
                        int slotIndex = 0;
                        for (int yOffset = 3; yOffset > 0; yOffset--) {
                            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                                if (level.getTileId(x + xOffset, y + yOffset, z) == BlockListener.skyBarrel.id) {
                                    TileEntitySkyBarrel tileEntitySkyBarrel = (TileEntitySkyBarrel) level.getTileEntity(x + xOffset, y + yOffset, z);
                                    if (tileEntitySkyBarrel.getBarrelItem() == null) {
                                        crafting.setInventoryItem(slotIndex, null);
                                        System.out.println("No Filter Set" + ", " + xOffset + ", " + yOffset + ", " + slotIndex);
                                    } else {
                                        if (tileEntitySkyBarrel.getBarrelItem().count == 0) {
                                            crafting.setInventoryItem(slotIndex, null);
                                            System.out.println("Empty" + ", " + xOffset + ", " + yOffset + ", " + slotIndex);
                                        } else {
                                            crafting.setInventoryItem(slotIndex, new ItemInstance(tileEntitySkyBarrel.getBarrelItem().itemId, 1, tileEntitySkyBarrel.getBarrelItem().getDamage()));
                                            System.out.println(tileEntitySkyBarrel.getBarrelItem().itemId + ", " + xOffset + ", " + yOffset + ", " + slotIndex);
                                        }
                                    }
                                } else {
                                    System.out.println("No Barrel" + ", " + xOffset + ", " + yOffset + ", " + slotIndex);
                                }
                                slotIndex++;
                            }
                        }
                        System.out.println(RecipeRegistry.getInstance().getCraftingOutput(crafting));
                        ItemInstance craftingOutput = RecipeRegistry.getInstance().getCraftingOutput(crafting);
                        boolean craftingExecuted = false;
                        if (craftingOutput != null) {
                            if (outputBarrel.getBarrelItem() == null) {
                                outputBarrel.setBarrelItem(craftingOutput);
                                craftingExecuted = true;
                            } else {
                                if (outputBarrel.getBarrelItem().itemId == craftingOutput.itemId && outputBarrel.getBarrelItem().getDamage() == craftingOutput.getDamage()) {
                                    if (outputBarrel.changeItemCount(craftingOutput.count)) {
                                        craftingExecuted = true;
                                    }
                                }
                            }
                        }
                        if (craftingExecuted) {
                            for (int yOffset = 3; yOffset > 0; yOffset--) {
                                for (int xOffset = -1; xOffset <= 1; xOffset++) {
                                    if (level.getTileId(x + xOffset, y + yOffset, z) == BlockListener.skyBarrel.id) {
                                        TileEntitySkyBarrel inputBarrel = (TileEntitySkyBarrel) level.getTileEntity(x + xOffset, y + yOffset, z);
                                        if (inputBarrel.getBarrelItem() != null) {
                                            if (inputBarrel.getBarrelItem().count > 0) {
                                                inputBarrel.changeItemCount(-1);
                                            }
                                        }
                                    }
                                }
                            }
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
