package pr2.vererbung.racewars.racewars.model;


/**
 * Base class for all creatures in the game.
 */
public abstract class Wesen {


    /**
     * The name of the creature.
     */
    protected String name;
    /**
     * The health points of the creature.
     */
    protected double healthPoints;
    /**
     * The damage the creature can deal.
     */
    protected double schaden;
    /**
     * The speed of the creature.
     */
    protected int speed;
    /**
     * The armor of the creature.
     */
    protected double armor;
    /**
     * The cost of the creature.
     */
    protected int price;

    /**
     * Constructor for the creature.
     *
     * @param name         The name of the creature.
     * @param healthPoints The health points of the creature.
     * @param schaden      The damage the creature can deal.
     * @param speed        The speed of the creature.
     * @param armor        The armor of the creature.
     * @param price        The cost of the creature.
     */
    public Wesen(String name, double healthPoints, double schaden, int speed, double armor, int price) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.schaden = schaden;
        this.speed = speed;
        this.armor = armor;
        this.price = price;
    }

    /**
     * Returns the name of the creature.
     *
     * @return The name of the creature.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the creature.
     *
     * @param name The new name of the creature.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the creature's health points.
     *
     * @return The health points of the creature.
     */
    public double getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets the creature's health points.
     *
     * @param healthPoints The new health points of the creature.
     */
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Returns the creature's damage value.
     *
     * @return The damage of the creature.
     */
    public double getSchaden() {
        return schaden;
    }

    /**
     * Sets the creature's damage value.
     *
     * @param schaden The new damage of the creature.
     */
    public void setSchaden(double schaden) {
        this.schaden = schaden;
    }

    /**
     * Returns the creature's speed.
     *
     * @return The speed of the creature.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the creature's speed.
     *
     * @param speed The new speed of the creature.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Returns the creature's armor.
     *
     * @return The armor of the creature.
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Sets the creature's armor.
     *
     * @param armor The new armor of the creature.
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }

    /**
     * Returns the creature's cost.
     *
     * @return The cost of the creature.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the creature's cost.
     *
     * @param price The new cost of the creature.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }


    /**
     * Attack the opponent creature. Calculates and applies damage.
     *
     * @param gegner Creature to be attacked.
     * @return Damage dealt.
     */
    public abstract double attacke(Wesen gegner);

    /**
     * Restricts the damage based on certain criteria.
     *
     * @param damage Raw damage.
     * @return Remaining damage after applying restrictions.
     */
    public double beschraenkeSchaden(double damage) {
        damage = speed * this.schaden;
        double bonus = 1.0;
        if (this instanceof Anfuehrer) {
            Anfuehrer anfuehrer = (Anfuehrer) this;
            bonus = anfuehrer.getBonusFaktor();
        }
        damage = damage * bonus;
        return damage;
    }

    /**
     * Indicates whether the creature is still alive (health > 0).
     *
     * @return true if the creature is alive, otherwise false
     */
    public boolean isLebendig() {
        return getHealthPoints() >= 0;
    }


}
