package leo.extinguish;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.common.config.Config(modid = Extinguish.MODID)
public class ExtinguishConfig {
	@Config.Name("extinguishCommandPermissionLevel")
	@Config.Comment("Permission level needed to use the extinguish command. 0 if anyone can use it.")
	public static int extinguishCommandPermissionLevel = 2;
	
	@Config.Name("extinguishDefaultRange")
	@Config.Comment("The range in which fire will be extinguished in each direction when typing /extinguish with no parameters")
	@Config.RangeInt(min = 0, max = Integer.MAX_VALUE)
	public static int extinguishDefaultRange = 200;
	
	@Config.Name("fireBlocks")
	@Config.Comment("The registry names of blocks (e.g. minecraft:fire) to be turned to air by /extinguish")
	public static String[] fireBlocks = {"minecraft:fire"};
	
	@Mod.EventBusSubscriber(modid = Extinguish.MODID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Extinguish.MODID)) {
				ConfigManager.sync(Extinguish.MODID, Config.Type.INSTANCE);
			}
		}
	}
}
