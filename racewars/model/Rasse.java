package pr2.vererbung.racewars.racewars.model;

/**
 * Class representing the race of a creature.
 * This class defines four static references representing the races in the game
 * and stores race-specific attributes including cost.
 */

public class Rasse extends Wesen {

    /**
     * The Orc race.
     */
    public static final Rasse ORK = new Ork();
    /**
     * The Human race.
     */
    public static final Rasse MENSCH = new Mensch();
    /**
     * The Night Elf race.
     */
    public static final Rasse NACHTELF = new Nachtelf();
    /**
     * The Undead race.
     */
    public static final Rasse UNTOTE = new Untote();

    /**
     * Constructor for creating a race with specific attributes.
     *
     * @param name         The name of the race.
     * @param healthPoints The health points of the race.
     * @param schaden      The damage dealt by the race.
     * @param speed        The speed of the race.
     * @param armor        The armor protection of the race.
     * @param price        The cost of the race.
     */
    public Rasse(String name, double healthPoints, double schaden, int speed, double armor, int price) {
        super(name, healthPoints, schaden, speed, armor, price);
    }

    /**
     * Returns the name of the race.
     *
     * @return The race name.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Calculates and applies damage from this race to an opponent,
     * reducing the opponent's health based on armor resistance.
     *
     * @param gegner The opponent creature.
     * @return The damage dealt.
     */
    @Override
    public double attacke(Wesen gegner) {
        double damage;
        damage = this.speed * this.schaden;
        if (gegner == MENSCH) {
            damage = beschraenkeSchaden(this.schaden);
        }

        // The damage is reduced by the opponent's armor percentage
        damage = damage * (1 - gegner.getArmor());

        gegner.setHealthPoints(gegner.getHealthPoints() - damage);
        return damage;
    }

}
