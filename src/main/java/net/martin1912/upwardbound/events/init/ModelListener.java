package net.martin1912.upwardbound.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.model.Model;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import static net.modificationstation.stationapi.api.registry.Identifier.of;
import static net.modificationstation.stationapi.api.client.model.json.JsonModel.get;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class ModelListener {
    public static Model skyStemNarrowBlockModel,
                        skyStemNarrowDroughtBlockModel,
                        skyStemNarrowAncientBlockModel,
                        skyStemNarrowStormBlockModel,

                        skyHatPrematureBlockModel,
                        skyHatPrematureBloomBlockModel,
                        skyHatPrematureDroughtBlockModel,
                        skyHatPrematureAncientBlockModel,
                        skyHatPrematureStormBlockModel,

                        balloonStemNarrowBlockModel,
                        balloonStemNarrowVinesBlockModel;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerModels(TextureRegisterEvent event) {
        skyStemNarrowBlockModel = get(of(MOD_ID, "skystemnarrowmodel"));
        skyStemNarrowDroughtBlockModel = get(of(MOD_ID, "skystemnarrowdroughtmodel"));
        skyStemNarrowAncientBlockModel = get(of(MOD_ID, "skystemnarrowancientmodel"));
        skyStemNarrowStormBlockModel = get(of(MOD_ID, "skystemnarrowstormmodel"));

        skyHatPrematureBlockModel = get(of(MOD_ID, "skyhatprematuremodel"));
        skyHatPrematureBloomBlockModel = get(of(MOD_ID, "skyhatprematurebloommodel"));
        skyHatPrematureDroughtBlockModel = get(of(MOD_ID, "skyhatprematuredroughtmodel"));
        skyHatPrematureAncientBlockModel = get(of(MOD_ID, "skyhatprematureancientmodel"));
        skyHatPrematureStormBlockModel = get(of(MOD_ID, "skyhatprematurestormmodel"));

        balloonStemNarrowBlockModel = get(of(MOD_ID, "balloonstemnarrowmodel"));
        balloonStemNarrowVinesBlockModel = get(of(MOD_ID, "balloonstemnarrowvinesmodel"));
    }
}
