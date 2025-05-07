package stock.conquest.client.player_stats;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import stock.conquest.component.PlayerStatsBinder;
import stock.conquest.component.PlayerStatsComponentExtender;
import stock.conquest.scoreboard.StatScoreboardUpdater;

import java.util.HashMap;
import java.util.Map;

public class PlayerStatsApplier implements PlayerStatsComponentExtender, AutoSyncedComponent {
    private final PlayerEntity player;
    private final Map<String, Integer> stats = new HashMap<>();

    public PlayerStatsApplier(PlayerEntity player) {
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
        PlayerStatsBinder.PLAYER_STATS.sync(player);
        if (!player.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            StatScoreboardUpdater.updateScoreboard(serverPlayer);
        }
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

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {

    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {

    }
    @Override
    public int getStrength() {
        return getStat("Strength");
    }

    @Override
    public int getFinesse() {
        return getStat("Finesse");
    }

    @Override
    public int getIntelligence() {
        return getStat("Intelligence");
    }

    @Override
    public int getConstitution() {
        return getStat("Constitution");
    }

    @Override
    public int getWillpower() {
        return getStat("Willpower");
    }

    @Override
    public int getSpeed() {
        return getStat("Speed");
    }

    @Override
    public int getLuck() {
        return getStat("Luck");
    }
}