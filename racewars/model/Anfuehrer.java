package pr2.vererbung.racewars.racewars.model;

/**
 * Klasse, um Anführer zu repräsentieren, die von einer bestimmten Rasse
 * abstammen.
 */
public class Anfuehrer extends Wesen {
	private String name; // Der Name des Anführers

	private Element dominantesElement; // Das dominante Element des Anführers
	private double bonusFaktor; // Der Bonusfaktor für die Lebenspunkte

    /**
     * Konstruktor für die Erstellung eines Anführers.
     *
     * @param leaderName    Der Name des Anführers.
     * @param rasse         Die Rasse, der der Anführer angehört.
     * @param element       Das dominante Element des Anführers.
     * @param bonusFaktor   Der Bonusfaktor für die Lebenspunkte.
     */

	public Anfuehrer(String leaderName, Rasse rasse, Element element, double bonusFaktor) {
		super(leaderName, rasse.getHealthPoints() * bonusFaktor, rasse.getSchaden() * bonusFaktor, rasse.getSpeed(),
				rasse.getArmor(), rasse.getPrice() * 2);
		this.dominantesElement = element;
		this.bonusFaktor = bonusFaktor;
	}

    /**
     * Getter für das dominante Element des Anführers.
     *
     * @return Das dominante Element des Anführers.
     */
	public Element getDominantesElement() {
		return dominantesElement;
	}
    /**
     * Setter für das dominante Element des Anführers.
     *
     * @param dominantesElement Das dominante Element des Anführers.
     */
	public void setDominantesElement(Element dominantesElement) {
		this.dominantesElement = dominantesElement;
	}

    /**
     * Getter für den Bonusfaktor des Anführers.
     *
     * @return Der Bonusfaktor des Anführers.
     */
	public double getBonusFaktor() {
		return bonusFaktor;
	}
    /**
     * Setter für den Bonusfaktor des Anführers.
     *
     * @param bonusFaktor Der Bonusfaktor des Anführers.
     */
	public void setBonusFaktor(double bonusFaktor) {
		this.bonusFaktor = bonusFaktor;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Überprüft, ob das Element des Anführers dominant gegenüber dem übergebenen
	 * Element ist.
	 *
	 * @param element Element, das überprüft werden soll
	 * @return true, wenn das Element dominant ist, ansonsten false
	 */
	public boolean elementIsSuperior(Element element) {
		if (this.dominantesElement == Element.FEUER && element == Element.LUFT) {
			return true;
		} else if (this.dominantesElement == Element.LUFT && element == Element.ERDE) {
			return true;
		} else if (this.dominantesElement == Element.ERDE && element == Element.WASSER) {
			return true;
		} else if (this.dominantesElement == Element.WASSER && element == Element.FEUER) {
			return true;
		} else {
			return false;
		}

	}
	

	@Override
	public double attacke(Wesen gegner) {
		double damage;
		damage = this.speed * this.schaden;

        // Überprüfen, ob der Gegner ein Mensch ist
		if (gegner == Rasse.MENSCH) {
			damage = beschraenkeSchaden(this.schaden);
		}
        // Überprüfen, ob der Gegner ein Anführer ist und ob das Element des Gegners
        // dem dominanten Element des Anführers überlegen ist
		if (gegner instanceof Anfuehrer) {
			Anfuehrer anfuehrer = (Anfuehrer) gegner;
			if (elementIsSuperior(anfuehrer.getDominantesElement())) {
				damage = damage * 2;
			}
		}
		// Der angerichtete Schaden wird prozentual der angegebenen Rüstung reduziert
		damage = damage * (1 - gegner.getArmor());

		gegner.setHealthPoints(gegner.getHealthPoints() - damage);
		
		return damage;
	}

	
}
