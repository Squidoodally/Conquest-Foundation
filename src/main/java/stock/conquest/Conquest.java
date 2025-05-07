package stock.conquest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.conquest.command.SetAttributeCommand;
import stock.conquest.command.SetSkillCommand;
import stock.conquest.command.SetStatCommand;
import stock.conquest.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import stock.conquest.scoreboard.*;

public class Conquest implements ModInitializer {
	public static final String MOD_ID = "conquest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			SetStatCommand.register(server.getCommandManager().getDispatcher());
		});
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			SetAttributeCommand.register(server.getCommandManager().getDispatcher());
		});
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			SetSkillCommand.register(server.getCommandManager().getDispatcher());
		});
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			StatScoreboard.registerObjectivesForPlayer(player);
			StatScoreboardUpdater.updateScoreboard(player);
		});
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			AttributeScoreboard.registerObjectivesForPlayer(player);
			AttributeScoreboardUpdater.updateScoreboard(player);
		});
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			SkillScoreboard.registerObjectivesForPlayer(player);
			SkillScoreboardUpdater.updateScoreboard(player);
		});
		ModItems.registerModItems();
	}
}