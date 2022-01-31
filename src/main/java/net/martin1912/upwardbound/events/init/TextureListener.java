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
        ItemListener.amidiaIngot.setTexture(Identifier.of(MOD_ID, "SkyIngots/AmidiaIngot"));
        ItemListener.sensitiveDust.setTexture(Identifier.of(MOD_ID, "Dusts/SensitiveDust"));
        ItemListener.sensorCrystal.setTexture(Identifier.of(MOD_ID, "Items/SensorCrystal"));
        ItemListener.skyStraw.setTexture(Identifier.of(MOD_ID, "Items/SkyStraw"));
        ItemListener.goldLettuceSeeds.setTexture(Identifier.of(MOD_ID, "SkyFarming/GoldLettuceSeeds"));

        BedBack = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedBack")).index;
        BedFront = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedFront")).index;
        BedSideBody = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedSideBody")).index;
        BedSideHead = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedSideHead")).index;
        BedTopBody = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedTopBody")).index;
        BedTopHead = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedTopHead")).index;
        BedUnderside = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedUnderside")).index;
        BedWrong = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyBed/BedWrong")).index;

        InnerEnergiumite = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "Energiumite/InnerEnergiumite")).index;
        OuterEnergiumite = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "Energiumite/OuterEnergiumite")).index;

        ActiveCore = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/ActiveCore")).index;
        ActiveSwitch = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/ActiveSwitch")).index;
        DoorBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/DoorBlock")).index;
        FloorBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/FloorBlock")).index;
        InactiveCore = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/InactiveCore")).index;
        InactiveSwitch = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/InactiveSwitch")).index;
        KeyBodyBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyBodyBlock")).index;
        KeyHeadBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyHeadBlock")).index;
        KeyHole = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/KeyHole")).index;
        WallBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DungeonBlocks/WallBlock")).index;

        SkyDirt = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirt")).index;
        SkyDirtMinorDrain = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMinorDrain")).index;
        SkyDirtMediumDrain = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMediumDrain")).index;
        SkyDirtMajorDrain = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMajorDrain")).index;
        SkyDirtHighDrain = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtHighDrain")).index;
        SkyDirtMaximumDrain = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyDirtMaximumDrain")).index;

        SkyFarmland = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyFarmland")).index;
        SkyFarmlandWet = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/SkyFarmlandWet")).index;

        BeanCropBud = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBud")).index;
        BeanCropTiny = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropTiny")).index;
        BeanCropSmall = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropSmall")).index;
        BeanCrop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCrop")).index;
        BeanCropBigBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBigBottom")).index;
        BeanCropBigTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropBigTop")).index;
        BeanCropMatureBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropMatureBottom")).index;
        BeanCropMatureTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BeanCropMatureTop")).index;

        EnergizedAlphium = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/EnergizedAlphium")).index;
        PureAlphiumCompound = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/PureAlphiumCompound")).index;
        PureAlphiumBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ProcessedAlphium/PureAlphiumBlock")).index;

        StoneGardensGrassSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSide")).index;
        StoneGardensGrassSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideDrought")).index;
        StoneGardensGrassSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideAncient")).index;
        StoneGardensGrassSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassSideStorm")).index;

        StoneGardensGrassTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTop")).index;
        StoneGardensGrassTopBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopBloom")).index;
        StoneGardensGrassTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopDrought")).index;
        StoneGardensGrassTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopAncient")).index;
        StoneGardensGrassTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGardensGrassTopStorm")).index;

        ColdGrassSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSide")).index;
        ColdGrassSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideDrought")).index;
        ColdGrassSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideAncient")).index;
        ColdGrassSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassSideStorm")).index;
        ColdGrassTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTop")).index;
        ColdGrassTopBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopBloom")).index;
        ColdGrassTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopDrought")).index;
        ColdGrassTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopAncient")).index;
        ColdGrassTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/ColdGrassTopStorm")).index;
        LushGrassSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSide")).index;
        LushGrassSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideDrought")).index;
        LushGrassSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideAncient")).index;
        LushGrassSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassSideStorm")).index;
        LushGrassTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTop")).index;
        LushGrassTopBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopBloom")).index;
        LushGrassTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopDrought")).index;
        LushGrassTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopAncient")).index;
        LushGrassTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/LushGrassTopStorm")).index;
        BalloonGrassSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSide")).index;
        BalloonGrassSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideDrought")).index;
        BalloonGrassSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideAncient")).index;
        BalloonGrassSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassSideStorm")).index;
        BalloonGrassTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTop")).index;
        BalloonGrassTopBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopBloom")).index;
        BalloonGrassTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopDrought")).index;
        BalloonGrassTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopAncient")).index;
        BalloonGrassTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/BalloonGrassTopStorm")).index;
        GoldGrassSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassSide")).index;
        GoldGrassSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassSideDrought")).index;
        GoldGrassSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassSideAncient")).index;
        GoldGrassSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassSideStorm")).index;
        GoldGrassTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTop")).index;
        GoldGrassTopBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTopBloom")).index;
        GoldGrassTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTopDrought")).index;
        GoldGrassTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTopAncient")).index;
        GoldGrassTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/GoldGrassTopStorm")).index;

        LushLeaves = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeaves")).index;
        LushLeavesBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeavesBloom")).index;
        LushLeavesDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeavesDrought")).index;
        LushLeavesAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeavesAncient")).index;
        LushLeavesStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLeavesStorm")).index;
        ColdLeaves = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeaves")).index;
        ColdLeavesBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeavesBloom")).index;
        ColdLeavesDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeavesDrought")).index;
        ColdLeavesAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeavesAncient")).index;
        ColdLeavesStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLeavesStorm")).index;
        GoldLeaves = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeaves")).index;
        GoldLeavesBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeavesBloom")).index;
        GoldLeavesDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeavesDrought")).index;
        GoldLeavesAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeavesAncient")).index;
        GoldLeavesStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLeavesStorm")).index;

        LushLog = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLog")).index;
        LushLogTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/LushLogTop")).index;
        ColdLog = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLog")).index;
        ColdLogTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/ColdLogTop")).index;
        GoldLog = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLog")).index;
        GoldLogTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyTrees/GoldLogTop")).index;

        ColdTallGrass = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrass")).index;
        ColdTallGrassBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrassBloom")).index;
        ColdTallGrassDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrassDrought")).index;
        ColdTallGrassAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrassAncient")).index;
        ColdTallGrassStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTallGrassStorm")).index;
        ColdBlueFlower = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlower")).index;
        ColdBlueFlowerBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlowerBloom")).index;
        ColdBlueFlowerDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlowerDrought")).index;
        ColdBlueFlowerAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlowerAncient")).index;
        ColdBlueFlowerStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBlueFlowerStorm")).index;
        ColdWhiteFlower = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlower")).index;
        ColdWhiteFlowerBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlowerBloom")).index;
        ColdWhiteFlowerDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlowerDrought")).index;
        ColdWhiteFlowerAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlowerAncient")).index;
        ColdWhiteFlowerStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdWhiteFlowerStorm")).index;
        ColdTinyMushroom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroom")).index;
        ColdTinyMushroomBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroomBloom")).index;
        ColdTinyMushroomDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroomDrought")).index;
        ColdTinyMushroomAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroomAncient")).index;
        ColdTinyMushroomStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdTinyMushroomStorm")).index;
        ColdBush = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBush")).index;
        ColdBushBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushBloom")).index;
        ColdBushDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushDrought")).index;
        ColdBushAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushAncient")).index;
        ColdBushStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushStorm")).index;
        ColdBushRipe = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipe")).index;
        ColdBushRipeBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipeBloom")).index;
        ColdBushRipeDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipeDrought")).index;
        ColdBushRipeAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipeAncient")).index;
        ColdBushRipeStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ColdPlants/ColdBushRipeStorm")).index;

        LushTallGrass = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrass")).index;
        LushFern = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFern")).index;
        LushBigFernBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushBigFernBottom")).index;
        LushBigFernTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushBigFernTop")).index;
        LushFernMiddle = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFernMiddle")).index;
        LushFernToTallGrass = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushFernToTallGrass")).index;
        LushTallGrassMiddle = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrassMiddle")).index;
        LushTallGrassToFern = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "LushPlants/LushTallGrassToFern")).index;

        GoldTallGrass = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldTallGrass")).index;
        GoldShrub = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldShrub")).index;
        GoldLettuce = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "GoldPlants/GoldLettuce")).index;

        SkyShroomBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomBottom")).index;
        SkyShroomBottomBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomBottomBloom")).index;
        SkyShroomBottomAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomBottomAncient")).index;
        SkyShroomBottomStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomBottomStorm")).index;
        SkyShroomSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSide")).index;
        SkyShroomSideBloom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSideBloom")).index;
        SkyShroomSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSideDrought")).index;
        SkyShroomSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSideAncient")).index;
        SkyShroomSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomSideStorm")).index;
        SkyShroomTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomTop")).index;
        SkyShroomTopDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomTopDrought")).index;
        SkyShroomTopAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomTopAncient")).index;
        SkyShroomTopStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomTopStorm")).index;
        SkyShroomStem = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomStem")).index;
        SkyShroomStemDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomStemDrought")).index;
        SkyShroomStemAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomStemAncient")).index;
        SkyShroomStemStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomStemStorm")).index;
        SkyShroomInside = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomInside")).index;
        SkyShroomInsideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomInsideAncient")).index;
        SkyShroomInsideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyShroom/SkyShroomInsideStorm")).index;

        StoneGrassGardensSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGrassGardensSide")).index;
        StoneGrassGardensSideDrought = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGrassGardensSideDrought")).index;
        StoneGrassGardensSideAncient = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGrassGardensSideAncient")).index;
        StoneGrassGardensSideStorm = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFoliage/StoneGrassGardensSideStorm")).index;

        BalloonBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BalloonShroom/BalloonBlock")).index;
        SmallBalloonShroom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BalloonShroom/SmallBalloonShroom")).index;
        ThinStem = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BalloonShroom/ThinStem")).index;
        ThinStemAdapter = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BalloonShroom/ThinStemAdapter")).index;

        DesertCactusBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/DesertCactusBottom")).index;
        DesertCactusSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/DesertCactusSide")).index;
        DesertCactusTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/DesertCactusTop")).index;
        PoolPlantRoots = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/PoolPlantRoots")).index;

        PoolPlantTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/PoolPlantTop")).index;
        PoolPlantSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/PoolPlantSide")).index;
        PoolPlantTopWet = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "DesertPlants/PoolPlantTopWet")).index;

        PipeDown = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeDown")).index;
        PipeUp = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeUp")).index;
        PipeLeft = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeLeft")).index;
        PipeRight = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeRight")).index;
        PipeFirstDown = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeFirstDown")).index;
        PipeFirstUp = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeFirstUp")).index;
        PipeFirstLeft = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeFirstLeft")).index;
        PipeFirstRight = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeFirstRight")).index;
        PipeHole = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "ItemPipes/PipeHole")).index;

        SkyBarrel = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyBarrel")).index;
        SkyBarrelBottom = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyBarrelBottom")).index;
        SkyBarrelLeft = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyBarrelLeft")).index;
        SkyBarrelRight = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyBarrelRight")).index;
        SkyBarrelTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyBarrelTop")).index;

        SkyPlanks = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "WoodenBlocks/SkyPlanks")).index;

        AmidiaOre = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyOres/AmidiaOre")).index;

        AmidiaBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "MetalBlocks/AmidiaBlock")).index;

        BarrelInput = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BarrelInput")).index;
        BarrelOutput = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BarrelOutput")).index;
        BlockBreakerSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BlockBreakerSide")).index;
        BlockBreakerTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BlockBreakerTop")).index;
        BlockPlacerSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BlockPlacerSide")).index;
        BlockPlacerTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/BlockPlacerTop")).index;
        SqueezerSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerSide")).index;
        SqueezerSideActive = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerSideActive")).index;
        SqueezerTop = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerTop")).index;
        SqueezerTopActive = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerTopActive")).index;
        SqueezerWeightSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerWeightSide")).index;
        AutomaticCraftingTableSide = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "BigMachines/SqueezerWeightSide")).index;

        SkyBerryBlock = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SkyFarming/SkyBerryBlock")).index;

        BerrySponge = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "SoakedSponges/BerrySponge")).index;
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
            GoldGrassSideDrought,
            GoldGrassSideAncient,
            GoldGrassSideStorm,
            GoldGrassTop,
            GoldGrassTopBloom,
            GoldGrassTopDrought,
            GoldGrassTopAncient,
            GoldGrassTopStorm,

            LushLeaves,
            LushLeavesBloom,
            LushLeavesDrought,
            LushLeavesAncient,
            LushLeavesStorm,

            ColdLeaves,
            ColdLeavesBloom,
            ColdLeavesDrought,
            ColdLeavesAncient,
            ColdLeavesStorm,
            GoldLeaves,
            GoldLeavesBloom,
            GoldLeavesDrought,
            GoldLeavesAncient,
            GoldLeavesStorm,

            LushLog,
            LushLogTop,
            ColdLog,
            ColdLogTop,
            GoldLog,
            GoldLogTop,

            ColdTallGrass,
            ColdTallGrassBloom,
            ColdTallGrassDrought,
            ColdTallGrassAncient,
            ColdTallGrassStorm,
            ColdBlueFlower,
            ColdBlueFlowerBloom,
            ColdBlueFlowerDrought,
            ColdBlueFlowerAncient,
            ColdBlueFlowerStorm,
            ColdWhiteFlower,
            ColdWhiteFlowerBloom,
            ColdWhiteFlowerDrought,
            ColdWhiteFlowerAncient,
            ColdWhiteFlowerStorm,
            ColdTinyMushroom,
            ColdTinyMushroomBloom,
            ColdTinyMushroomDrought,
            ColdTinyMushroomAncient,
            ColdTinyMushroomStorm,
            ColdBush,
            ColdBushBloom,
            ColdBushDrought,
            ColdBushAncient,
            ColdBushStorm,
            ColdBushRipe,
            ColdBushRipeBloom,
            ColdBushRipeDrought,
            ColdBushRipeAncient,
            ColdBushRipeStorm,

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
            SkyShroomBottomBloom,
            SkyShroomBottomAncient,
            SkyShroomBottomStorm,
            SkyShroomSide,
            SkyShroomSideBloom,
            SkyShroomSideDrought,
            SkyShroomSideAncient,
            SkyShroomSideStorm,
            SkyShroomTop,
            SkyShroomTopDrought,
            SkyShroomTopAncient,
            SkyShroomTopStorm,
            SkyShroomStem,
            SkyShroomStemDrought,
            SkyShroomStemAncient,
            SkyShroomStemStorm,
            SkyShroomInside,
            SkyShroomInsideAncient,
            SkyShroomInsideStorm,

            StoneGrassGardensSide,
            StoneGrassGardensSideDrought,
            StoneGrassGardensSideAncient,
            StoneGrassGardensSideStorm,

            BalloonBlock,
            SmallBalloonShroom,
            ThinStem,
            ThinStemAdapter,

            DesertCactusBottom,
            DesertCactusSide,
            DesertCactusTop,
            PoolPlantRoots,

            PoolPlantTop,
            PoolPlantSide,
            PoolPlantTopWet,

            PipeDown,
            PipeUp,
            PipeLeft,
            PipeRight,
            PipeFirstDown,
            PipeFirstUp,
            PipeFirstLeft,
            PipeFirstRight,
            PipeHole,

            SkyBarrel,
            SkyBarrelBottom,
            SkyBarrelLeft,
            SkyBarrelRight,
            SkyBarrelTop,

            SkyPlanks,

            AmidiaOre,

            AmidiaBlock,

            BarrelInput,
            BarrelOutput,
            BlockBreakerSide,
            BlockBreakerTop,
            BlockPlacerSide,
            BlockPlacerTop,
            SqueezerSide,
            SqueezerSideActive,
            SqueezerTop,
            SqueezerTopActive,
            SqueezerWeightSide,
            AutomaticCraftingTableSide,

            SkyBerryBlock,

            BerrySponge;
}
//Bloom
//Drought
//Ancient
//Storm