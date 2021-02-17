package drmdgg.marijuanacraft.client;

import org.apache.logging.log4j.LogManager;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.gui.ColumnScreen;
import drmdgg.marijuanacraft.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MarijuanaCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public final class ClientModEventSubscriber {	
	
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MarijuanaCraft.MOD_ID + " Client Mod Event Subscriber");

	
	@SubscribeEvent

	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {


		// Register ContainerType Screens

		ScreenManager.registerFactory(ModContainerTypes.COLUMN.get(), ColumnScreen::new);
		
		LOGGER.debug("Registered ContainerType Screens");
	



	}



}