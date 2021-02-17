package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnBlock;
import drmdgg.marijuanacraft.init.blocks.tileentities.VOBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarijuanaCraft.MOD_ID);
	
	public static final RegistryObject<Block> BUTANE = BLOCKS.register("butane", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.GRAY)
			.hardnessAndResistance(15f, 30f)
			.harvestTool(ToolType.PICKAXE)
			.harvestLevel(1)
			.sound(SoundType.STONE)
			.setRequiresTool()));
	
	public static final RegistryObject<Block> BULB = BLOCKS.register("bulb", () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
			.hardnessAndResistance(2.0f, 3.0f)
			.sound(SoundType.GLASS)
			.setLightLevel((state) -> 100)));
	
	public static final RegistryObject<Block> VOBLOCK = BLOCKS.register("vacuumoven", () ->  new VOBlock(AbstractBlock.Properties.create(Material.GLASS)
			.hardnessAndResistance(2.0f, 3.0f)
			.setLightLevel((state) -> 30)
			.sound(SoundType.METAL)));

			
	public static final RegistryObject<Block> COLUMNBLOCK = BLOCKS.register("column", () ->  new ColumnBlock(Block.Properties.create(Material.IRON)
			.hardnessAndResistance(2.0f, 3.0f)
			.setLightLevel((state) -> 30)
			.sound(SoundType.METAL)));

}
