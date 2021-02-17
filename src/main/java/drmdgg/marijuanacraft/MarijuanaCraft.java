package drmdgg.marijuanacraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import drmdgg.marijuanacraft.init.BlockInit;
import drmdgg.marijuanacraft.init.ItemInit;
import drmdgg.marijuanacraft.init.ModContainerTypes;
import drmdgg.marijuanacraft.init.ModTileEntityTypes;
import drmdgg.marijuanacraft.network.PacketHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MarijuanaCraft.MOD_ID)
public class MarijuanaCraft {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "marijuanacraft";
	public static final ItemGroup MCRAFT_GROUP = new McraftGroup("mcrafttab");

	public MarijuanaCraft() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(bus);
		ModContainerTypes.CONTAINER_TYPES.register(bus);
		MinecraftForge.EVENT_BUS.register(this);
		PacketHandler.register();
	} 
	
	private void setup(final FMLCommonSetupEvent event) {
		
	}
		
		public static class McraftGroup extends ItemGroup {
			

			public McraftGroup(String label) {
				super(label);
			}

			@Override
			public ItemStack createIcon() {
				return ItemInit.MARIJUANA_BUD.get().getDefaultInstance();
			}
		
	}
}

