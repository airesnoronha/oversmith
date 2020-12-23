package oversmith.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import oversmith.init.SmithMaterial;

@MethodsReturnNonnullByDefault
public class SwordItem extends WeaponItem {

	public SwordItem(Properties properties, SmithMaterial material) {
		super(properties, material);
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
