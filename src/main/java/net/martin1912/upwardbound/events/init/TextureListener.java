package net.martin1912.upwardbound.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.skyBedItem.setTexture(Identifier.of(MOD_ID, "Items/SkyBed"));

        BedBack = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedBack")).index;
        BedFront = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedFront")).index;
        BedSideBody = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedSideBody")).index;
        BedSideHead = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedSideHead")).index;
        BedTopBody = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedTopBody")).index;
        BedTopHead = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedTopHead")).index;
        BedUnderside = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedUnderside")).index;
        BedWrong = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedWrong")).index;
        InnerEnergiumite = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "Energiumite/InnerEnergiumite")).index;
        OuterEnergiumite = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "Energiumite/OuterEnergiumite")).index;
    }

    public static int
            BedBack,
            BedFront,
            BedSideBody,
            BedSideHead,
            BedTopBody,
            BedTopHead,
            BedUnderside,
            BedWrong,
            InnerEnergiumite,
            OuterEnergiumite;
}
