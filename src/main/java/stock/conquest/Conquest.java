package stock.conquest;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.conquest.client.CustomAttributes;
import stock.conquest.item.ModItems;

public class Conquest implements ModInitializer {
	public static final String MOD_ID = "conquest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		System.out.println("ConquestMod initialized. Custom attributes loaded: "
				+ Registries.ATTRIBUTE.getId(CustomAttributes.STAMINA.value()) + ", "
				+ Registries.ATTRIBUTE.getId(CustomAttributes.MANA.value()));
	}
}