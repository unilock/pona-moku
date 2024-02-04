package io.github.nalathnidragon.pona_moku.config;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import io.github.nalathnidragon.pona_moku.PonaMoku;
import net.fabricmc.loader.api.FabricLoader;

public final class PonaMokuConfig extends WrappedConfig {
	public static final PonaMokuConfig instance =
		PonaMokuConfig.createToml(
			FabricLoader.getInstance().getConfigDir(),
			PonaMoku.MODID, // what the folder is called ".../.minecraft/config/pona_moku/" in this case
			"config", // what the file is called. "config.toml" in this case
			PonaMokuConfig.class);
	@Comment("Food's nourishment is multiplied by this to determine the health it restores.")
	public final Float health_scale = 1f;
	@Comment("Food's saturation is multiplied by this to determine the amount of absorption it grants.")
	public final Float absorption_scale = 1f;

	@Comment("Maximum absorption that food can provide, in half-hearts.")
	public final Float max_absorption_from_food = 20f;

	@Comment("Time it takes to eat food based on the absorption provided, in ticks. Default matches bread in vanilla.")
	public final Float eat_time_per_absorption = 5.33f;

	@Comment("Time it takes to eat food based on the health it heals.")
	public final Float eat_time_per_health = 0f;

	@Comment("Minimum time taken for food to be eaten, in ticks.")
	public final Integer min_eat_time = 8;

	@Comment("Whether the Nausea status should prevent the player from being able to eat.")
	public final Boolean nausea_prevents_eating = true;

	@Comment("Amount of damage sufficient to interrupt eating. 0 to disable.")
	public final Float interrupt_eating_threshold = 2f;


/*
	@Comment("Test Value")
	public final Double test = 1.0;
	@Comment("Test List")
	@FloatRange(min = -10.0, max = 10.0)
	// The first value, 0.0, sets the default value. The created list is: test2 = [1.0, -2.0]
	public final ValueList<Double> test2 = ValueList.create(0.0, 1.0, -2.0);

	@Comment("Test Map")
	public final ValueMap<Integer> test3 = ValueMap
		.builder(0) // default value
		.put("one", 1)
		.put("two", 2)
		.put("three", 3)
		.build();

	// Note: Default values aren't automatically used.
	// test2.get(5) will throw an indexOutOfBoundsException
	// test3.get("five") evaluates to null

	public final GeneralConfig general = new GeneralConfig();

	public static class GeneralConfig extends Section {
		@Comment("Test Value 1")
		@FloatRange(min = -10.0, max = 10.0)
		public final Double test = 1.0;
	}*/
}
