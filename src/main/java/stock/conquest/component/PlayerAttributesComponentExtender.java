package stock.conquest.component;

import net.minecraft.nbt.NbtCompound;
import org.ladysnake.cca.api.v3.component.Component;

public interface PlayerAttributesComponentExtender extends Component {
    // Methods for getting and setting attributes
    float getAttribute(String key);
    void setAttribute(String key, float value);
    NbtCompound getAllAttributes();

    // Methods for reading and writing to NBT
    void readFromNbt(NbtCompound tag);
    void writeToNbt(NbtCompound tag);

    // Player attributes
    float getMaxHealth();
    float getCurrentHealth();
    float getHealthRegenerationRate();
    float getMaxStamina();
    float getCurrentStamina();
    float getStaminaRegenerationRate();
    float getMaxMana();
    float getCurrentMana();
    float getManaRegenerationRate();
    float getArmorRating();
    float getPoise();
    float getSlashDefense();
    float getStrikeDefense();
    float getPierceDefense();
    float getRangedDefense();
    float getMagicalDefense();
    float getFireDefense();
    float getFrostDefense();
    float getShockDefense();
    float getPoisonDefense();
    float getSlashDamage();
    float getStrikeDamage();
    float getPierceDamage();
    float getRangedDamage();
    float getMagicalDamage();
    float getFireDamage();
    float getFrostDamage();
    float getShockDamage();
    float getPoisonDamage();
    float getSpellAbsorption();
    float getStaminaCostModifier();
    float getManaCostModifier();
    float getFallDamageReceived();
    float getRunSpeed();
    float getCrouchSpeed();
    float getSwimSpeed();
    float getJumpStrength();
    float getOxygen();
    float getPotionEffectiveness();
    float getDisposition();
}