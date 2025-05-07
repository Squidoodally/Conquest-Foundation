package stock.conquest.component;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import stock.conquest.client.player_skills.PlayerSkillsApplier;

public class PlayerSkillsBinder implements EntityComponentInitializer {

    public static final ComponentKey<PlayerSkillsComponentExtender> PLAYER_SKILLS =
            ComponentRegistry.getOrCreate(Identifier.of("conquest", "player_skills"), PlayerSkillsComponentExtender.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(PlayerEntity.class, PLAYER_SKILLS, PlayerSkillsApplier::new);
    }
}