package cn.asone.nodarkness.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Inject(method = "setStatusEffect", at = @At("HEAD"), cancellable = true)
    public void setStatusEffect(StatusEffectInstance effect, Entity source, CallbackInfo ci) {
        if (effect.getEffectType() == StatusEffects.DARKNESS) {
            ci.cancel();
        }
    }
}
