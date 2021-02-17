package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MarijuanaCraft.MOD_ID);
	
	public static final RegistryObject<TileEntityType<ColumnTileEntity>> COLUMN = TILE_ENTITY_TYPES.register("column",
			() -> TileEntityType.Builder.create(ColumnTileEntity::new, BlockInit.COLUMNBLOCK.get()).build(null));

	
	public static final TileEntityType<?> vacuumoven = null;
	
	public static final TileEntityType<?> churn = null;
}
