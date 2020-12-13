package oversmith.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import oversmith.OverSmith;
import oversmith.items.ItemSword;

import javax.annotation.Nullable;

public class SmithItems {

	@MethodsReturnNonnullByDefault
	public static class SmithItemGroupClass extends ItemGroup {
		public SmithItemGroupClass(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return Items.IRON_INGOT.getDefaultInstance();
		}
	}

	public static ItemGroup SmithItems = new SmithItemGroupClass("Smith_items");

	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OverSmith.MOD_ID);

	public static RegistryObject<Item> SWORD = ITEMS.register("sword", ItemSword::new);

	public static class MaterialGetter implements IItemPropertyGetter {
		private String part;

		public MaterialGetter(String part) {
			this.part = part;
		}

		@Override
		public float call(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity) {
			CompoundNBT tag =  stack.getTag();
			if(tag != null) {
				if (tag.contains(this.part)) {
					return tag.getFloat(this.part);
				}
			}
			return 0;
		};
	}

	/**
	 * This is a temporary location, certainly gonna change to a better class
	 */
	public static void initProperties() {
		ItemModelsProperties.registerProperty(SWORD.get(), new ResourceLocation(OverSmith.MOD_ID, "grip"), new MaterialGetter("grip"));
		ItemModelsProperties.registerProperty(SWORD.get(), new ResourceLocation(OverSmith.MOD_ID, "blade"),  new MaterialGetter("blade"));
		ItemModelsProperties.registerProperty(SWORD.get(), new ResourceLocation(OverSmith.MOD_ID, "pommel"),  new MaterialGetter("pommel"));
		ItemModelsProperties.registerProperty(SWORD.get(), new ResourceLocation(OverSmith.MOD_ID, "guard"),  new MaterialGetter("guard"));
	}
}
