package stock.conquest.client.player_attributes;

import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import stock.conquest.component.PlayerAttributesBinder;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerAttributes implements AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Float> attributes = new HashMap<>();

    public static final String MAX_HEALTH_KEY = "Max Health";
    public static final String CURRENT_HEALTH_KEY = "Current Health";
    public static final String REGENRATE_HEALTH_KEY = "Health Regeneration Rate";
    public static final String MAX_STAMINA_KEY = "Max Stamina";
    public static final String CURRENT_STAMINA_KEY = "Current Stamina";
    public static final String REGENRATE_STAMINA_KEY = "Stamina Regeneration Rate";
    public static final String MAX_MANA_KEY = "Max Mana";
    public static final String CURRENT_MANA_KEY = "Current Mana";
    public static final String REGENRATE_MANA_KEY = "Mana Regeneration Rate";
    public static final String ARMOR_KEY = "Armor Rating";
    public static final String POISE_KEY = "Poise";
    public static final String SLASH_DEFENSE_KEY = "Slash Defense";
    public static final String STRIKE_DEFENSE_KEY = "Strike Defense";
    public static final String PIERCE_DEFENSE_KEY = "Pierce Defense";
    public static final String MAGICAL_DEFENSE_KEY = "Magical Defense";
    public static final String FIRE_DEFENSE_KEY = "Fire Defense";
    public static final String FROST_DEFENSE_KEY = "Frost Defense";
    public static final String SHOCK_DEFENSE_KEY = "Shock Defense";
    public static final String POISON_DEFENSE_KEY = "Poison Defense";
    public static final String SPELL_ABSORPTION_KEY = "Spell Absorption";
    public static final String PHYSICAL_DAMAGE_MODIFIER_KEY = "Physical Damage Modifier";
    public static final String MAGICAL_DAMAGE_MODIFIER_KEY = "Magical Damage Modifier";
    public static final String STAMINA_COST_MODIFIER_KEY = "Stamina Cost Modifier";
    public static final String MANA_COST_MODIFIER_KEY = "Mana Cost Modifier";
    public static final String FALL_DAMAGE_RECEIVED_KEY = "Fall Damage Received";
    public static final String RUN_SPEED_KEY = "Run Speed";
    public static final String CROUCH_SPEED_KEY = "Crouch Speed";
    public static final String SWIM_SPEED_KEY = "Swim Speed";
    public static final String JUMP_HEIGHT_KEY = "Jump Strength";
    public static final String UNDERWATER_BREATH_KEY = "Oxygen";
    public static final String POTION_EFFECTIVENESS_KEY = "Potion Effectiveness";
    public static final String DISPOSITION_KEY = "Disposition";

    public PlayerAttributes(PlayerEntity player) {
        this.player = player;
        attributes.put(MAX_HEALTH_KEY, 20.0f);
        attributes.put(CURRENT_HEALTH_KEY, 20.0f);
        attributes.put(REGENRATE_HEALTH_KEY, 1.0f);
        attributes.put(MAX_STAMINA_KEY, 30.0f);
        attributes.put(CURRENT_STAMINA_KEY, 30.0f);
        attributes.put(REGENRATE_STAMINA_KEY, 1.0f);
        attributes.put(MAX_MANA_KEY, 20.0f);
        attributes.put(CURRENT_MANA_KEY, 20.0f);
        attributes.put(REGENRATE_MANA_KEY, 1.0f);
        attributes.put(ARMOR_KEY, 0.0f);
        attributes.put(POISE_KEY, 0.0f);
        attributes.put(SLASH_DEFENSE_KEY, 0.0f);
        attributes.put(STRIKE_DEFENSE_KEY, 0.0f);
        attributes.put(PIERCE_DEFENSE_KEY, 0.0f);
        attributes.put(MAGICAL_DEFENSE_KEY, 0.0f);
        attributes.put(FIRE_DEFENSE_KEY, 0.0f);
        attributes.put(FROST_DEFENSE_KEY, 0.0f);
        attributes.put(SHOCK_DEFENSE_KEY, 0.0f);
        attributes.put(POISON_DEFENSE_KEY, 0.0f);
        attributes.put(SPELL_ABSORPTION_KEY, 0.0f);
        attributes.put(PHYSICAL_DAMAGE_MODIFIER_KEY, 1.0f);
        attributes.put(MAGICAL_DAMAGE_MODIFIER_KEY, 1.0f);
        attributes.put(STAMINA_COST_MODIFIER_KEY, 1.0f);
        attributes.put(MANA_COST_MODIFIER_KEY, 1.0f);
        attributes.put(FALL_DAMAGE_RECEIVED_KEY, 1.0f);
        attributes.put(RUN_SPEED_KEY, 1.0f);
        attributes.put(CROUCH_SPEED_KEY, 1.0f);
        attributes.put(SWIM_SPEED_KEY, 1.0f);
        attributes.put(JUMP_HEIGHT_KEY, 1.0f);
        attributes.put(UNDERWATER_BREATH_KEY, 1.0f);
        attributes.put(POTION_EFFECTIVENESS_KEY, 1.0f);
        attributes.put(DISPOSITION_KEY, 1.0f);
    }

    public float getAttribute(String attributeKey) {
        return attributes.getOrDefault(attributeKey, 0.0f);
    }

    public void setAttribute(String attributeKey, float value) {
        attributes.put(attributeKey, value);
        PlayerAttributesBinder.PLAYER_ATTRIBUTES.sync(player);
    }
}