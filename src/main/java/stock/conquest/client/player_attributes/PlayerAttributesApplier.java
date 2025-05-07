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
    private final Map<String, Integer> attributes = new HashMap<>();

    public PlayerAttributesApplier(PlayerEntity player) {
        this.player = player;

        attributes.put(PlayerAttributes.MAX_HEALTH_KEY, 20);
        attributes.put(PlayerAttributes.CURRENT_HEALTH_KEY, 20);
        attributes.put(PlayerAttributes.REGENRATE_HEALTH_KEY, 1);
        attributes.put(PlayerAttributes.MAX_STAMINA_KEY, 30);
        attributes.put(PlayerAttributes.CURRENT_STAMINA_KEY, 30);
        attributes.put(PlayerAttributes.REGENRATE_STAMINA_KEY, 1);
        attributes.put(PlayerAttributes.MAX_MANA_KEY, 20);
        attributes.put(PlayerAttributes.CURRENT_MANA_KEY, 20);
        attributes.put(PlayerAttributes.REGENRATE_MANA_KEY, 1);
        attributes.put(PlayerAttributes.ARMOR_KEY, 0);
        attributes.put(PlayerAttributes.POISE_KEY, 0);
        attributes.put(PlayerAttributes.SLASH_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.STRIKE_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.PIERCE_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.MAGICAL_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.FIRE_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.FROST_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.SHOCK_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.POISON_DEFENSE_KEY, 0);
        attributes.put(PlayerAttributes.SPELL_ABSORPTION_KEY, 0);
        attributes.put(PlayerAttributes.PHYSICAL_DAMAGE_MODIFIER_KEY, 1);
        attributes.put(PlayerAttributes.MAGICAL_DAMAGE_MODIFIER_KEY, 1);
        attributes.put(PlayerAttributes.STAMINA_COST_MODIFIER_KEY, 1);
        attributes.put(PlayerAttributes.MANA_COST_MODIFIER_KEY, 1);
        attributes.put(PlayerAttributes.FALL_DAMAGE_RECEIVED_KEY, 1);
        attributes.put(PlayerAttributes.RUN_SPEED_KEY, 1);
        attributes.put(PlayerAttributes.CROUCH_SPEED_KEY, 1);
        attributes.put(PlayerAttributes.SWIM_SPEED_KEY, 1);
        attributes.put(PlayerAttributes.JUMP_HEIGHT_KEY, 1);
        attributes.put(PlayerAttributes.UNDERWATER_BREATH_KEY, 1);
        attributes.put(PlayerAttributes.POTION_EFFECTIVENESS_KEY, 1);
        attributes.put(PlayerAttributes.DISPOSITION_KEY, 1);
    }

    @Override
    public int getAttribute(String key) {
        return attributes.getOrDefault(key, 0);
    }

    @Override
    public void setAttribute(String key, int value) {
        attributes.put(key, value);
        PlayerAttributesBinder.PLAYER_ATTRIBUTES.sync(player);
        if (!player.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            AttributeScoreboardUpdater.updateScoreboard(serverPlayer);
        }
    }

    @Override
    public NbtCompound getAllAttributes() {
        NbtCompound tag = new NbtCompound();
        for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        for (String key : tag.getKeys()) {
            attributes.put(key, tag.getInt(key));
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
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
    public int getMaxHealth() {
        return getAttribute(PlayerAttributes.MAX_HEALTH_KEY);
    }

    @Override
    public int getCurrentHealth() {
        return getAttribute(PlayerAttributes.CURRENT_HEALTH_KEY);
    }

    @Override
    public int getHealthRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_HEALTH_KEY);
    }

    @Override
    public int getMaxStamina() {
        return getAttribute(PlayerAttributes.MAX_STAMINA_KEY);
    }

    @Override
    public int getCurrentStamina() {
        return getAttribute(PlayerAttributes.CURRENT_STAMINA_KEY);
    }

    @Override
    public int getStaminaRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_STAMINA_KEY);
    }

    @Override
    public int getMaxMana() {
        return getAttribute(PlayerAttributes.MAX_MANA_KEY);
    }

    @Override
    public int getCurrentMana() {
        return getAttribute(PlayerAttributes.CURRENT_MANA_KEY);
    }

    @Override
    public int getManaRegenerationRate() {
        return getAttribute(PlayerAttributes.REGENRATE_MANA_KEY);
    }

    @Override
    public int getArmorRating() { return getAttribute(PlayerAttributes.ARMOR_KEY); }

    @Override
    public int getPoise() {
        return getAttribute(PlayerAttributes.POISE_KEY);
    }

    @Override
    public int getSlashDefense() {
        return getAttribute(PlayerAttributes.SLASH_DEFENSE_KEY);
    }

    @Override
    public int getStrikeDefense() {
        return getAttribute(PlayerAttributes.STRIKE_DEFENSE_KEY);
    }

    @Override
    public int getPierceDefense() {
        return getAttribute(PlayerAttributes.PIERCE_DEFENSE_KEY);
    }

    @Override
    public int getMagicalDefense() {
        return getAttribute(PlayerAttributes.MAGICAL_DEFENSE_KEY);
    }

    @Override
    public int getFireDefense() {
        return getAttribute(PlayerAttributes.FIRE_DEFENSE_KEY);
    }

    @Override
    public int getFrostDefense() {
        return getAttribute(PlayerAttributes.FROST_DEFENSE_KEY);
    }

    @Override
    public int getShockDefense() {
        return getAttribute(PlayerAttributes.SHOCK_DEFENSE_KEY);
    }

    @Override
    public int getPoisonDefense() {
        return getAttribute(PlayerAttributes.POISON_DEFENSE_KEY);
    }

    @Override
    public int getSpellAbsorption() {
        return getAttribute(PlayerAttributes.SPELL_ABSORPTION_KEY);
    }

    @Override
    public int getPhysicalDamageModifier() {
        return getAttribute(PlayerAttributes.PHYSICAL_DAMAGE_MODIFIER_KEY);
    }

    @Override
    public int getMagicalDamageModifier() {
        return getAttribute(PlayerAttributes.MAGICAL_DAMAGE_MODIFIER_KEY);
    }

    @Override
    public int getStaminaCostModifier() {
        return getAttribute(PlayerAttributes.STAMINA_COST_MODIFIER_KEY);
    }

    @Override
    public int getManaCostModifier() {
        return getAttribute(PlayerAttributes.MANA_COST_MODIFIER_KEY);
    }

    @Override
    public int getFallDamageReceived() {
        return getAttribute(PlayerAttributes.FALL_DAMAGE_RECEIVED_KEY);
    }

    @Override
    public int getRunSpeed() {
        return getAttribute(PlayerAttributes.RUN_SPEED_KEY);
    }

    @Override
    public int getCrouchSpeed() {
        return getAttribute(PlayerAttributes.CROUCH_SPEED_KEY);
    }

    @Override
    public int getSwimSpeed() {
        return getAttribute(PlayerAttributes.SWIM_SPEED_KEY);
    }

    @Override
    public int getJumpStrength() {
        return getAttribute(PlayerAttributes.JUMP_HEIGHT_KEY);
    }

    @Override
    public int getOxygen() {
        return getAttribute(PlayerAttributes.UNDERWATER_BREATH_KEY);
    }

    @Override
    public int getPotionEffectiveness() {
        return getAttribute(PlayerAttributes.POTION_EFFECTIVENESS_KEY);
    }

    @Override
    public int getDisposition() {
        return getAttribute(PlayerAttributes.DISPOSITION_KEY);
    }
}