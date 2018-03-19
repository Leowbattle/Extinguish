package leo.extinguish;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.common.config.Config(modid = Extinguish.MODID)
public class Config {
	@net.minecraftforge.common.config.Config.Name("extinguishCommandPermissionLevel")
	@net.minecraftforge.common.config.Config.Comment("Permission level needed to use the extinguish command. 0 if anyone can use it.")
	public static int extinguishCommandPermissionLevel = 2;
	
	@Mod.EventBusSubscriber(modid = Extinguish.MODID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Extinguish.MODID)) {
				ConfigManager.sync(Extinguish.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
			}
		}
	}
}
