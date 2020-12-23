package oversmith.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import oversmith.OverSmith;
import oversmith.client.render.item.SwordRender;
import oversmith.item.SwordItem;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SmithItems {

	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OverSmith.MOD_ID);

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

	public static ItemGroup SmithItems = new SmithItemGroupClass("smith_items");

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

	public static RegistryObject<Item> SWORD = ITEMS.register("sword", () -> new SwordItem(new Item.Properties().group(SmithItems).setISTER(() -> SwordRender::new), SmithMaterial.WOOD)) ;
	public static RegistryObject<Item> SABER = ITEMS.register("saber", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));
	public static RegistryObject<Item> SPEAR = ITEMS.register("spear", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));
	public static RegistryObject<Item> AXE = ITEMS.register("axe", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));
	public static RegistryObject<Item> HOE = ITEMS.register("hoe", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));
	public static RegistryObject<Item> PICKAXE = ITEMS.register("pickaxe", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));
	public static RegistryObject<Item> SHOVEL = ITEMS.register("shovel", () -> new SwordItem(new Item.Properties().group(SmithItems), SmithMaterial.WOOD));

	//Crafting items
	public static RegistryObject<Item> AIR_PISTON_DISK = ITEMS.register("air_piston_disk", () -> new Item(new Item.Properties().group(SmithItems)));
}
