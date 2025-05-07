package stock.conquest.component;

import net.minecraft.nbt.NbtCompound;
import org.ladysnake.cca.api.v3.component.Component;

public interface PlayerAttributesComponentExtender extends Component {
    int getAttribute(String key);
    void setAttribute(String key, int value);
    NbtCompound getAllAttributes();

    void readFromNbt(NbtCompound tag);
    void writeToNbt(NbtCompound tag);

    int getMaxHealth();
    int getCurrentHealth();
    int getHealthRegenerationRate();
    int getMaxStamina();
    int getCurrentStamina();
    int getStaminaRegenerationRate();
    int getMaxMana();
    int getCurrentMana();
    int getManaRegenerationRate();
    int getArmorRating();
    int getPoise();
    int getSlashDefense();
    int getStrikeDefense();
    int getPierceDefense();
    int getMagicalDefense();
    int getFireDefense();
    int getFrostDefense();
    int getShockDefense();
    int getPoisonDefense();
    int getSpellAbsorption();
    int getPhysicalDamageModifier();
    int getMagicalDamageModifier();
    int getStaminaCostModifier();
    int getManaCostModifier();
    int getFallDamageReceived();
    int getRunSpeed();
    int getCrouchSpeed();
    int getSwimSpeed();
    int getJumpStrength();
    int getOxygen();
    int getPotionEffectiveness();
    int getDisposition();
}