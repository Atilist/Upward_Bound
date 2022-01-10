package net.martin1912.upwardbound.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import net.martin1912.upwardbound.UpwardBound;
import net.minecraft.level.dimension.Skylands;
import net.modificationstation.stationapi.api.client.level.dimension.TravelMessageProvider;
import net.modificationstation.stationapi.api.registry.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Skylands.class)
@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class SkyMessageMixin implements TravelMessageProvider {

    @Environment(EnvType.CLIENT)
    @Override
    public String getEnteringTranslationKey() {
        return "gui." + Identifier.of(UpwardBound.MOD_ID, "enteringSkylands");
    }

    @Environment(EnvType.CLIENT)
    @Override
    public String getLeavingTranslationKey() {
        return "gui." + Identifier.of(UpwardBound.MOD_ID, "leavingSkylands");
    }
}
