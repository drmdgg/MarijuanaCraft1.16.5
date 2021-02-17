package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MarijuanaCraft.MOD_ID);
	
	public static final RegistryObject<Item> MARIJUANA_BUD = ITEMS.register("marijuana_bud", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	
	//block items
	
	public static final RegistryObject<BlockItem> BUTANE = ITEMS.register("butane",
			() -> new BlockItem(BlockInit.BUTANE.get(),
					new Item.Properties().group(MarijuanaCraft.MCRAFT_GROUP)));
	
	public static final RegistryObject<BlockItem> GROW_LIGHT = ITEMS.register("grow_light",
			() -> new BlockItem(BlockInit.BULB.get(),
					new Item.Properties().group(MarijuanaCraft.MCRAFT_GROUP)));
	
	public static final RegistryObject<BlockItem> VOBLOCK = ITEMS.register("vacuumoven",
			() -> new BlockItem(BlockInit.VOBLOCK.get(),
					new Item.Properties().group(MarijuanaCraft.MCRAFT_GROUP)));

	public static final RegistryObject<BlockItem> COLUMNBLOCK = ITEMS.register("column",
			() -> new BlockItem(BlockInit.COLUMNBLOCK.get(),
					new Item.Properties().group(MarijuanaCraft.MCRAFT_GROUP)));
}
