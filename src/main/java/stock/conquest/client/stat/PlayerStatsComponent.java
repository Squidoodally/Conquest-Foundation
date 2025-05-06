package stock.conquest.client.stat;

import org.ladysnake.cca.api.v3.component.Component;
import net.minecraft.nbt.NbtCompound;

public interface PlayerStatsComponent extends Component {
    int getStat(String key);
    void setStat(String key, int value);
    NbtCompound getAllStats();

    void readFromNbt(NbtCompound tag);

    void writeToNbt(NbtCompound tag);
}
