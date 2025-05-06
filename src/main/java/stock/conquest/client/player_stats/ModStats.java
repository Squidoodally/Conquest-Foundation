package stock.conquest.client.player_stats;

import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import stock.conquest.component.ModComponents;

import java.util.HashMap;
import java.util.Map;

public abstract class ModStats implements AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Integer> stats = new HashMap<>();

    public static final String STRENGTH_KEY = "Strength";
    public static final String FINESSE_KEY = "Finesse";
    public static final String INTELLIGENCE_KEY = "Intelligence";
    public static final String CONSTITUTION_KEY = "Constitution";
    public static final String WILLPOWER_KEY = "Willpower";
    public static final String SPEED_KEY = "Speed";
    public static final String LUCK_KEY = "Luck";

    public ModStats(PlayerEntity player) {
        this.player = player;
        // Initialize all stats to 0
        stats.put(STRENGTH_KEY, 0);
        stats.put(FINESSE_KEY, 0);
        stats.put(INTELLIGENCE_KEY, 0);
        stats.put(CONSTITUTION_KEY, 0);
        stats.put(WILLPOWER_KEY, 0);
        stats.put(SPEED_KEY, 0);
        stats.put(LUCK_KEY, 0);
    }

    public int getStat(String statKey) {
        return stats.getOrDefault(statKey, 0);
    }

    public void setStat(String statKey, int value) {
        stats.put(statKey, value);
        ModComponents.PLAYER_STATS.sync(player);  // You may need custom sync logic here
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        for (String key : stats.keySet()) {
            if (tag.contains(key)) {
                stats.put(key, tag.getInt(key));
            }
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
        }
    }
}