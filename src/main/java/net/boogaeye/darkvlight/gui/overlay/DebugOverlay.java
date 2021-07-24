
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
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (DebugDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString(
						event.getMatrixStack(), "Gliph: " + (int) (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2)
								+ " BossAttackType: " + (DarkVsLightModVariables.MapVariables.get(world).BossAttackType2) + "",
						posX + -207, posY + -103, -1);
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"Darkend Defender: " + (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick) + " BossAttackType: "
										+ (DarkVsLightModVariables.MapVariables.get(world).BossAttackType) + " Defeated?: "
										+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).Boss1Defeated)
										+ "",
								posX + -207, posY + -112, -1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Darkend: "
								+ (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend)
								+ " Tick: " + ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendTick)
								+ "",
						posX + -207, posY + -85, -39169);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"Enlightend: "
								+ (int) ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
								+ " Tick: "
								+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendTick)
								+ "",
						posX + -207, posY + -76, -3355648);
				Minecraft.getInstance().fontRenderer.drawString(
						event.getMatrixStack(), "BossWorldTick3: " + (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3)
								+ " BossAttackType: " + (DarkVsLightModVariables.MapVariables.get(world).BossAttackType3) + "",
						posX + -207, posY + -94, -1);
			}
		}
	}
}
