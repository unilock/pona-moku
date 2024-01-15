package io.github.nalathnidragon.pona_moku.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = HungerManager.class, priority = 9999)
public abstract class HungerManagerMixin {
	@Inject(method = "update", at = @At("HEAD"), cancellable = true)
	private void pona_moku$dontUpdate(PlayerEntity player, CallbackInfo ci)
	{
		ci.cancel();
	}

	@Inject(method = "add", at = @At("HEAD"), cancellable = true)
	private void pona_moku$dontAdd(int food, float saturationModifier, CallbackInfo ci)
	{
		ci.cancel();
	}

	@Inject(method = "addExhaustion", at = @At("HEAD"), cancellable = true)
	private void pona_moku$dontAddExhaustion(float exhaustion, CallbackInfo ci)
	{
		ci.cancel();
	}

	@Inject(method = "getFoodLevel", at = @At("RETURN"), cancellable = true)
	private void pona_moku$fakeFoodLevel(CallbackInfoReturnable<Integer> cir)
	{
		cir.setReturnValue(20);
	}

	@Inject(method = "getPrevFoodLevel", at = @At("RETURN"), cancellable = true)
	private void pona_moku$fakePrevFoodLevel(CallbackInfoReturnable<Integer> cir)
	{
		cir.setReturnValue(20);
	}

	@Inject(method = "getExhaustion", at = @At("RETURN"), cancellable = true)
	private void pona_moku$fakeExhaustion(CallbackInfoReturnable<Float> cir)
	{
		cir.setReturnValue(null);
	}

	@Inject(method = "getSaturationLevel", at = @At("RETURN"), cancellable = true)
	private void pona_moku$fakeSaturationLevel(CallbackInfoReturnable<Float> cir)
	{
		cir.setReturnValue(0.0F);
	}
}
