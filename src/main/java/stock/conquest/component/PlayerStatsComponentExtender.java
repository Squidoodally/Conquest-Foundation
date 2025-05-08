package stock.conquest.component;

import org.ladysnake.cca.api.v3.component.Component;
import net.minecraft.nbt.NbtCompound;

public interface PlayerStatsComponentExtender extends Component {
    int getStat(String key);
    void setStat(String key, int value);
    NbtCompound getAllStats();

    void readFromNbt(NbtCompound tag);

    void writeToNbt(NbtCompound tag);

    int getStrength();
    int getFinesse();
    int getIntelligence();
    int getConstitution();
    int getWillpower();
    int getSpeed();
    int getLuck();
}