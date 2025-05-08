package stock.conquest;

import net.minecraft.server.network.ServerPlayerEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.conquest.command.SetAttributeCommand;
import stock.conquest.command.SetSkillCommand;
import stock.conquest.command.SetStatCommand;
import stock.conquest.item.ModItems;
import stock.conquest.scoreboard.AttributeScoreboard;
import stock.conquest.scoreboard.AttributeScoreboardUpdater;
import stock.conquest.scoreboard.SkillScoreboard;
import stock.conquest.scoreboard.SkillScoreboardUpdater;
import stock.conquest.scoreboard.StatScoreboard;
import stock.conquest.scoreboard.StatScoreboardUpdater;

public class Conquest implements ModInitializer {
	public static final String MOD_ID = "conquest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		// Register commands on server startup
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			SetStatCommand.register(server.getCommandManager().getDispatcher());
			SetAttributeCommand.register(server.getCommandManager().getDispatcher());
			SetSkillCommand.register(server.getCommandManager().getDispatcher());
		});

		// Register connection events for when players join the server
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();

			// Register and update scoreboards for the player
			StatScoreboard.registerObjectivesForPlayer(player);
			StatScoreboardUpdater.updateScoreboard(player);

			AttributeScoreboard.registerObjectivesForPlayer(player);
			AttributeScoreboardUpdater.updateScoreboard(player);

			SkillScoreboard.registerObjectivesForPlayer(player);
			SkillScoreboardUpdater.updateScoreboard(player);
		});

		// Register mod items
		ModItems.registerModItems();
	}
}