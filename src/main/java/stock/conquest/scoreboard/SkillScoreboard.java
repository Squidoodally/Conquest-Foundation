package stock.conquest.scoreboard;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

public class SkillScoreboard {
    public static final String SKILL_BLADE = "skill_blade";
    public static final String SKILL_BLUNT = "skill_blunt";
    public static final String SKILL_THRUST = "skill_thrust";
    public static final String SKILL_MARKSMAN = "skill_marksman";
    public static final String SKILL_BLOCK = "skill_block";
    public static final String SKILL_ATHLETICS = "skill_athletics";
    public static final String SKILL_ACROBATICS = "skill_acrobatics";
    public static final String SKILL_ALTERATION = "skill_alteration";
    public static final String SKILL_DESTRUCTION = "skill_destruction";
    public static final String SKILL_MYSTICISM = "skill_mysticism";
    public static final String SKILL_RESTORATION = "skill_restoration";
    public static final String SKILL_ALCHEMY = "skill_alchemy";
    public static final String SKILL_BLACKSMITHING = "skill_blacksmithing";
    public static final String SKILL_CULINARY = "skill_culinary";
    public static final String SKILL_MERCANTILE = "skill_mercantile";

    public static void registerObjectivesForPlayer(ServerPlayerEntity player) {
        Scoreboard scoreboard = Objects.requireNonNull(player.getServer()).getScoreboard();

        createObjectiveIfAbsent(scoreboard, SKILL_BLADE, Text.literal("Blade"));
        createObjectiveIfAbsent(scoreboard, SKILL_BLUNT, Text.literal("Blunt"));
        createObjectiveIfAbsent(scoreboard, SKILL_THRUST, Text.literal("Thrust"));
        createObjectiveIfAbsent(scoreboard, SKILL_MARKSMAN, Text.literal("Marksman"));
        createObjectiveIfAbsent(scoreboard, SKILL_BLOCK, Text.literal("Block"));
        createObjectiveIfAbsent(scoreboard, SKILL_ATHLETICS, Text.literal("Athletics"));
        createObjectiveIfAbsent(scoreboard, SKILL_ACROBATICS, Text.literal("Acrobatics"));
        createObjectiveIfAbsent(scoreboard, SKILL_ALTERATION, Text.literal("Alteration"));
        createObjectiveIfAbsent(scoreboard, SKILL_DESTRUCTION, Text.literal("Destruction"));
        createObjectiveIfAbsent(scoreboard, SKILL_MYSTICISM, Text.literal("Mysticism"));
        createObjectiveIfAbsent(scoreboard, SKILL_RESTORATION, Text.literal("Restoration"));
        createObjectiveIfAbsent(scoreboard, SKILL_ALCHEMY, Text.literal("Alchemy"));
        createObjectiveIfAbsent(scoreboard, SKILL_BLACKSMITHING, Text.literal("Blacksmithing"));
        createObjectiveIfAbsent(scoreboard, SKILL_CULINARY, Text.literal("Culinary"));
        createObjectiveIfAbsent(scoreboard, SKILL_MERCANTILE, Text.literal("Mercantile"));
    }

    private static void createObjectiveIfAbsent(Scoreboard scoreboard, String name, Text displayName) {
        if (scoreboard.getNullableObjective(name) == null) {
            scoreboard.addObjective(
                    name,
                    ScoreboardCriterion.DUMMY,
                    displayName,
                    ScoreboardCriterion.RenderType.INTEGER,
                    true,
                    null
            );
        }
    }
}