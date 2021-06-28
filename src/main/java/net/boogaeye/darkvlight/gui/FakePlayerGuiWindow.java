
package net.boogaeye.darkvlight.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.boogaeye.darkvlight.procedures.HP9Procedure;
import net.boogaeye.darkvlight.procedures.HP8Procedure;
import net.boogaeye.darkvlight.procedures.HP7Procedure;
import net.boogaeye.darkvlight.procedures.HP6Procedure;
import net.boogaeye.darkvlight.procedures.HP5Procedure;
import net.boogaeye.darkvlight.procedures.HP4Procedure;
import net.boogaeye.darkvlight.procedures.HP3Procedure;
import net.boogaeye.darkvlight.procedures.HP2Procedure;
import net.boogaeye.darkvlight.procedures.HP20Procedure;
import net.boogaeye.darkvlight.procedures.HP1Procedure;
import net.boogaeye.darkvlight.procedures.HP19Procedure;
import net.boogaeye.darkvlight.procedures.HP18Procedure;
import net.boogaeye.darkvlight.procedures.HP17Procedure;
import net.boogaeye.darkvlight.procedures.HP16Procedure;
import net.boogaeye.darkvlight.procedures.HP15Procedure;
import net.boogaeye.darkvlight.procedures.HP14Procedure;
import net.boogaeye.darkvlight.procedures.HP13Procedure;
import net.boogaeye.darkvlight.procedures.HP12Procedure;
import net.boogaeye.darkvlight.procedures.HP11Procedure;
import net.boogaeye.darkvlight.procedures.HP10Procedure;
import net.boogaeye.darkvlight.procedures.Armor9Procedure;
import net.boogaeye.darkvlight.procedures.Armor8Procedure;
import net.boogaeye.darkvlight.procedures.Armor7Procedure;
import net.boogaeye.darkvlight.procedures.Armor6Procedure;
import net.boogaeye.darkvlight.procedures.Armor5Procedure;
import net.boogaeye.darkvlight.procedures.Armor4Procedure;
import net.boogaeye.darkvlight.procedures.Armor3Procedure;
import net.boogaeye.darkvlight.procedures.Armor2Procedure;
import net.boogaeye.darkvlight.procedures.Armor20Procedure;
import net.boogaeye.darkvlight.procedures.Armor1Procedure;
import net.boogaeye.darkvlight.procedures.Armor19Procedure;
import net.boogaeye.darkvlight.procedures.Armor18Procedure;
import net.boogaeye.darkvlight.procedures.Armor17Procedure;
import net.boogaeye.darkvlight.procedures.Armor16Procedure;
import net.boogaeye.darkvlight.procedures.Armor15Procedure;
import net.boogaeye.darkvlight.procedures.Armor14Procedure;
import net.boogaeye.darkvlight.procedures.Armor13Procedure;
import net.boogaeye.darkvlight.procedures.Armor12Procedure;
import net.boogaeye.darkvlight.procedures.Armor11Procedure;
import net.boogaeye.darkvlight.procedures.Armor10Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class FakePlayerGuiWindow extends ContainerScreen<FakePlayerGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = FakePlayerGui.guistate;
	public FakePlayerGuiWindow(FakePlayerGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 200;
	}
	private static final ResourceLocation texture = new ResourceLocation("dark_vs_light:textures/fake_player.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		if (HP1Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 51, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 51, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (Armor1Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 51, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 51, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 60, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 60, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor5Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 69, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor6Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 69, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor7Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 78, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor8Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 78, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor9Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 87, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor10Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 87, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor11Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 96, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor12Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 96, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor13Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 105, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor14Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 105, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor15Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor16Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor17Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 123, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor18Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 123, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (Armor19Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorleft.png"));
			this.blit(ms, this.guiLeft + 132, this.guiTop + 42, 0, 0, 9, 9, 9, 9);
		}
		if (Armor20Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/armorright.png"));
			this.blit(ms, this.guiLeft + 132, this.guiTop + 42, 0, 0, 8, 8, 8, 8);
		}
		if (HP3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 60, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 60, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP5Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 69, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP6Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 69, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP7Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 78, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP8Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 78, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP9Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 87, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP10Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 87, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP11Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 96, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP12Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 96, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP13Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 105, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP14Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 105, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP15Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP16Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP17Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 123, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP18Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 123, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP19Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartleft.png"));
			this.blit(ms, this.guiLeft + 132, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		if (HP20Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/heartright.png"));
			this.blit(ms, this.guiLeft + 132, this.guiTop + 24, 0, 0, 8, 8, 8, 8);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Survivor Bag", 61, 1, -12829636);
		this.font.drawString(ms, "Armor", 146, 3, -16724788);
		this.font.drawString(ms, "Main Hand", 2, 2, -39322);
		this.font.drawString(ms, "Off Hand", 4, 31, -154);
		this.font.drawString(ms, "Heal Source", 2, 61, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
