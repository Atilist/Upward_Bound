package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.TextureListener;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.tileentity.TileEntityBase;
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
            tileEntitySkyBarrel.setBarrelItem(new ItemInstance(id, 1, meta));
            return true;
        }
        return false;
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return TextureListener.SkyBarrel;
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
