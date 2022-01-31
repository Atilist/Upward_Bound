package net.martin1912.upwardbound.mixin;

import net.minecraft.block.BlockBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockBase.class)
public interface BlockMetaAccessor {
    @Invoker("droppedMeta")
    int upwardbound$invokeDroppedMeta(int i);
}
