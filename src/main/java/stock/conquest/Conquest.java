package stock.conquest;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.conquest.client.ModAttributes;
import stock.conquest.item.ModItems;

public class Conquest implements ModInitializer {
	public static final String MOD_ID = "conquest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModAttributes.register();		
	}
}