package pr2.vererbung.racewars.racewars.model;

/**
 * Class representing a leader who originates from a specific race.
 */
public class Anfuehrer extends Wesen {
	private String name; // The name of the leader

	private Element dominantesElement; // The dominant element of the leader
	private double bonusFaktor; // Bonus factor for health points

    /**
     * Constructor for creating a leader.
     *
     * @param leaderName  The name of the leader.
     * @param rasse       The race the leader belongs to.
     * @param element     The dominant element of the leader.
     * @param bonusFaktor The bonus factor for health points.
     */

	public Anfuehrer(String leaderName, Rasse rasse, Element element, double bonusFaktor) {
		super(leaderName, rasse.getHealthPoints() * bonusFaktor, rasse.getSchaden() * bonusFaktor, rasse.getSpeed(),
				rasse.getArmor(), rasse.getPrice() * 2);
		this.dominantesElement = element;
		this.bonusFaktor = bonusFaktor;
	}

    /**
     * Returns the dominant element of the leader.
     *
     * @return The dominant element.
     */
	public Element getDominantesElement() {
		return dominantesElement;
	}
    /**
     * Sets the dominant element of the leader.
     *
     * @param dominantesElement The new dominant element.
     */
	public void setDominantesElement(Element dominantesElement) {
		this.dominantesElement = dominantesElement;
	}

    /**
     * Returns the bonus factor of the leader.
     *
     * @return The bonus factor.
     */
	public double getBonusFaktor() {
		return bonusFaktor;
	}
    /**
     * Sets the bonus factor of the leader.
     *
     * @param bonusFaktor The new bonus factor.
     */
	public void setBonusFaktor(double bonusFaktor) {
		this.bonusFaktor = bonusFaktor;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Checks whether the leader's element is superior to the given element.
	 *
	 * @param element The element to compare with.
	 * @return true if superior, otherwise false.
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

        // Check if the opponent is a human
		if (gegner == Rasse.MENSCH) {
			damage = beschraenkeSchaden(this.schaden);
		}
        // Check if the opponent is a leader and if their element is inferior
		if (gegner instanceof Anfuehrer) {
			Anfuehrer anfuehrer = (Anfuehrer) gegner;
			if (elementIsSuperior(anfuehrer.getDominantesElement())) {
				damage = damage * 2;
			}
		}
		// Reduce damage based on opponent's armor
		damage = damage * (1 - gegner.getArmor());

		gegner.setHealthPoints(gegner.getHealthPoints() - damage);
		
		return damage;
	}

	
}
