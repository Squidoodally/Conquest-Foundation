package stock.conquest.component;

import net.minecraft.nbt.NbtCompound;
import org.ladysnake.cca.api.v3.component.Component;

public interface PlayerSkillsComponentExtender extends Component {
    int getSkill(String key);
    void setSkill(String key, int value);
    NbtCompound getAllSkills();

    void readFromNbt(NbtCompound tag);
    void writeToNbt(NbtCompound tag);

    int getBlade();
    int getBlunt();
    int getThrust();
    int getMarksman();
    int getBlock();
    int getAthletics();
    int getAcrobatics();
    int getAlteration();
    int getDestruction();
    int getMysticism();
    int getRestoration();
    int getAlchemy();
    int getBlacksmithing();
    int getCulinary();
    int getMercantile();
}