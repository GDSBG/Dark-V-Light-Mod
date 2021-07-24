
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.boogaeye.darkvlight.procedures.RevivalBerryFoodEatenProcedure;
import net.boogaeye.darkvlight.itemgroup.DVLFoodItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.util.Map;
import java.util.HashMap;

@DarkVsLightModElements.ModElement.Tag
public class RevivalBerryItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:revival_berry")
	public static final Item block = null;
	public RevivalBerryItem(DarkVsLightModElements instance) {
		super(instance, 492);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(DVLFoodItemGroup.tab).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.1f).setAlwaysEdible().build()));
			setRegistryName("revival_berry");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 10;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RevivalBerryFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
