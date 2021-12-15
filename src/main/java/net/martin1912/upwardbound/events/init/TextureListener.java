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
        ItemListener.coldEnergiumite.setTexture(Identifier.of(MOD_ID, "Items/ColdEnergiumite"));
        ItemListener.dungeonKey.setTexture(Identifier.of(MOD_ID, "Items/DungeonKey"));
        ItemListener.dungeonKeyBody.setTexture(Identifier.of(MOD_ID, "Items/DungeonKeyBody"));
        ItemListener.dungeonKeyHead.setTexture(Identifier.of(MOD_ID, "Items/DungeonKeyHead"));
        ItemListener.skyBean.setTexture(Identifier.of(MOD_ID, "Items/SkyBean"));
        ItemListener.robustString.setTexture(Identifier.of(MOD_ID, "Items/RobustString"));
        ItemListener.pureAlphium.setTexture(Identifier.of(MOD_ID, "Items/PureAlphium"));
        ItemListener.alphiumHoe.setTexture(Identifier.of(MOD_ID, "Items/AlphiumHoe"));
        ItemListener.energiumite.setTexture(Identifier.of(MOD_ID, "Items/Energiumite"));
        ItemListener.rodOfDreams.setTexture(Identifier.of(MOD_ID, "Items/RodOfDreams"));

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

        ActiveCore = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/ActiveCore")).index;
        ActiveSwitch = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/ActiveSwitch")).index;
        DoorBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/DoorBlock")).index;
        FloorBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/FloorBlock")).index;
        InactiveCore = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/InactiveCore")).index;
        InactiveSwitch = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/InactiveSwitch")).index;
        KeyBodyBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyBodyBlock")).index;
        KeyHeadBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyHeadBlock")).index;
        KeyHole = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyHole")).index;
        WallBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/WallBlock")).index;

        SkyDirt = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirt")).index;
        SkyDirtMinorDrain = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMinorDrain")).index;
        SkyDirtMediumDrain = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMediumDrain")).index;
        SkyDirtMajorDrain = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMajorDrain")).index;
        SkyDirtHighDrain = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtHighDrain")).index;
        SkyDirtMaximumDrain = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMaximumDrain")).index;

        SkyFarmland = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyFarmland")).index;
        SkyFarmlandWet = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyFarmlandWet")).index;

        BeanCropBud = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBud")).index;
        BeanCropTiny = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropTiny")).index;
        BeanCropSmall = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropSmall")).index;
        BeanCrop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCrop")).index;
        BeanCropBigBottom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBigBottom")).index;
        BeanCropBigTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBigTop")).index;
        BeanCropMatureBottom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropMatureBottom")).index;
        BeanCropMatureTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropMatureTop")).index;

        EnergizedAlphium = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/EnergizedAlphium")).index;
        PureAlphiumCompound = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/PureAlphiumCompound")).index;
        PureAlphiumBlock = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/PureAlphiumBlock")).index;

        StoneGardensGrassSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSide")).index;
        StoneGardensGrassSideDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideDrought")).index;
        StoneGardensGrassSideAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideAncient")).index;
        StoneGardensGrassSideStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideStorm")).index;

        StoneGardensGrassTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTop")).index;
        StoneGardensGrassTopBloom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopBloom")).index;
        StoneGardensGrassTopDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopDrought")).index;
        StoneGardensGrassTopAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopAncient")).index;
        StoneGardensGrassTopStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopStorm")).index;

        ColdGrassSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSide")).index;
        ColdGrassSideDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideDrought")).index;
        ColdGrassSideAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideAncient")).index;
        ColdGrassSideStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideStorm")).index;
        ColdGrassTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTop")).index;
        ColdGrassTopBloom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopBloom")).index;
        ColdGrassTopDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopDrought")).index;
        ColdGrassTopAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopAncient")).index;
        ColdGrassTopStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopStorm")).index;
        LushGrassSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSide")).index;
        LushGrassSideDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideDrought")).index;
        LushGrassSideAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideAncient")).index;
        LushGrassSideStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideStorm")).index;
        LushGrassTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTop")).index;
        LushGrassTopBloom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopBloom")).index;
        LushGrassTopDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopDrought")).index;
        LushGrassTopAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopAncient")).index;
        LushGrassTopStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopStorm")).index;
        BalloonGrassSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSide")).index;
        BalloonGrassSideDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideDrought")).index;
        BalloonGrassSideAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideAncient")).index;
        BalloonGrassSideStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideStorm")).index;
        BalloonGrassTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTop")).index;
        BalloonGrassTopBloom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopBloom")).index;
        BalloonGrassTopDrought = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopDrought")).index;
        BalloonGrassTopAncient = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopAncient")).index;
        BalloonGrassTopStorm = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopStorm")).index;
        GoldGrassSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassSide")).index;
        GoldGrassTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTop")).index;

        LushLeaves = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeaves")).index;
        ColdLeaves = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeaves")).index;
        GoldLeaves = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeaves")).index;

        LushLog = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLog")).index;
        ColdLog = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLog")).index;
        GoldLog = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLog")).index;

        ColdTallGrass = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrass")).index;
        ColdBlueFlower = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlower")).index;
        ColdWhiteFlower = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlower")).index;
        ColdTinyMushroom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroom")).index;
        ColdBush = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBush")).index;
        ColdBushRipe = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipe")).index;

        LushTallGrass = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrass")).index;
        LushFern = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFern")).index;
        LushBigFernBottom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushBigFernBottom")).index;
        LushBigFernTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushBigFernTop")).index;
        LushFernMiddle = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFernMiddle")).index;
        LushFernToTallGrass = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFernToTallGrass")).index;
        LushTallGrassMiddle = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrassMiddle")).index;
        LushTallGrassToFern = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrassToFern")).index;

        GoldTallGrass = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldTallGrass")).index;
        GoldShrub = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldShrub")).index;
        GoldLettuce = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldLettuce")).index;

        SkyShroomBottom = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomBottom")).index;
        SkyShroomSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSide")).index;
        SkyShroomTop = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomTop")).index;
        SkyShroomStem = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomStem")).index;
        SkyShroomInside = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomInside")).index;

        StoneGrassGardensSide = Atlases.getStationTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGrassGardensSide")).index;
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
            OuterEnergiumite,

            ActiveCore,
            ActiveSwitch,
            DoorBlock,
            FloorBlock,
            InactiveCore,
            InactiveSwitch,
            KeyBodyBlock,
            KeyHeadBlock,
            KeyHole,
            WallBlock,

            SkyDirt,
            SkyDirtMinorDrain,
            SkyDirtMediumDrain,
            SkyDirtMajorDrain,
            SkyDirtHighDrain,
            SkyDirtMaximumDrain,

            SkyFarmland,
            SkyFarmlandWet,

            BeanCropBud,
            BeanCropTiny,
            BeanCropSmall,
            BeanCrop,
            BeanCropBigBottom,
            BeanCropBigTop,
            BeanCropMatureBottom,
            BeanCropMatureTop,

            EnergizedAlphium,
            PureAlphiumCompound,
            PureAlphiumBlock,

            StoneGardensGrassSide,
            StoneGardensGrassSideDrought,
            StoneGardensGrassSideAncient,
            StoneGardensGrassSideStorm,
            StoneGardensGrassTop,
            StoneGardensGrassTopBloom,
            StoneGardensGrassTopDrought,
            StoneGardensGrassTopAncient,
            StoneGardensGrassTopStorm,
            ColdGrassSide,
            ColdGrassSideDrought,
            ColdGrassSideAncient,
            ColdGrassSideStorm,
            ColdGrassTop,
            ColdGrassTopBloom,
            ColdGrassTopDrought,
            ColdGrassTopAncient,
            ColdGrassTopStorm,
            LushGrassSide,
            LushGrassSideDrought,
            LushGrassSideAncient,
            LushGrassSideStorm,
            LushGrassTop,
            LushGrassTopBloom,
            LushGrassTopDrought,
            LushGrassTopAncient,
            LushGrassTopStorm,
            BalloonGrassSide,
            BalloonGrassSideDrought,
            BalloonGrassSideAncient,
            BalloonGrassSideStorm,
            BalloonGrassTop,
            BalloonGrassTopBloom,
            BalloonGrassTopDrought,
            BalloonGrassTopAncient,
            BalloonGrassTopStorm,
            GoldGrassSide,
            GoldGrassTop,

            LushLeaves,
            ColdLeaves,
            GoldLeaves,

            LushLog,
            ColdLog,
            GoldLog,

            ColdTallGrass,
            ColdBlueFlower,
            ColdWhiteFlower,
            ColdTinyMushroom,
            ColdBush,
            ColdBushRipe,

            LushTallGrass,
            LushFern,
            LushBigFernBottom,
            LushBigFernTop,
            LushFernMiddle,
            LushFernToTallGrass,
            LushTallGrassMiddle,
            LushTallGrassToFern,

            GoldTallGrass,
            GoldShrub,
            GoldLettuce,

            SkyShroomBottom,
            SkyShroomSide,
            SkyShroomTop,
            SkyShroomStem,
            SkyShroomInside,

            StoneGrassGardensSide;
}
