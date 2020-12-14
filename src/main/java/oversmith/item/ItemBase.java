package oversmith.item;

import net.minecraft.item.Item;
import oversmith.init.SmithItems;

public class ItemBase extends Item {

	public ItemBase() {
		super(new Item.Properties().group(SmithItems.SmithItems));
	}
}
