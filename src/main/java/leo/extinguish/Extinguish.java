package leo.extinguish;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Extinguish.MODID, name = Extinguish.NAME, version = Extinguish.VERSION)
public class Extinguish {
    public static final String MODID = "extinguish";
    public static final String NAME = "Extinguish";
    public static final String VERSION = "1.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    		KeybindExtinguish.init();
    		FMLCommonHandler.instance().bus().register(new KeybindExtinguish());
    }
    
    @EventHandler
    public void initServer(FMLServerStartingEvent event) {
    		event.registerServerCommand(new CommandExtinguish());
    }
}
