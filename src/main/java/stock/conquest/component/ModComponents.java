package stock.conquest.component;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import stock.conquest.client.player_stats.PlayerStatsApplier;

public class ModComponents implements EntityComponentInitializer {
    public static final ComponentKey<PlayerStatsComponents> PLAYER_STATS =
            ComponentRegistry.getOrCreate(Identifier.of("conquest", "player_stats"), PlayerStatsComponents.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(PlayerEntity.class, PLAYER_STATS, player -> new PlayerStatsApplier(player) {
            @Override
            public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
                // Optional: Load data
            }

            @Override
            public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
                // Optional: Save data
            }
        });
    }
}