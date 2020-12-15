package oversmith.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import oversmith.init.SmithMaterial;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class WeaponItem extends Item {

	protected SmithMaterial material;

	protected final Multimap<Attribute, AttributeModifier> attributeModifiers;

	public WeaponItem(Properties properties, SmithMaterial material) {
		super(properties);
		this.material = material;
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.material.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.material.attackSpeed, AttributeModifier.Operation.ADDITION));
		attributeModifiers = builder.build();
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return this.material.durability;
	}

	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 * the damage on the stack.
	 */
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(1, attacker, (entity) -> {
			entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
		return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot,stack);
	}
}
