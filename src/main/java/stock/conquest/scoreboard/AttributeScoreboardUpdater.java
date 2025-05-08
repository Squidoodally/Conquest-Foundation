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
            updateAttribute(scoreboard, name, AttributeScoreboard.RANGED_DEFENSE, getPlayerRangedDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAGICAL_DEFENSE, getPlayerMagicalDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FIRE_DEFENSE, getPlayerFireDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FROST_DEFENSE, getPlayerFrostDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SHOCK_DEFENSE, getPlayerShockDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.POISON_DEFENSE, getPlayerPoisonDefense(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SLASH_DAMAGE, getPlayerSlashDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.STRIKE_DAMAGE, getPlayerStrikeDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.PIERCE_DAMAGE, getPlayerPierceDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.RANGED_DAMAGE, getPlayerRangedDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.MAGICAL_DAMAGE, getPlayerMagicalDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FIRE_DAMAGE, getPlayerFireDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.FROST_DAMAGE, getPlayerFrostDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SHOCK_DAMAGE, getPlayerShockDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.POISON_DAMAGE, getPlayerPoisonDamage(serverPlayer));
            updateAttribute(scoreboard, name, AttributeScoreboard.SPELL_ABSORPTION, getPlayerSpellAbsorption(serverPlayer));
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

    private static void updateAttribute(Scoreboard scoreboard, String playerName, String objectiveName, float value) {
        ScoreboardObjective objective = scoreboard.getNullableObjective(objectiveName);
        if (objective != null) {
            scoreboard.getOrCreateScore(ScoreHolder.fromName(playerName), objective).setScore((int) value); // Convert to int for scoreboard
        }
    }

    public static float getPlayerMaxHealth(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxHealth();
    }

    public static float getPlayerCurrentHealth(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentHealth();
    }

    public static float getPlayerHealthRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getHealthRegenerationRate();
    }

    public static float getPlayerMaxStamina(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxStamina();
    }

    public static float getPlayerCurrentStamina(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentStamina();
    }

    public static float getPlayerStaminaRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStaminaRegenerationRate();
    }

    public static float getPlayerMaxMana(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMaxMana();
    }

    public static float getPlayerCurrentMana(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCurrentMana();
    }

    public static float getPlayerManaRegenerationRate(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getManaRegenerationRate();
    }

    public static float getPlayerArmorRating(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getArmorRating();
    }

    public static float getPlayerPoise(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPoise();
    }

    public static float getPlayerSlashDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSlashDefense();
    }

    public static float getPlayerStrikeDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStrikeDefense();
    }

    public static float getPlayerPierceDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPierceDefense();
    }

    public static float getPlayerRangedDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getRangedDefense();
    }

    public static float getPlayerMagicalDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMagicalDefense();
    }

    public static float getPlayerFireDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFireDefense();
    }

    public static float getPlayerFrostDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFrostDefense();
    }

    public static float getPlayerShockDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getShockDefense();
    }

    public static float getPlayerPoisonDefense(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPoisonDefense();
    }

    public static float getPlayerSlashDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSlashDamage();
    }

    public static float getPlayerStrikeDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStrikeDamage();
    }

    public static float getPlayerPierceDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPierceDamage();
    }

    public static float getPlayerRangedDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getRangedDamage();
    }

    public static float getPlayerMagicalDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getMagicalDamage();
    }

    public static float getPlayerFireDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFireDamage();
    }

    public static float getPlayerFrostDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFrostDamage();
    }

    public static float getPlayerShockDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getShockDamage();
    }

    public static float getPlayerPoisonDamage(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPoisonDamage();
    }

    public static float getPlayerSpellAbsorption(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSpellAbsorption();
    }

    public static float getPlayerStaminaCostModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getStaminaCostModifier();
    }

    public static float getPlayerManaCostModifier(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getManaCostModifier();
    }

    public static float getPlayerFallDamageReceived(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getFallDamageReceived();
    }

    public static float getPlayerRunSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getRunSpeed();
    }

    public static float getPlayerCrouchSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getCrouchSpeed();
    }

    public static float getPlayerSwimSpeed(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getSwimSpeed();
    }

    public static float getPlayerJumpStrength(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getJumpStrength();
    }

    public static float getPlayerOxygen(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getOxygen();
    }

    public static float getPlayerPotionEffectiveness(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getPotionEffectiveness();
    }

    public static float getPlayerDisposition(ServerPlayerEntity player) {
        return player.getComponent(PlayerAttributesBinder.PLAYER_ATTRIBUTES).getDisposition();
    }
}