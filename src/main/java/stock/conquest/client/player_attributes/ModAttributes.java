package stock.conquest.client.player_attributes;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModAttributes {
    // Declare the attributes as RegistryEntry<EntityAttribute>
    public static final RegistryEntry<EntityAttribute> STAMINA;
    public static final RegistryEntry<EntityAttribute> MANA;

    static {
        // Register the attributes into the registry and create RegistryEntry<EntityAttribute>
        STAMINA = RegistryEntry.of(Registry.register(Registries.ATTRIBUTE, Identifier.of("conquest", "stamina"),
                new ClampedEntityAttribute("attribute.name.generic.stamina", 50.0, 0.0, 1024.0).setTracked(true)));
        MANA = RegistryEntry.of(Registry.register(Registries.ATTRIBUTE, Identifier.of("conquest", "mana"),
                new ClampedEntityAttribute("attribute.name.generic.mana", 20.0, 0.0, 1024.0).setTracked(true)));
    }

    public static void register() {

    }
}