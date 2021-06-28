
package net.boogaeye.darkvlight.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.boogaeye.darkvlight.procedures.DebugDisplayOverlayIngameProcedure;
import net.boogaeye.darkvlight.DarkVsLightModVariables;

import com.google.common.collect.ImmutableMap;

@Mod.EventBusSubscriber
public class DebugOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (DebugDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"BossWorldTick2: " + (int) (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2) + "", posX + -207, posY + -94,
						-1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"BossAttackType2: " + (int) (DarkVsLightModVariables.MapVariables.get(world).BossAttackType2) + "", posX + -207, posY + -85,
						-1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"BossAttackType: " + (int) (DarkVsLightModVariables.MapVariables.get(world).BossAttackType) + "", posX + -207, posY + -76,
						-1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"BossWorldTick: " + (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick) + "", posX + -207, posY + -67, -1);
				Minecraft
						.getInstance().fontRenderer
								.drawString(event.getMatrixStack(),
										"DarkendTick: " + (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendTick) + "",
										posX + -207, posY + -58, -39169);
				Minecraft
						.getInstance().fontRenderer
								.drawString(event.getMatrixStack(),
										"EnlightendTick: " + (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendTick) + "",
										posX + -207, posY + -49, -256);
				Minecraft
						.getInstance().fontRenderer
								.drawString(event.getMatrixStack(),
										"Darkend: " + (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend) + "",
										posX + -207, posY + -40, -39169);
				Minecraft
						.getInstance().fontRenderer
								.drawString(event.getMatrixStack(),
										"Enlightend: " + (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend) + "",
										posX + -207, posY + -31, -3355648);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"TempleX: " + (int) (DarkVsLightModVariables.MapVariables.get(world).TempleX) + "", posX + -207, posY + -13, -39322);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"TempleY: " + (int) (DarkVsLightModVariables.MapVariables.get(world).TempleY) + "", posX + -207, posY + -4, -52429);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"TempleZ: " + (int) (DarkVsLightModVariables.MapVariables.get(world).TempleZ) + "", posX + -207, posY + 5, -52429);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Boss1Defeated: " + (DarkVsLightModVariables.MapVariables.get(world).Boss1Defeated) + "", posX + -207, posY + -22, -6736897);
			}
		}
	}
}
