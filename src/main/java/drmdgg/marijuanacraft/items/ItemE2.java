package drmdgg.marijuanacraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class ItemE2 extends Item implements IForgeItem { 
	
	 public ItemE2(Properties group) {
		super(group);
	}
	 
	 @Override
	public int getBurnTime(ItemStack stack) {
		
		return stack.isEmpty() ? super.getBurnTime(stack) : 200;
	}
	
	
}
