package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.martin1912.upwardbound.tileentities.tileentityrenderer.SkyBarrelRenderer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.tileentity.TileEntityRendererRegisterEvent;

public class TileRendererListener {
    @EventListener
    private static void registerTileRenderer(TileEntityRendererRegisterEvent event) {
        event.renderers.put(TileEntitySkyBarrel.class, new SkyBarrelRenderer());
    }
}
