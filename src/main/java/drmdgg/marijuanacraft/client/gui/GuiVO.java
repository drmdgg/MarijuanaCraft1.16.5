package drmdgg.marijuanacraft.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.container.VacuumOvenContainer;
import drmdgg.marijuanacraft.init.blocks.tileentities.VacuumOvenTileEntity;
import drmdgg.marijuanacraft.network.PacketHandler;
import drmdgg.marijuanacraft.network.C2SRequestStartOven;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiVO extends ContainerScreen<VacuumOvenContainer> {

	VacuumOvenTileEntity tileEntity;
    private static final int WIDTH = 179;
    private static final int HEIGHT = 151;
    
private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MarijuanaCraft.MOD_ID, "textures/gui/vacuumoven.png");


public GuiVO(final VacuumOvenContainer container, final PlayerInventory inventory, final ITextComponent title) 
{
	super(container, inventory, title);
	
	
}



@Override
public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {

	this.renderBackground(matrixStack);

	super.render(matrixStack, mouseX, mouseY, partialTicks);

	this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

}



@Override

protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, final int mouseX, final int mouseY) {

	super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);

	// Copied from AbstractFurnaceScreen#drawGuiContainerForegroundLayer

	String s = this.title.getUnformattedComponentText();

	this.font.drawString(matrixStack, s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);

	this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getUnformattedComponentText(), 8.0F, (float) (this.ySize - 96 + 2), 0x404040);

	final VacuumOvenTileEntity tileEntity = this.container.tileEntity;
	this.font.drawString(matrixStack, tileEntity.smeltTimeLeft + " / " + tileEntity.maxSmeltTime, 8.0F, this.ySize, 0x404040);
	this.font.drawString(matrixStack, tileEntity.fuelBurnTimeLeft + " / " + tileEntity.maxFuelBurnTime, 8.0F, this.ySize + 14, 0x404040);

    int relX = (this.width - WIDTH) / 2;

    int relY = (this.height - HEIGHT) / 2;

}

private void addButton(Button button) {
	
	
}



@Override

protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, final float partialTicks, final int mouseX, final int mouseY) {

	GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

	this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);

	int startX = this.guiLeft;

	int startY = this.guiTop;



	// Screen#blit draws a part of the current texture (assumed to be 256x256) to the screen

	// The parameters are (x, y, u, v, width, height)

	this.blit(matrixStack, startX, startY, 0, 0, this.xSize, this.ySize);
	
	final VacuumOvenTileEntity tileEntity = container.tileEntity;
	if (tileEntity.isBurning()) {
	 int k = getBurnLeftScaled();
         this.blit(matrixStack, startX + 56, startY + 36 + 12 - k, 176, 12 - k, 14, k + 1);
	 }

	int l = getCookProgressionScaled();
	this.blit(matrixStack, startX + 79, startY + 34, 176, 14, l + 1, 16);
    l = l / 24 * 30;
    
   }

private int getBurnLeftScaled() {
	final VacuumOvenTileEntity tileEntity = this.container.tileEntity;
	final short smeltTimeLeft = tileEntity.smeltTimeLeft;
	final short maxSmeltTime = tileEntity.maxSmeltTime;
	if (smeltTimeLeft <= 0 || maxSmeltTime <= 0)
		return 0;
	return (maxSmeltTime - smeltTimeLeft) * 24 / maxSmeltTime; // 24 is the width of the arrow
}

private int getCookProgressionScaled() {
	final VacuumOvenTileEntity tileEntity = this.container.tileEntity;
	if (tileEntity.maxFuelBurnTime <= 0)
		return 0;
	return tileEntity.fuelBurnTimeLeft * 14 / tileEntity.maxFuelBurnTime; // 14 is the height of the flames
}

@Override
public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_) {
	// TODO Auto-generated method stub
	return super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, p_mouseClicked_5_);
}

}















