package stock.conquest.scoreboard;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

public class AttributeScoreboard {
    public static final String MAX_HEALTH = "max_health";
    public static final String CURRENT_HEALTH = "current_health";
    public static final String REGENRATE_HEALTH = "health_regeneration_rate";
    public static final String MAX_STAMINA = "max_stamina";
    public static final String CURRENT_STAMINA = "current_stamina";
    public static final String REGENRATE_STAMINA = "stamina_regeneration_rate";
    public static final String MAX_MANA = "max_mana";
    public static final String CURRENT_MANA = "current_mana";
    public static final String REGENRATE_MANA = "mana_regeneration_rate";
    public static final String ARMOR = "armor_rating";
    public static final String POISE = "poise";
    public static final String SLASH_DEFENSE = "slash_defense";
    public static final String STRIKE_DEFENSE = "strike_defense";
    public static final String PIERCE_DEFENSE = "pierce_defense";
    public static final String MAGICAL_DEFENSE = "magical_defense";
    public static final String FIRE_DEFENSE = "fire_defense";
    public static final String FROST_DEFENSE = "frost_defense";
    public static final String SHOCK_DEFENSE = "shock_defense";
    public static final String POISON_DEFENSE = "poison_defense";
    public static final String SPELL_ABSORPTION = "spell_absorption";
    public static final String PHYSICAL_DAMAGE_MODIFIER = "physical_damage_modifier";
    public static final String MAGICAL_DAMAGE_MODIFIER = "magical_damage_modifier";
    public static final String STAMINA_COST_MODIFIER = "stamina_cost_modifier";
    public static final String MANA_COST_MODIFIER = "mana_cost_modifier";
    public static final String FALL_DAMAGE_RECEIVED = "fall_damage_received";
    public static final String RUN_SPEED = "run_speed";
    public static final String CROUCH_SPEED = "crouch_speed";
    public static final String SWIM_SPEED = "swim_speed";
    public static final String JUMP_STRENGTH = "jump_strength";
    public static final String OXYGEN = "oxygen";
    public static final String POTION_EFFECTIVENESS = "potion_effectiveness";
    public static final String DISPOSITION = "disposition";

    public static void registerObjectivesForPlayer(ServerPlayerEntity player) {
        Scoreboard scoreboard = Objects.requireNonNull(player.getServer()).getScoreboard();

        createObjectiveIfAbsent(scoreboard, MAX_HEALTH, Text.literal("Max Health"));
        createObjectiveIfAbsent(scoreboard, CURRENT_HEALTH, Text.literal("Current Health"));
        createObjectiveIfAbsent(scoreboard, REGENRATE_HEALTH, Text.literal("Health Regeneration Rate"));
        createObjectiveIfAbsent(scoreboard, MAX_STAMINA, Text.literal("Max Stamina"));
        createObjectiveIfAbsent(scoreboard, CURRENT_STAMINA, Text.literal("Current Stamina"));
        createObjectiveIfAbsent(scoreboard, REGENRATE_STAMINA, Text.literal("Stamina Regeneration Rate"));
        createObjectiveIfAbsent(scoreboard, MAX_MANA, Text.literal("Max Mana"));
        createObjectiveIfAbsent(scoreboard, CURRENT_MANA, Text.literal("Current Mana"));
        createObjectiveIfAbsent(scoreboard, REGENRATE_MANA, Text.literal("Mana Regeneration Rate"));
        createObjectiveIfAbsent(scoreboard, ARMOR, Text.literal("Armor Rating"));
        createObjectiveIfAbsent(scoreboard, POISE, Text.literal("Poise"));
        createObjectiveIfAbsent(scoreboard, SLASH_DEFENSE, Text.literal("Slash Defense"));
        createObjectiveIfAbsent(scoreboard, STRIKE_DEFENSE, Text.literal("Strike Defense"));
        createObjectiveIfAbsent(scoreboard, PIERCE_DEFENSE, Text.literal("Pierce Defense"));
        createObjectiveIfAbsent(scoreboard, MAGICAL_DEFENSE, Text.literal("Magical Defense"));
        createObjectiveIfAbsent(scoreboard, FIRE_DEFENSE, Text.literal("Fire Defense"));
        createObjectiveIfAbsent(scoreboard, FROST_DEFENSE, Text.literal("Frost Defense"));
        createObjectiveIfAbsent(scoreboard, SHOCK_DEFENSE, Text.literal("Shock Defense"));
        createObjectiveIfAbsent(scoreboard, POISON_DEFENSE, Text.literal("Poison Defense"));
        createObjectiveIfAbsent(scoreboard, SPELL_ABSORPTION, Text.literal("Spell Absorption"));
        createObjectiveIfAbsent(scoreboard, PHYSICAL_DAMAGE_MODIFIER, Text.literal("Physical Dmg Mod"));
        createObjectiveIfAbsent(scoreboard, MAGICAL_DAMAGE_MODIFIER, Text.literal("Magical Dmg Mod"));
        createObjectiveIfAbsent(scoreboard, STAMINA_COST_MODIFIER, Text.literal("Stamina Cost Mod"));
        createObjectiveIfAbsent(scoreboard, MANA_COST_MODIFIER, Text.literal("Mana Cost Mod"));
        createObjectiveIfAbsent(scoreboard, FALL_DAMAGE_RECEIVED, Text.literal("Fall Dmg Received"));
        createObjectiveIfAbsent(scoreboard, RUN_SPEED, Text.literal("Run Speed"));
        createObjectiveIfAbsent(scoreboard, CROUCH_SPEED, Text.literal("Crouch Speed"));
        createObjectiveIfAbsent(scoreboard, SWIM_SPEED, Text.literal("Swim Speed"));
        createObjectiveIfAbsent(scoreboard, JUMP_STRENGTH, Text.literal("Jump Strength"));
        createObjectiveIfAbsent(scoreboard, OXYGEN, Text.literal("Oxygen"));
        createObjectiveIfAbsent(scoreboard, POTION_EFFECTIVENESS, Text.literal("Potion Effectiveness"));
        createObjectiveIfAbsent(scoreboard, DISPOSITION, Text.literal("Disposition"));
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