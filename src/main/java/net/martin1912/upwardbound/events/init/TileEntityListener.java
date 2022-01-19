package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.UpwardBound;
import net.martin1912.upwardbound.tileentities.TileEntitySkyBarrel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.tileentity.TileEntityRegisterEvent;
import net.modificationstation.stationapi.api.registry.Identifier;


public class TileEntityListener {
    @EventListener
    private static void registerTileEntities(TileEntityRegisterEvent event) {
        event.register(TileEntitySkyBarrel.class, Identifier.of(UpwardBound.MOD_ID, "tile_entity_sky_barrel").toString());
    }
}
