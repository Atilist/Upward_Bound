package net.martin1912.upwardbound.tileentities.tileentityrenderer;

import net.fabricmc.loader.api.FabricLoader;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.entity.ItemRenderer;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemInstance;
import net.minecraft.tileentity.TileEntityBase;
import org.lwjgl.opengl.GL11;

public class SkyBarrelRenderer extends TileEntityRenderer {
    @Override
    public void render(TileEntityBase entity, double x, double y, double z, float f) {
        ItemInstance barrelItem = ((TileEntitySkyBarrel) entity).getBarrelItem();
        //int itemCount = ((TileEntitySkyBarrel) entity).getCount();
        /*
        this.method_1064("/assets/upwardbound/stationapi/textures/Items/Energiumite.png");
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.25, y + 0.25, z + 1.001);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        Tessellator tessellator = Tessellator.INSTANCE;
        tessellator.start();
        tessellator.vertex(0, 0 ,0, 0, 1);
        tessellator.vertex(1, 0 ,0, 1, 1);
        tessellator.vertex(1, 1 ,0, 1, 0);
        tessellator.vertex(0, 1 ,0, 0, 0);
        tessellator.draw();
        GL11.glPopMatrix();

         */
        if (barrelItem != null) {
            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.25, y + 0.75, z + 1.001);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 1, 0, 0);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.75, y + 0.75, z - 0.001);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 0, 0, 1);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslated(x + 1.001, y + 0.75, z + 0.75);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glRotatef(90, 0, 1, 0);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslated(x - 0.001, y + 0.75, z + 0.25);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glRotatef(270, 0, 1, 0);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.75, y + 1.001, z + 0.75);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glRotatef(270, 1, 0, 0);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.75, y - 0.001, z + 0.25);
            GL11.glScalef(0.031F, 0.031F, 0.031F);
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glRotatef(90, 1, 0, 0);
            itemRenderer.method_1487(mc.textRenderer, mc.textureManager, barrelItem, 0, 0);
            GL11.glPopMatrix();
        }

    }
    private static final Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();
    private static final ItemRenderer itemRenderer = new ItemRenderer();
}
