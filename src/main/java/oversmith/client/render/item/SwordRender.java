package oversmith.client.render.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.VertexBufferConsumer;
import oversmith.client.ClientRegistryEvents;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SwordRender extends ItemStackTileEntityRenderer {

	@OnlyIn(Dist.CLIENT)
	@Override
	public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
		super.func_239207_a_(stack, p_239207_2_, matrixStack, buffer, combinedLight, combinedOverlay);
		VertexBufferConsumer consumer = new VertexBufferConsumer(buffer.getBuffer(RenderType.getSolid()));
		Minecraft.getInstance().getModelManager().getModel(ClientRegistryEvents.ITEM_SPEAR_MODEL).getQuads(null,null, new Random(), EmptyModelData.INSTANCE).get(0).pipe(consumer);
	}
}
