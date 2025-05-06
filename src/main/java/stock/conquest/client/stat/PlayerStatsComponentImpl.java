package stock.conquest.client.stat;

import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerStatsComponentImpl implements PlayerStatsComponent, AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Integer> stats = new HashMap<>();

    public PlayerStatsComponentImpl(PlayerEntity player) {
        this.player = player;

        // Default values
        stats.put("Strength", 0);
        stats.put("Finesse", 0);
        stats.put("Intelligence", 0);
        stats.put("Constitution", 0);
        stats.put("Willpower", 0);
        stats.put("Speed", 0);
        stats.put("Luck", 0);
    }

    @Override
    public int getStat(String key) {
        return stats.getOrDefault(key, 0);
    }

    @Override
    public void setStat(String key, int value) {
        stats.put(key, value);
        ModComponents.PLAYER_STATS.sync(player);
    }

    @Override
    public NbtCompound getAllStats() {
        NbtCompound tag = new NbtCompound();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
        }
        return tag;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        for (String key : tag.getKeys()) {
            stats.put(key, tag.getInt(key));
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            tag.putInt(entry.getKey(), entry.getValue());
        }
    }
}