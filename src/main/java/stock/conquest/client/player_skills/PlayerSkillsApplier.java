package stock.conquest.client.player_skills;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import stock.conquest.component.PlayerSkillsBinder;
import stock.conquest.component.PlayerSkillsComponentExtender;
import stock.conquest.scoreboard.SkillScoreboardUpdater;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkillsApplier implements PlayerSkillsComponentExtender, AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Float> skills = new HashMap<>();

    public PlayerSkillsApplier(PlayerEntity player) {
        this.player = player;

        skills.put(PlayerSkills.SKILL_BLADE_KEY, 0f);
        skills.put(PlayerSkills.SKILL_BLUNT_KEY, 0f);
        skills.put(PlayerSkills.SKILL_THRUST_KEY, 0f);
        skills.put(PlayerSkills.SKILL_MARKSMAN_KEY, 0f);
        skills.put(PlayerSkills.SKILL_BLOCK_KEY, 0f);
        skills.put(PlayerSkills.SKILL_ATHLETICS_KEY, 0f);
        skills.put(PlayerSkills.SKILL_ACROBATICS_KEY, 0f);
        skills.put(PlayerSkills.SKILL_ALTERATION_KEY, 0f);
        skills.put(PlayerSkills.SKILL_DESTRUCTION_KEY, 0f);
        skills.put(PlayerSkills.SKILL_MYSTICISM_KEY, 0f);
        skills.put(PlayerSkills.SKILL_RESTORATION_KEY, 0f);
        skills.put(PlayerSkills.SKILL_ALCHEMY_KEY, 0f);
        skills.put(PlayerSkills.SKILL_BLACKSMITHING_KEY, 0f);
        skills.put(PlayerSkills.SKILL_CULINARY_KEY, 0f);
        skills.put(PlayerSkills.SKILL_MERCANTILE_KEY, 0f);
    }

    @Override
    public float getSkill(String key) {
        return skills.getOrDefault(key, 0f);
    }

    @Override
    public void setSkill(String key, float value) {
        skills.put(key, value);
        PlayerSkillsBinder.PLAYER_SKILLS.sync(player);
        if (!player.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            SkillScoreboardUpdater.updateScoreboard(serverPlayer);
        }
    }

    @Override
    public NbtCompound getAllSkills() {
        NbtCompound tag = new NbtCompound();
        for (Map.Entry<String, Float> entry : skills.entrySet()) {
            tag.putFloat(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        for (String key : tag.getKeys()) {
            skills.put(key, tag.getFloat(key));
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        for (Map.Entry<String, Float> entry : skills.entrySet()) {
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

    // Getters for individual skills
    @Override
    public float getBlade() { return getSkill(PlayerSkills.SKILL_BLADE_KEY); }

    @Override
    public float getBlunt() { return getSkill(PlayerSkills.SKILL_BLUNT_KEY); }

    @Override
    public float getThrust() { return getSkill(PlayerSkills.SKILL_THRUST_KEY); }

    @Override
    public float getMarksman() { return getSkill(PlayerSkills.SKILL_MARKSMAN_KEY); }

    @Override
    public float getBlock() { return getSkill(PlayerSkills.SKILL_BLOCK_KEY); }

    @Override
    public float getAthletics() { return getSkill(PlayerSkills.SKILL_ATHLETICS_KEY); }

    @Override
    public float getAcrobatics() { return getSkill(PlayerSkills.SKILL_ACROBATICS_KEY); }

    @Override
    public float getAlteration() { return getSkill(PlayerSkills.SKILL_ALTERATION_KEY); }

    @Override
    public float getDestruction() { return getSkill(PlayerSkills.SKILL_DESTRUCTION_KEY); }

    @Override
    public float getMysticism() { return getSkill(PlayerSkills.SKILL_MYSTICISM_KEY); }

    @Override
    public float getRestoration() { return getSkill(PlayerSkills.SKILL_RESTORATION_KEY); }

    @Override
    public float getAlchemy() { return getSkill(PlayerSkills.SKILL_ALCHEMY_KEY); }

    @Override
    public float getBlacksmithing() { return getSkill(PlayerSkills.SKILL_BLACKSMITHING_KEY); }

    @Override
    public float getCulinary() { return getSkill(PlayerSkills.SKILL_CULINARY_KEY); }

    @Override
    public float getMercantile() { return getSkill(PlayerSkills.SKILL_MERCANTILE_KEY); }
}