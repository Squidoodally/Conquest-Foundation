package stock.conquest.client.player_attributes;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class PlayerAttributeApplier {
    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.getPlayer();
            applyAttributeModifiers(player);
        });
    }

    private static void applyAttributeModifiers(ServerPlayerEntity player) {
        // Add persistent modifier for STAMINA
        Objects.requireNonNull(player.getAttributes().getCustomInstance((RegistryEntry<EntityAttribute>) ModAttributes.STAMINA))
                .addPersistentModifier(new EntityAttributeModifier(
                        Identifier.of("conquest", "stamina"),
                        0.0,
                        EntityAttributeModifier.Operation.ADD_VALUE));

        // Add persistent modifier for MANA
        Objects.requireNonNull(player.getAttributes().getCustomInstance((RegistryEntry<EntityAttribute>) ModAttributes.MANA))
                .addPersistentModifier(new EntityAttributeModifier(
                        Identifier.of("conquest", "mana"),
                        0.0,
                        EntityAttributeModifier.Operation.ADD_VALUE));
    }
}