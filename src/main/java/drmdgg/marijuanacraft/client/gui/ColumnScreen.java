package drmdgg.marijuanacraft.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.container.ColumnContainer;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnTileEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ColumnScreen extends ContainerScreen<ColumnContainer> {
	
private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MarijuanaCraft.MOD_ID, "textures/gui/column.png");




public ColumnScreen(ColumnContainer container, PlayerInventory inventory, ITextComponent title) 
{
	super(container, inventory, title);
	this.guiLeft = 0;
	this.guiTop = 0;
	this.xSize = 175;
	this.ySize = 183;

}

@Override
public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {

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
	final ColumnTileEntity tileEntity = this.container.tileEntity;
	this.font.drawString(matrixStack, tileEntity.smeltTimeLeft + " / " + tileEntity.maxSmeltTime, 8.0F, this.ySize, 0x404040);
	this.font.drawString(matrixStack, tileEntity.fuelBurnTimeLeft + " / " + tileEntity.maxFuelBurnTime, 8.0F, this.ySize + 14, 0x404040);

}

private int getBurnLeftScaled() {
	final ColumnTileEntity tileEntity = this.container.tileEntity;
	final short smeltTimeLeft = tileEntity.smeltTimeLeft;
	final short maxSmeltTime = tileEntity.maxSmeltTime;
	if (smeltTimeLeft <= 0 || maxSmeltTime <= 0)
		return 0;
	return (maxSmeltTime - smeltTimeLeft) * 24 / maxSmeltTime; // 24 is the width of the arrow
}

private int getCookProgressionScaled() {
	final ColumnTileEntity tileEntity = this.container.tileEntity;
	if (tileEntity.maxFuelBurnTime <= 0)
		return 0;
	return tileEntity.fuelBurnTimeLeft * 14 / tileEntity.maxFuelBurnTime; // 14 is the height of the flames
}

@Override
protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
	RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	int i = (this.width - this.xSize) / 2;
    int j = (this.height - this.ySize) / 2;
	this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);

	int startX = this.guiLeft;

	int startY = this.guiTop;
	this.blit(matrixStack, startX, startY, 0, 0, this.xSize, this.ySize);
	final ColumnTileEntity tileEntity = container.tileEntity;
	if (tileEntity.isBurning()) {
	 int k = getBurnLeftScaled();
	 int l = MathHelper.clamp((18 * k + 20 - 1) / 20, 0, 18);
     if (l > 0) {
        this.blit(matrixStack, i + 60, j + 44, 176, 29, l, 4);
	 }
	
	int i1 = getCookProgressionScaled();
	 if (i1 > 0) {
         int j1 = (int)(28.0F * (1.0F - (float)i1 / 400.0F));
         if (j1 > 0) {
            this.blit(matrixStack, i + 97, j + 16, 176, 0, 9, j1);
         }
   }
	}
	
}
}







