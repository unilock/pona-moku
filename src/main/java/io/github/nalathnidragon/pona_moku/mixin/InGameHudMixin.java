package io.github.nalathnidragon.pona_moku.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	/*
	@Redirect(method="renderStatusBars", at=@At(value = "INVOKE", target="Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"))
	public int pretendHearts(InGameHud instance, LivingEntity entity)
	{
		return 1;
	}
	*/

	@ModifyConstant(method="renderStatusBars", constant=@Constant(intValue = 10, ordinal = 0), slice=@Slice(from=@At(value="INVOKE_STRING",target="Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", args={"ldc=food"})))
	private int pona_moku$disruptLoop(int value)
	{
		return 0;
	}
}
