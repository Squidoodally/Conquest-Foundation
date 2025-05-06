package stock.conquest.component;

import org.ladysnake.cca.api.v3.component.ComponentV3;

public interface ModStatsComponents extends ComponentV3 {
    int getStrength();
    void setStrength(int value);

    int getFinesse();
    void setFinesse(int value);

    int getIntelligence();
    void setIntelligence(int value);

    int getConstitution();
    void setConstitution(int value);

    int getWillpower();
    void setWillpower(int value);

    int getSpeed();
    void setSpeed(int value);

    int getLuck();
    void setLuck(int value);
}