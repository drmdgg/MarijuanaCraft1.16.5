package drmdgg.marijuanacraft.init.blocks.tileentities;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

public class VOBlock extends Block {
	
	
	public static final BooleanProperty BURNING = BooleanProperty.create("burning");
   public VOBlock(Block.Properties properties) {
      super(properties);
      this.setDefaultState(this.getDefaultState().with(BURNING, false));
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
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof VacuumOvenTileEntity) {
				final ItemStackHandler inventory = ((VacuumOvenTileEntity) tileEntity).inventory;
				for (int slot = 0; slot < inventory.getSlots(); ++slot) {
					InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
				}
			}
		}
		super.onReplaced(state, worldIn, pos, newState, isMoving);
	}
   @Override

	public ActionResultType onBlockActivated(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {

		if (!worldIn.isRemote) {

			final TileEntity tileEntity = worldIn.getTileEntity(pos);

			if (tileEntity instanceof VacuumOvenTileEntity) {

				NetworkHooks.openGui((ServerPlayerEntity) player, (VacuumOvenTileEntity) tileEntity, pos);

			}

		}

		return ActionResultType.PASS;

	}
   
   @Override
	protected void fillStateContainer(final StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder.add(BURNING));
	}
   }


