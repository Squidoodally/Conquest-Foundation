package stock.conquest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import stock.conquest.client.CustomHudRenderer;

public class ConquestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(CustomHudRenderer::render);
    }
}