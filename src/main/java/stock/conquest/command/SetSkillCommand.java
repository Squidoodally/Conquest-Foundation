package stock.conquest.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import stock.conquest.component.PlayerSkillsBinder;
import stock.conquest.scoreboard.SkillScoreboardUpdater;

import java.util.Map;

import static stock.conquest.client.player_skills.PlayerSkills.*;

public class SetSkillCommand {

    private static final Map<String, String> VALID_SKILLS = Map.ofEntries(
            Map.entry("blade", SKILL_BLADE_KEY),
            Map.entry("blunt", SKILL_BLUNT_KEY),
            Map.entry("thrust", SKILL_THRUST_KEY),
            Map.entry("marksman", SKILL_MARKSMAN_KEY),
            Map.entry("block", SKILL_BLOCK_KEY),
            Map.entry("athletics", SKILL_ATHLETICS_KEY),
            Map.entry("acrobatics", SKILL_ACROBATICS_KEY),
            Map.entry("alteration", SKILL_ALTERATION_KEY),
            Map.entry("destruction", SKILL_DESTRUCTION_KEY),
            Map.entry("mysticism", SKILL_MYSTICISM_KEY),
            Map.entry("restoration", SKILL_RESTORATION_KEY),
            Map.entry("alchemy", SKILL_ALCHEMY_KEY),
            Map.entry("blacksmithing", SKILL_BLACKSMITHING_KEY),
            Map.entry("mercantile", SKILL_MERCANTILE_KEY)
    );

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("setskill")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .then(CommandManager.argument("skill", StringArgumentType.string())
                                        .suggests((context, builder) -> {
                                            String input = StringArgumentType.getString(context, "skill").toLowerCase();
                                            for (String skill : VALID_SKILLS.keySet()) {
                                                if (skill.startsWith(input)) {
                                                    builder.suggest(skill);
                                                }
                                            }
                                            return builder.buildFuture();
                                        })
                                        .then(CommandManager.argument("value", IntegerArgumentType.integer(0))
                                                .executes(context -> {
                                                    PlayerEntity targetPlayer = EntityArgumentType.getPlayer(context, "player");
                                                    String skillInput = StringArgumentType.getString(context, "skill").toLowerCase();

                                                    if (!VALID_SKILLS.containsKey(skillInput)) {
                                                        context.getSource().sendError(Text.literal("Invalid skill: " + skillInput));
                                                        return 0;
                                                    }

                                                    String normalizedKey = VALID_SKILLS.get(skillInput);
                                                    int value = IntegerArgumentType.getInteger(context, "value");

                                                    // Set the skill value
                                                    PlayerSkillsBinder.PLAYER_SKILLS.get(targetPlayer).setSkill(normalizedKey, value);

                                                    // Update the scoreboard with the new skill value
                                                    SkillScoreboardUpdater.updateScoreboard(targetPlayer);

                                                    // Send feedback to the player who executed the command
                                                    context.getSource().sendFeedback(() ->
                                                            Text.translatable("command.setskill.success", normalizedKey, value, targetPlayer.getDisplayName()), true);

                                                    return 1;
                                                })
                                        )
                                )
                        )
        );
    }
}