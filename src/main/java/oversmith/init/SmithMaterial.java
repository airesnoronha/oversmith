package oversmith.init;

public enum SmithMaterial {
	WOOD(3, 1.4f, 0, 3, 1, 64),
	STONE(5, 1.6f, 0, 5, 1, 128),
	IRON(7, 1.7f, 0, 7, 1, 256),
	GOLD(6, 1.6f, 0, 6, 1, 512);

	public final float attackDamage;

	public final float attackSpeed;

	public final float movementSpeed;

	public final float breakSpeed;

	public final float miningLevel;

	public final int durability;

	SmithMaterial(float attackDamage, float attackSpeed, float movementSpeed, float breakSpeed, float miningLevel, int durability) {
		this.attackDamage = attackDamage;
		this.attackSpeed = attackSpeed;
		this.movementSpeed = movementSpeed;
		this.breakSpeed = breakSpeed;
		this.miningLevel = miningLevel;
		this.durability = durability;
	}
}
