package stock.conquest.client.player_skills;

import net.minecraft.entity.player.PlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import stock.conquest.component.PlayerSkillsBinder;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerSkills implements AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Integer> skills = new HashMap<>();

    public static final String SKILL_BLADE_KEY = "Blade";
    public static final String SKILL_BLUNT_KEY = "Blunt";
    public static final String SKILL_THRUST_KEY = "Thrust";
    public static final String SKILL_MARKSMAN_KEY = "Marksman";
    public static final String SKILL_BLOCK_KEY = "Block";
    public static final String SKILL_ATHLETICS_KEY = "Athletics";
    public static final String SKILL_ACROBATICS_KEY = "Acrobatics";
    public static final String SKILL_ALTERATION_KEY = "Alteration";
    public static final String SKILL_DESTRUCTION_KEY = "Destruction";
    public static final String SKILL_MYSTICISM_KEY = "Mysticism";
    public static final String SKILL_RESTORATION_KEY = "Restoration";
    public static final String SKILL_ALCHEMY_KEY = "Alchemy";
    public static final String SKILL_BLACKSMITHING_KEY = "Blacksmithing";
    public static final String SKILL_CULINARY_KEY = "Culinary";
    public static final String SKILL_MERCANTILE_KEY = "Mercantile";

    public PlayerSkills(PlayerEntity player) {
        this.player = player;
        skills.put(SKILL_BLADE_KEY, 0);
        skills.put(SKILL_BLUNT_KEY, 0);
        skills.put(SKILL_THRUST_KEY, 0);
        skills.put(SKILL_MARKSMAN_KEY, 0);
        skills.put(SKILL_BLOCK_KEY, 0);
        skills.put(SKILL_ATHLETICS_KEY, 0);
        skills.put(SKILL_ACROBATICS_KEY, 0);
        skills.put(SKILL_ALTERATION_KEY, 0);
        skills.put(SKILL_DESTRUCTION_KEY, 0);
        skills.put(SKILL_MYSTICISM_KEY, 0);
        skills.put(SKILL_RESTORATION_KEY, 0);
        skills.put(SKILL_ALCHEMY_KEY, 0);
        skills.put(SKILL_BLACKSMITHING_KEY, 0);
        skills.put(SKILL_CULINARY_KEY, 0);
        skills.put(SKILL_MERCANTILE_KEY, 0);
    }

    public float getSkill(String skillKey) {
        return skills.getOrDefault(skillKey, 0);
    }

    public void setSkill(String skillKey, int value) {
        skills.put(skillKey, value);
        PlayerSkillsBinder.PLAYER_SKILLS.sync(player);
    }
}