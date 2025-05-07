package stock.conquest.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerEntity;
import stock.conquest.component.PlayerStatsBinder;

import java.util.List;

public class SetStatCommand {

    // List of valid stat names in lowercase for suggestions
    private static final List<String> VALID_STATS = List.of(
            "strength", "finesse", "intelligence", "constitution", "willpower", "speed", "luck"
    );

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("setstat")
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .then(CommandManager.argument("stat", StringArgumentType.string())
                                        .suggests((context, builder) -> {
                                            String currentInput = StringArgumentType.getString(context, "stat").toLowerCase();
                                            for (String stat : VALID_STATS) {
                                                if (stat.startsWith(currentInput)) {
                                                    builder.suggest(stat);
                                                }
                                            }
                                            return builder.buildFuture();
                                        })
                                        .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    PlayerEntity targetPlayer = EntityArgumentType.getPlayer(context, "player");
                                                    String statInput = StringArgumentType.getString(context, "stat").toLowerCase();

                                                    if (!VALID_STATS.contains(statInput)) {
                                                        context.getSource().sendError(Text.literal("Invalid stat: " + statInput));
                                                        return 0;
                                                    }

                                                    // Normalize to match internal keys (e.g., "strength" -> "Strength")
                                                    String normalizedStat = statInput.substring(0, 1).toUpperCase() + statInput.substring(1);

                                                    int value = IntegerArgumentType.getInteger(context, "value");

                                                    PlayerStatsBinder.PLAYER_STATS.get(targetPlayer).setStat(normalizedStat, value);

                                                    context.getSource().sendFeedback(() ->
                                                            Text.translatable("command.setstat.success", normalizedStat, value, targetPlayer.getDisplayName()), true);

                                                    return 1;
                                                })
                                        )
                                )
                        )
        );
    }
}