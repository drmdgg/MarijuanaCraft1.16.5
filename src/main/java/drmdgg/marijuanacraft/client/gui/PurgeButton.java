package drmdgg.marijuanacraft.client.gui;

import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.text.ITextComponent;

public class PurgeButton extends AbstractButton {

	public PurgeButton(int x, int y, int width, int height, ITextComponent title) {
		super(x, y, width, height, title);
		
	}

	@Override
	public void onPress() {
	}
	
	public void onClick(double p_onClick_1_, double p_onClick_3_) {
	      this.onPress();
}
	
	
}