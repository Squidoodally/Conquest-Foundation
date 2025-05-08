package stock.conquest.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import stock.conquest.component.PlayerAttributesBinder;
import stock.conquest.scoreboard.AttributeScoreboardUpdater;

import java.util.Map;

import static stock.conquest.client.player_attributes.PlayerAttributes.*;
import static stock.conquest.client.player_attributes.PlayerAttributes.PIERCE_DAMAGE_KEY;
import static stock.conquest.client.player_attributes.PlayerAttributes.RANGED_DAMAGE_KEY;
import static stock.conquest.client.player_attributes.PlayerAttributes.STRIKE_DAMAGE_KEY;

public class SetAttributeCommand {

    private static final Map<String, String> VALID_ATTRIBUTES = Map.ofEntries(
            Map.entry("max_health", MAX_HEALTH_KEY),
            Map.entry("current_health", CURRENT_HEALTH_KEY),
            Map.entry("health_regeneration_rate", REGENRATE_HEALTH_KEY),
            Map.entry("max_stamina", MAX_STAMINA_KEY),
            Map.entry("current_stamina", CURRENT_STAMINA_KEY),
            Map.entry("stamina_regeneration_rate", REGENRATE_STAMINA_KEY),
            Map.entry("max_mana", MAX_MANA_KEY),
            Map.entry("current_mana", CURRENT_MANA_KEY),
            Map.entry("mana_regeneration_rate", REGENRATE_MANA_KEY),
            Map.entry("armor_rating", ARMOR_KEY),
            Map.entry("poise", POISE_KEY),
            Map.entry("slash_defense", SLASH_DEFENSE_KEY),
            Map.entry("strike_defense", STRIKE_DEFENSE_KEY),
            Map.entry("pierce_defense", PIERCE_DEFENSE_KEY),
            Map.entry("ranged_defense", RANGED_DEFENSE_KEY),
            Map.entry("magical_defense", MAGICAL_DEFENSE_KEY),
            Map.entry("fire_defense", FIRE_DEFENSE_KEY),
            Map.entry("frost_defense", FROST_DEFENSE_KEY),
            Map.entry("shock_defense", SHOCK_DEFENSE_KEY),
            Map.entry("poison_defense", POISON_DEFENSE_KEY),
            Map.entry("slash_damage", SLASH_DAMAGE_KEY),
            Map.entry("strike_damage", STRIKE_DAMAGE_KEY),
            Map.entry("pierce_damage", PIERCE_DAMAGE_KEY),
            Map.entry("ranged_damage", RANGED_DAMAGE_KEY),
            Map.entry("magical_damage", MAGICAL_DAMAGE_KEY),
            Map.entry("fire_damage", FIRE_DAMAGE_KEY),
            Map.entry("frost_damage", FROST_DAMAGE_KEY),
            Map.entry("shock_damage", SHOCK_DAMAGE_KEY),
            Map.entry("poison_damage", POISON_DAMAGE_KEY),
            Map.entry("spell_absorption", SPELL_ABSORPTION_KEY),
            Map.entry("stamina_cost_modifier", STAMINA_COST_MODIFIER_KEY),
            Map.entry("mana_cost_modifier", MANA_COST_MODIFIER_KEY),
            Map.entry("fall_damage_received", FALL_DAMAGE_RECEIVED_KEY),
            Map.entry("run_speed", RUN_SPEED_KEY),
            Map.entry("crouch_speed", CROUCH_SPEED_KEY),
            Map.entry("swim_speed", SWIM_SPEED_KEY),
            Map.entry("jump_strength", JUMP_HEIGHT_KEY),
            Map.entry("oxygen", UNDERWATER_BREATH_KEY),
            Map.entry("potion_effectiveness", POTION_EFFECTIVENESS_KEY),
            Map.entry("disposition", DISPOSITION_KEY)
    );

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("setattribute")
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .then(CommandManager.argument("attribute", StringArgumentType.string())
                                        .suggests((context, builder) -> {
                                            String input = StringArgumentType.getString(context, "attribute").toLowerCase();
                                            for (String attr : VALID_ATTRIBUTES.keySet()) {
                                                if (attr.startsWith(input)) {
                                                    builder.suggest(attr);
                                                }
                                            }
                                            return builder.buildFuture();
                                        })
                                        .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    PlayerEntity targetPlayer = EntityArgumentType.getPlayer(context, "player");
                                                    String attrInput = StringArgumentType.getString(context, "attribute").toLowerCase();

                                                    if (!VALID_ATTRIBUTES.containsKey(attrInput)) {
                                                        context.getSource().sendError(Text.literal("Invalid attribute: " + attrInput));
                                                        return 0;
                                                    }

                                                    String normalizedKey = VALID_ATTRIBUTES.get(attrInput);
                                                    int value = IntegerArgumentType.getInteger(context, "value");

                                                    // Set the attribute in PlayerAttributesBinder
                                                    PlayerAttributesBinder.PLAYER_ATTRIBUTES.get(targetPlayer).setAttribute(normalizedKey, value);

                                                    // Update the scoreboard with the new value
                                                    AttributeScoreboardUpdater.updateScoreboard(targetPlayer);

                                                    // Send feedback to the command sender
                                                    context.getSource().sendFeedback(() ->
                                                            Text.translatable("command.setattribute.success", normalizedKey, value, targetPlayer.getDisplayName()), true);

                                                    return 1;
                                                })
                                        )
                                )
                        )
        );
    }
}