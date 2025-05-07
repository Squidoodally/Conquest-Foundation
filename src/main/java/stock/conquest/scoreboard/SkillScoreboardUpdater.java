package stock.conquest.scoreboard;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.network.ServerPlayerEntity;
import stock.conquest.component.PlayerSkillsBinder;

public class SkillScoreboardUpdater {

    public static void updateScoreboard(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            Scoreboard scoreboard = serverPlayer.getServerWorld().getScoreboard();
            String name = serverPlayer.getName().getString();

            updateSkill(scoreboard, name, SkillScoreboard.SKILL_BLADE, getPlayerBladeSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_BLUNT, getPlayerBluntSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_THRUST, getPlayerThrustSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_MARKSMAN, getPlayerMarksmanSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_BLOCK, getPlayerBlockSkill(serverPlayer));

            updateSkill(scoreboard, name, SkillScoreboard.SKILL_ATHLETICS, getPlayerAthleticsSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_ACROBATICS, getPlayerAcrobaticsSkill(serverPlayer));

            updateSkill(scoreboard, name, SkillScoreboard.SKILL_ALTERATION, getPlayerAlterationSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_DESTRUCTION, getPlayerDestructionSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_MYSTICISM, getPlayerMysticismSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_RESTORATION, getPlayerRestorationSkill(serverPlayer));

            updateSkill(scoreboard, name, SkillScoreboard.SKILL_ALCHEMY, getPlayerAlchemySkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_BLACKSMITHING, getPlayerBlacksmithingSkill(serverPlayer));
            updateSkill(scoreboard, name, SkillScoreboard.SKILL_CULINARY, getPlayerCulinarySkill(serverPlayer));

            updateSkill(scoreboard, name, SkillScoreboard.SKILL_MERCANTILE, getPlayerMercantileSkill(serverPlayer));
        }
    }

    private static void updateSkill(Scoreboard scoreboard, String playerName, String objectiveName, int value) {
        ScoreboardObjective objective = scoreboard.getNullableObjective(objectiveName);
        if (objective != null) {
            scoreboard.getOrCreateScore(ScoreHolder.fromName(playerName), objective).setScore(value);
        }
    }

    // Methods to retrieve each player's skill level. These methods assume the player's skills are stored in a component.

    public static int getPlayerBladeSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getBlade();
    }

    public static int getPlayerBluntSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getBlunt();
    }

    public static int getPlayerThrustSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getThrust();
    }

    public static int getPlayerMarksmanSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getMarksman();
    }

    public static int getPlayerBlockSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getBlock();
    }

    public static int getPlayerAthleticsSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getAthletics();
    }

    public static int getPlayerAcrobaticsSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getAcrobatics();
    }

    public static int getPlayerAlterationSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getAlteration();
    }

    public static int getPlayerDestructionSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getDestruction();
    }

    public static int getPlayerMysticismSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getMysticism();
    }

    public static int getPlayerRestorationSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getRestoration();
    }

    public static int getPlayerAlchemySkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getAlchemy();
    }

    public static int getPlayerBlacksmithingSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getBlacksmithing();
    }

    public static int getPlayerCulinarySkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getCulinary();
    }

    public static int getPlayerMercantileSkill(ServerPlayerEntity player) {
        return player.getComponent(PlayerSkillsBinder.PLAYER_SKILLS).getMercantile();
    }
}