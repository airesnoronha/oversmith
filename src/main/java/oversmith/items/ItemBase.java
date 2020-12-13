package oversmith.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import oversmith.init.SmithItems;

public class ItemBase extends Item {

	public ItemBase() {
		super(new Item.Properties().group(SmithItems.SmithItems));
	}
}
