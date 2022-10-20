import java.util.ArrayList;

public class Skill {
    String name;
    int energyCost;

    public Skill(String name, int energyCost) {
        this.name = name;
        this.energyCost = energyCost;
    }


    public String getName() {
        return name;
    }

    public String getEnergyCost() {
        return String.valueOf(energyCost);
    }
}
