package pr2.vererbung.racewars.racewars.model;

/**
 * Die Klasse Element repräsentiert die vier Elemente Feuer, Erde, Luft und Wasser.
 */
public final class Element {
    /**
     * Das Element Feuer.
     */
    public static final Element FEUER = new Element("Feuer");
    /**
     * Das Element Erde.
     */
    public static final Element ERDE = new Element("Erde");
    /**
     * Das Element Luft.
     */
    public static final Element LUFT = new Element("Luft");
    /**
     * Das Element Wasser.
     */
    public static final Element WASSER = new Element("Wasser");

    /**
     * Der Name des Elements.
     */
    private String name;

    /**
     * Konstruktor für das Element.
     *
     * @param name Der Name des Elements.
     */
    private Element(String name) {
        this.name = name;
    }

    /**
     * Gibt den Namen des Elements zurück.
     *
     * @return Der Name des Elements.
     */
    public String getName() {
        return name;
    }
}
