package drmdgg.marijuanacraft.init.blocks.tileentities;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BulbBlock extends Block {
	   public BulbBlock(Properties properties) {
		super(properties);
		
	}

	@Nullable
	   @Override
		public TileEntity createTileEntity(final BlockState state, final IBlockReader world) 
	   	{
		   return ModTileEntityTypes.vacuumoven.create();
		 }
	   
		@Override
		public boolean hasTileEntity(final BlockState state)
		{
			return true;
	   }
		public boolean isOpaqueCube(BlockState state)
		{
			return false;
		}
		
		public BlockRenderType getRenderLayer()
		{
			return BlockRenderType.INVISIBLE;
		}
}
