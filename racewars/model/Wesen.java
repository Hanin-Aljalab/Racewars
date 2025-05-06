package pr2.vererbung.racewars.racewars.model;


/**
 * Basisklasse für alle Wesen im Spiel.
 */
public abstract class Wesen {


    /**
     * Der Name des Wesens.
     */
    protected String name;
    /**
     * Die Lebenspunkte des Wesens.
     */
    protected double healthPoints;
    /**
     * Der Schaden, den das Wesen austeilen kann.
     */
    protected double schaden;
    /**
     * Die Geschwindigkeit des Wesens.
     */
    protected int speed;
    /**
     * Die Rüstung des Wesens.
     */
    protected double armor;
    /**
     * Der Preis des Wesens.
     */
    protected int price;

    /**
     * Konstruktor für das Wesen.
     *
     * @param name         Der Name des Wesens.
     * @param healthPoints Die Lebenspunkte des Wesens.
     * @param schaden      Der Schaden, den das Wesen austeilen kann.
     * @param speed        Die Geschwindigkeit des Wesens.
     * @param armor        Die Rüstung des Wesens.
     * @param price        Der Preis des Wesens.
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
     * Gibt den Namen des Wesens zurück.
     *
     * @return Der Name des Wesens.
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Wesens.
     *
     * @param name Der neue Name des Wesens.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Lebenspunkte des Wesens zurück.
     *
     * @return Die Lebenspunkte des Wesens.
     */
    public double getHealthPoints() {
        return healthPoints;
    }

    /**
     * Setzt die Lebenspunkte des Wesens.
     *
     * @param healthPoints Die neuen Lebenspunkte des Wesens.
     */
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Gibt den Schaden des Wesens zurück.
     *
     * @return Der Schaden des Wesens.
     */
    public double getSchaden() {
        return schaden;
    }

    /**
     * Setzt den Schaden des Wesens.
     *
     * @param schaden Der neue Schaden des Wesens.
     */
    public void setSchaden(double schaden) {
        this.schaden = schaden;
    }

    /**
     * Gibt die Geschwindigkeit des Wesens zurück.
     *
     * @return Die Geschwindigkeit des Wesens.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setzt die Geschwindigkeit des Wesens.
     *
     * @param speed Die neue Geschwindigkeit des Wesens.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gibt die Rüstung des Wesens zurück.
     *
     * @return Die Rüstung des Wesens.
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Setzt die Rüstung des Wesens.
     *
     * @param armor Die neue Rüstung des Wesens.
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }

    /**
     * Gibt den Preis des Wesens zurück.
     *
     * @return Der Preis des Wesens.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setzt den Preis des Wesens.
     *
     * @param price Der neue Preis des Wesens.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }


    /**
     * Greife das andere Wesen an. Der Schaden wird berechnet und beim
     * gegnerischen Wesen abgezogen.
     *
     * @param gegner Wesen, das angegriffen werden soll.
     * @return Zugefügter Schaden.
     */
    public abstract double attacke(Wesen gegner);

    /**
     * Beschränkt den Schaden.
     *
     * @param dmg Schaden.
     * @return Vebleibender Schaden nach der Beschränkung.
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
     * Gibt an, ob das Wesen noch lebt (Lebenspunkte > 0).
     *
     * @return true, wenn das Wesen noch lebt, ansonsten false
     */
    public boolean isLebendig() {
        return getHealthPoints() >= 0;
    }


}
