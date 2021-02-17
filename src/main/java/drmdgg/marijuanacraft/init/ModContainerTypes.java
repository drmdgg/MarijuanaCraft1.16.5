package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.container.ColumnContainer;
import drmdgg.marijuanacraft.container.VacuumOvenContainer;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnBlock;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, MarijuanaCraft.MOD_ID);


	 public static final RegistryObject<ContainerType<ColumnContainer>> COLUMN = CONTAINER_TYPES
				.register("column", () -> IForgeContainerType.create(ColumnContainer::new));

	 public static final RegistryObject<ContainerType<VacuumOvenContainer>> VACUUM_OVEN = CONTAINER_TYPES
				.register("vacuumoven", () -> IForgeContainerType.create(VacuumOvenContainer::new)); 
	 
	


	}

