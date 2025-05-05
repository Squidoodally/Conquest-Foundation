package stock.conquest.client;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class CustomAttributes {
    public static final RegistryEntry<EntityAttribute> STAMINA = Registry.registerReference(
            Registries.ATTRIBUTE,
            Identifier.of("conquest", "stamina"),
            new ClampedEntityAttribute("attribute.name.generic.stamina", 20.0, 0.0, 1024.0).setTracked(true)
    );

    public static final RegistryEntry<EntityAttribute> MANA = Registry.registerReference(
            Registries.ATTRIBUTE,
            Identifier.of("conquest", "mana"),
            new ClampedEntityAttribute("attribute.name.generic.mana", 20.0, 0.0, 1024.0).setTracked(true)
    );
}