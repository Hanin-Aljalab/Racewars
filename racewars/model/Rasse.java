package pr2.vererbung.racewars.racewars.model;

/**
 * Klasse, um die Rasse eines Wesens anzugeben. Die Klasse enthält vier
 * statische Referenzen, welche die vier Rassen des Spiels repräsentieren.
 * Außerdem speichert sie noch die Kosten pro Rasse.
 */

public class Rasse extends Wesen {

    /**
     * Die Rasse Ork.
     */
    public static final Rasse ORK = new Ork();
    /**
     * Die Rasse Mensch.
     */
    public static final Rasse MENSCH = new Mensch();
    /**
     * Die Rasse Nachtelf.
     */
    public static final Rasse NACHTELF = new Nachtelf();
    /**
     * Die Rasse Untote.
     */
    public static final Rasse UNTOTE = new Untote();

    /**
     * Konstruktor für die Rasse.
     *
     * @param name         Der Name der Rasse.
     * @param healthPoints Die Lebenspunkte der Rasse.
     * @param schaden      Der Schaden der Rasse.
     * @param speed        Die Geschwindigkeit der Rasse.
     * @param armor        Die Rüstung der Rasse.
     * @param price        Der Preis der Rasse.
     */
    public Rasse(String name, double healthPoints, double schaden, int speed, double armor, int price) {
        super(name, healthPoints, schaden, speed, armor, price);
    }

    /**
     * Gibt den Namen der Rasse zurück.
     *
     * @return Der Name der Rasse.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Berechnet den Schaden, den die Rasse einem Gegner zufügt,
     * und aktualisiert gleichzeitig die Lebenspunkte des Gegners.
     *
     * @param gegner Das gegnerische Wesen.
     * @return Der angerichtete Schaden.
     */
    @Override
    public double attacke(Wesen gegner) {
        double damage;
        damage = this.speed * this.schaden;
        if (gegner == MENSCH) {
            damage = beschraenkeSchaden(this.schaden);
        }

        // Der angerichtete Schaden wird prozentual der angegebenen Rüstung reduziert
        damage = damage * (1 - gegner.getArmor());

        gegner.setHealthPoints(gegner.getHealthPoints() - damage);
        return damage;
    }

}
