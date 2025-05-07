package stock.conquest.scoreboard;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.text.Text;

import java.util.Objects;

public class StatScoreboard {
    public static final String STRENGTH = "strength";
    public static final String FINESSE = "finesse";
    public static final String INTELLIGENCE = "intelligence";
    public static final String CONSTITUTION = "constitution";
    public static final String WILLPOWER = "willpower";
    public static final String SPEED = "speed";
    public static final String LUCK = "luck";

    public static void registerObjectivesForPlayer(ServerPlayerEntity player) {
        Scoreboard scoreboard = Objects.requireNonNull(player.getServer()).getScoreboard();

        createObjectiveIfAbsent(scoreboard, STRENGTH, Text.literal("Strength"));
        createObjectiveIfAbsent(scoreboard, FINESSE, Text.literal("Finesse"));
        createObjectiveIfAbsent(scoreboard, INTELLIGENCE, Text.literal("Intelligence"));
        createObjectiveIfAbsent(scoreboard, CONSTITUTION, Text.literal("Constitution"));
        createObjectiveIfAbsent(scoreboard, WILLPOWER, Text.literal("Willpower"));
        createObjectiveIfAbsent(scoreboard, SPEED, Text.literal("Speed"));
        createObjectiveIfAbsent(scoreboard, LUCK, Text.literal("Luck"));
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