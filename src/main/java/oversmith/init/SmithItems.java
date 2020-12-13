package oversmith.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import oversmith.OverSmith;
import oversmith.items.ItemSword;

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

	public static RegistryObject<Item> IRON_SWORD = ITEMS.register("iron_sword", ItemSword::new);
}
