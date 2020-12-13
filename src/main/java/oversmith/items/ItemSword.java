package oversmith.items;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

@MethodsReturnNonnullByDefault
public class ItemSword extends ItemWeapon {

	public ItemSword() {
	}

	@Override
	public ItemStack getDefaultInstance() {
		ItemStack stack = super.getDefaultInstance();
		CompoundNBT tag = stack.getTag();
		if(tag == null) tag = new CompoundNBT();
		tag.putFloat("blade", 1);
		tag.putFloat("guard", 1);
		tag.putFloat("grip", 0);
		tag.putFloat("pommel", 1);
		return stack;
	}
}
