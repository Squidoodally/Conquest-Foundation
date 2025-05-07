package stock.conquest.component;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import stock.conquest.client.player_stats.PlayerStatsApplier;

public class PlayerStatsBinder implements EntityComponentInitializer {

    public static final ComponentKey<PlayerStatsComponentExtender> PLAYER_STATS =
            ComponentRegistry.getOrCreate(Identifier.of("conquest", "player_stats"), PlayerStatsComponentExtender.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(PlayerEntity.class, PLAYER_STATS, PlayerStatsApplier::new);
    }
}