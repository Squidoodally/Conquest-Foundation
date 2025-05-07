package stock.conquest.component;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import stock.conquest.client.player_attributes.PlayerAttributesApplier;

public class PlayerAttributesBinder implements EntityComponentInitializer {

    public static final ComponentKey<PlayerAttributesComponentExtender> PLAYER_ATTRIBUTES =
            ComponentRegistry.getOrCreate(Identifier.of("conquest", "player_attributes"), PlayerAttributesComponentExtender.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(PlayerEntity.class, PLAYER_ATTRIBUTES, PlayerAttributesApplier::new);
    }
}