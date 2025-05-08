package stock.conquest.client.player_attributes;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import stock.conquest.component.PlayerAttributesBinder;
import stock.conquest.component.PlayerAttributesComponentExtender;
import stock.conquest.scoreboard.AttributeScoreboardUpdater;

import java.util.HashMap;
import java.util.Map;

public class PlayerAttributesApplier implements PlayerAttributesComponentExtender, AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Float> attributes = new HashMap<>();

    public PlayerAttributesApplier(PlayerEntity player) {
        this.player = player;

        attributes.put(PlayerAttributes.MAX_HEALTH_KEY, 20.0f);
        attributes.put(PlayerAttributes.CURRENT_HEALTH_KEY, 20.0f);
        attributes.put(PlayerAttributes.REGENRATE_HEALTH_KEY, 1.0f);
        attributes.put(PlayerAttributes.MAX_STAMINA_KEY, 20.0f);
        attributes.put(PlayerAttributes.CURRENT_STAMINA_KEY, 20.0f);
        attributes.put(PlayerAttributes.REGENRATE_STAMINA_KEY, 1.0f);
        attributes.put(PlayerAttributes.MAX_MANA_KEY, 20.0f);
        attributes.put(PlayerAttributes.CURRENT_MANA_KEY, 20.0f);
        attributes.put(PlayerAttributes.REGENRATE_MANA_KEY, 1.0f);
        attributes.put(PlayerAttributes.ARMOR_KEY, 0.0f);
        attributes.put(PlayerAttributes.POISE_KEY, 0.0f);
        attributes.put(PlayerAttributes.SLASH_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.STRIKE_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.PIERCE_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.RANGED_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.MAGICAL_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.FIRE_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.FROST_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.SHOCK_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.POISON_DEFENSE_KEY, 0.0f);
        attributes.put(PlayerAttributes.SLASH_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.STRIKE_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.PIERCE_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.RANGED_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.MAGICAL_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.FIRE_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.FROST_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.SHOCK_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.POISON_DAMAGE_KEY, 1.0f);
        attributes.put(PlayerAttributes.SPELL_ABSORPTION_KEY, 0.0f);
        attributes.put(PlayerAttributes.STAMINA_COST_MODIFIER_KEY, 1.0f);
        attributes.put(PlayerAttributes.MANA_COST_MODIFIER_KEY, 1.0f);
        attributes.put(PlayerAttributes.FALL_DAMAGE_RECEIVED_KEY, 1.0f);
        attributes.put(PlayerAttributes.RUN_SPEED_KEY, 1.0f);
        attributes.put(PlayerAttributes.CROUCH_SPEED_KEY, 1.0f);
        attributes.put(PlayerAttributes.SWIM_SPEED_KEY, 1.0f);
        attributes.put(PlayerAttributes.JUMP_HEIGHT_KEY, 1.0f);
        attributes.put(PlayerAttributes.UNDERWATER_BREATH_KEY, 1.0f);
        attributes.put(PlayerAttributes.POTION_EFFECTIVENESS_KEY, 1.0f);
        attributes.put(PlayerAttributes.DISPOSITION_KEY, 1.0f);
    }

    @Override
    public float getAttribute(String key) {
        return attributes.getOrDefault(key, 0.0f);
    }

    @Override
    public void setAttribute(String key, float value) {
        attributes.put(key, value);
        PlayerAttributesBinder.PLAYER_ATTRIBUTES.sync(player);
        if (!player.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            AttributeScoreboardUpdater.updateScoreboard(serverPlayer);
        }
    }

    @Override
    public NbtCompound getAllAttributes() {
        NbtCompound tag = new NbtCompound();
        for (Map.Entry<String, Float> entry : attributes.entrySet()) {
            tag.putFloat(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        for (String key : tag.getKeys()) {
            attributes.put(key, tag.getFloat(key));
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        for (Map.Entry<String, Float> entry : attributes.entrySet()) {
            tag.putFloat(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        readFromNbt(nbtCompound);
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        writeToNbt(nbtCompound);
    }

    @Override
    public float getMaxHealth() {
        return getAttribute(PlayerAttributes.MAX_HEALTH_KEY);
    }

    @Override
    public float getCurrentHealth() {
        return getAttribute(PlayerAttributes.CURRENT_HEALTH_KEY);
    }

    @Override
    public float getHealthRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_HEALTH_KEY);
    }

    @Override
    public float getMaxStamina() {
        return getAttribute(PlayerAttributes.MAX_STAMINA_KEY);
    }

    @Override
    public float getCurrentStamina() {
        return getAttribute(PlayerAttributes.CURRENT_STAMINA_KEY);
    }

    @Override
    public float getStaminaRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_STAMINA_KEY);
    }

    @Override
    public float getMaxMana() {
        return getAttribute(PlayerAttributes.MAX_MANA_KEY);
    }

    @Override
    public float getCurrentMana() {
        return getAttribute(PlayerAttributes.CURRENT_MANA_KEY);
    }

    @Override
    public float getManaRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_MANA_KEY);
    }

    @Override
    public float getArmorRating() {
        return getAttribute(PlayerAttributes.ARMOR_KEY);
    }

    @Override
    public float getPoise() {
        return getAttribute(PlayerAttributes.POISE_KEY);
    }

    @Override
    public float getSlashDefense() {
        return getAttribute(PlayerAttributes.SLASH_DEFENSE_KEY);
    }

    @Override
    public float getStrikeDefense() {
        return getAttribute(PlayerAttributes.STRIKE_DEFENSE_KEY);
    }

    @Override
    public float getPierceDefense() {
        return getAttribute(PlayerAttributes.PIERCE_DEFENSE_KEY);
    }

    @Override
    public float getRangedDefense() {
        return getAttribute(PlayerAttributes.RANGED_DEFENSE_KEY);
    }

    @Override
    public float getMagicalDefense() {
        return getAttribute(PlayerAttributes.MAGICAL_DEFENSE_KEY);
    }

    @Override
    public float getFireDefense() {
        return getAttribute(PlayerAttributes.FIRE_DEFENSE_KEY);
    }

    @Override
    public float getFrostDefense() {
        return getAttribute(PlayerAttributes.FROST_DEFENSE_KEY);
    }

    @Override
    public float getShockDefense() {
        return getAttribute(PlayerAttributes.SHOCK_DEFENSE_KEY);
    }

    @Override
    public float getPoisonDefense() {
        return getAttribute(PlayerAttributes.POISON_DEFENSE_KEY);
    }

    @Override
    public float getSlashDamage() {
        return getAttribute(PlayerAttributes.SLASH_DAMAGE_KEY);
    }

    @Override
    public float getStrikeDamage() {
        return getAttribute(PlayerAttributes.STRIKE_DAMAGE_KEY);
    }

    @Override
    public float getPierceDamage() {
        return getAttribute(PlayerAttributes.PIERCE_DAMAGE_KEY);
    }

    @Override
    public float getRangedDamage() {
        return getAttribute(PlayerAttributes.RANGED_DAMAGE_KEY);
    }

    @Override
    public float getMagicalDamage() {
        return getAttribute(PlayerAttributes.MAGICAL_DAMAGE_KEY);
    }

    @Override
    public float getFireDamage() {
        return getAttribute(PlayerAttributes.FIRE_DAMAGE_KEY);
    }

    @Override
    public float getFrostDamage() {
        return getAttribute(PlayerAttributes.FROST_DAMAGE_KEY);
    }

    @Override
    public float getShockDamage() {
        return getAttribute(PlayerAttributes.SHOCK_DAMAGE_KEY);
    }

    @Override
    public float getPoisonDamage() {
        return getAttribute(PlayerAttributes.POISON_DAMAGE_KEY);
    }

    @Override
    public float getSpellAbsorption() {
        return getAttribute(PlayerAttributes.SPELL_ABSORPTION_KEY);
    }

    @Override
    public float getStaminaCostModifier() {
        return getAttribute(PlayerAttributes.STAMINA_COST_MODIFIER_KEY);
    }

    @Override
    public float getManaCostModifier() {
        return getAttribute(PlayerAttributes.MANA_COST_MODIFIER_KEY);
    }

    @Override
    public float getFallDamageReceived() {
        return getAttribute(PlayerAttributes.FALL_DAMAGE_RECEIVED_KEY);
    }

    @Override
    public float getRunSpeed() {
        return getAttribute(PlayerAttributes.RUN_SPEED_KEY);
    }

    @Override
    public float getCrouchSpeed() {
        return getAttribute(PlayerAttributes.CROUCH_SPEED_KEY);
    }

    @Override
    public float getSwimSpeed() {
        return getAttribute(PlayerAttributes.SWIM_SPEED_KEY);
    }

    @Override
    public float getJumpStrength() {
        return getAttribute(PlayerAttributes.JUMP_HEIGHT_KEY);
    }

    @Override
    public float getOxygen() {
        return getAttribute(PlayerAttributes.UNDERWATER_BREATH_KEY);
    }

    @Override
    public float getPotionEffectiveness() {
        return getAttribute(PlayerAttributes.POTION_EFFECTIVENESS_KEY);
    }

    @Override
    public float getDisposition() {
        return getAttribute(PlayerAttributes.DISPOSITION_KEY);
    }
}