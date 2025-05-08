package stock.conquest.component;

import net.minecraft.nbt.NbtCompound;
import org.ladysnake.cca.api.v3.component.Component;

public interface PlayerSkillsComponentExtender extends Component {
    float getSkill(String key);
    void setSkill(String key, float value);
    NbtCompound getAllSkills();

    void readFromNbt(NbtCompound tag);
    void writeToNbt(NbtCompound tag);

    float getBlade();
    float getBlunt();
    float getThrust();
    float getMarksman();
    float getBlock();
    float getAthletics();
    float getAcrobatics();
    float getAlteration();
    float getDestruction();
    float getMysticism();
    float getRestoration();
    float getAlchemy();
    float getBlacksmithing();
    float getCulinary();
    float getMercantile();
}