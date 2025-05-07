package stock.conquest.scoreboard;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.network.ServerPlayerEntity;
import stock.conquest.component.PlayerAttributesBinder;

public class AttributeScoreboardUpdater {

    public static void updateScoreboard(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            Scoreboard scoreboard = serverPlayer.getServerWorld().getScoreboard();
            String name = serverPlayer.getName().getString();

            updateAttribute(scoreboard, name, AttributeScoreboard.MAX_HEALTH, getPlayerMaxHealth(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.CURRENT_HEALTH, getPlayerCurrentHealth(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.REGENRATE_HEALTH, getPlayerHealthRegenerationRate(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAX_STAMINA, getPlayerMaxStamina(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.CURRENT_STAMINA, getPlayerCurrentStamina(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.REGENRATE_STAMINA, getPlayerStaminaRegenerationRate(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAX_MANA, getPlayerMaxMana(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.CURRENT_MANA, getPlayerCurrentMana(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.REGENRATE_MANA, getPlayerManaRegenerationRate(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.ARMOR, getPlayerArmorRating(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.POISE, getPlayerPoise(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SLASH_DEFENSE, getPlayerSlashDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.STRIKE_DEFENSE, getPlayerStrikeDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.PIERCE_DEFENSE, getPlayerPierceDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAGICAL_DEFENSE, getPlayerMagicalDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FIRE_DEFENSE, getPlayerFireDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FROST_DEFENSE, getPlayerFrostDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SHOCK_DEFENSE, getPlayerShockDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.POISON_DEFENSE, getPlayerPoisonDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SPELL_ABSORPTION, getPlayerSpellAbsorption(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.PHYSICAL_DAMAGE_MODIFIER, getPlayerPhysicalDamageModifier(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAGICAL_DAMAGE_MODIFIER, getPlayerMagicalDamageModifier(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.STAMINA_COST_MODIFIER, getPlayerStaminaCostModifier(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MANA_COST_MODIFIER, getPlayerManaCostModifier(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FALL_DAMAGE_RECEIVED, getPlayerFallDamageReceived(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.RUN_SPEED, getPlayerRunSpeed(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.CROUCH_SPEED, getPlayerCrouchSpeed(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SWIM_SPEED, getPlayerSwimSpeed(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.JUMP_STRENGTH, getPlayerJumpStrength(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.OXYGEN, getPlayerOxygen(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.POTION_EFFECTIVENESS, getPlayerPotionEffectiveness(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.DISPOSITION, getPlayerDisposition(serverPlayer));
        }
    }

    private static void updateAttribute(Scoreboard scoreboard, String playerName, String objectiveName, int value) {
        ScoreboardObjective objective = scoreboard.getNullableObjective(objectiveName);
        if (objective != null) {
            scoreboard.getOrCreateScore(ScoreHolder.fromName(playerName), objective).setScore(value);
        }
    }

    public static int getPlayerMaxHealth(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxHealth();
    }

    public static int getPlayerCurrentHealth(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentHealth();
    }

    public static int getPlayerHealthRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getHealthRegenerationRate();
    }

    public static int getPlayerMaxStamina(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxStamina();
    }

    public static int getPlayerCurrentStamina(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentStamina();
    }

    public static int getPlayerStaminaRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStaminaRegenerationRate();
    }

    public static int getPlayerMaxMana(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxMana();
    }

    public static int getPlayerCurrentMana(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentMana();
    }

    public static int getPlayerManaRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getManaRegenerationRate();
    }

    public static int getPlayerArmorRating(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getArmorRating();
    }

    public static int getPlayerPoise(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPoise();
    }

    public static int getPlayerSlashDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSlashDefense();
    }

    public static int getPlayerStrikeDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStrikeDefense();
    }

    public static int getPlayerPierceDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPierceDefense();
    }

    public static int getPlayerMagicalDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMagicalDefense();
    }

    public static int getPlayerFireDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFireDefense();
    }

    public static int getPlayerFrostDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFrostDefense();
    }

    public static int getPlayerShockDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getShockDefense();
    }

    public static int getPlayerPoisonDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPoisonDefense();
    }

    public static int getPlayerSpellAbsorption(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSpellAbsorption();
    }

    public static int getPlayerPhysicalDamageModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPhysicalDamageModifier();
    }

    public static int getPlayerMagicalDamageModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMagicalDamageModifier();
    }

    public static int getPlayerStaminaCostModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStaminaCostModifier();
    }

    public static int getPlayerManaCostModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getManaCostModifier();
    }

    public static int getPlayerFallDamageReceived(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFallDamageReceived();
    }

    public static int getPlayerRunSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getRunSpeed();
    }

    public static int getPlayerCrouchSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCrouchSpeed();
    }

    public static int getPlayerSwimSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSwimSpeed();
    }

    public static int getPlayerJumpStrength(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getJumpStrength();
    }

    public static int getPlayerOxygen(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getOxygen();
    }

    public static int getPlayerPotionEffectiveness(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPotionEffectiveness();
    }

    public static int getPlayerDisposition(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getDisposition();
    }
}