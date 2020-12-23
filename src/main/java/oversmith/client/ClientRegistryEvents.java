package oversmith.client;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import oversmith.OverSmith;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistryEvents {

	public static final ResourceLocation ITEM_SWORD_MODEL = new ResourceLocation(OverSmith.MOD_ID, "item/sword");
	public static final ResourceLocation ITEM_SPEAR_MODEL = new ResourceLocation(OverSmith.MOD_ID, "item/spear");

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ModelLoader.addSpecialModel(ITEM_SWORD_MODEL);
		ModelLoader.addSpecialModel(ITEM_SPEAR_MODEL);
	}

}
