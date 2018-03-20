package leo.extinguish;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class KeybindExtinguish {
	public static KeyBinding extinguishKeybind;
	
	public static void init() {
		extinguishKeybind = new KeyBinding("key.extinguish.desc", Keyboard.KEY_GRAVE, "key.categories.misc");
		ClientRegistry.registerKeyBinding(extinguishKeybind);
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void keyEvent(KeyInputEvent event) {
		if (extinguishKeybind.isPressed()) {
			Minecraft.getMinecraft().player.sendChatMessage("/extinguish");
		}
	}
}
