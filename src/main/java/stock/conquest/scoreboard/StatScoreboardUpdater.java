package stock.conquest.scoreboard;

import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import stock.conquest.component.PlayerStatsBinder;

public class StatScoreboardUpdater {

    public static void updateScoreboard(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            Scoreboard scoreboard = serverPlayer.getServerWorld().getScoreboard();
            String name = serverPlayer.getName().getString();

            updateStat(scoreboard, name, StatScoreboard.STRENGTH, getPlayerStrength(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.FINESSE, getPlayerFinesse(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.INTELLIGENCE, getPlayerIntelligence(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.CONSTITUTION, getPlayerConstitution(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.WILLPOWER, getPlayerWillpower(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.SPEED, getPlayerSpeed(serverPlayer));
            updateStat(scoreboard, name, StatScoreboard.LUCK, getPlayerLuck(serverPlayer));
        }
    }

    private static void updateStat(Scoreboard scoreboard, String playerName, String objectiveName, int value) {
        ScoreboardObjective objective = scoreboard.getNullableObjective(objectiveName);
        if (objective != null) {
            scoreboard.getOrCreateScore(ScoreHolder.fromName(playerName), objective).setScore(value);
        }
    }

    public static int getPlayerStrength(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getStrength();
    }

    public static int getPlayerFinesse(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getFinesse();
    }

    public static int getPlayerIntelligence(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getIntelligence();
    }

    public static int getPlayerConstitution(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getConstitution();
    }

    public static int getPlayerWillpower(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getWillpower();
    }

    public static int getPlayerSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getSpeed();
    }

    public static int getPlayerLuck(ServerPlayerEntity player) {
        return player.getComponent(PlayerStatsBinder.PLAYER_STATS).getLuck();
    }
}