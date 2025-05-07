package pr2.vererbung.racewars.racewars.model;

/**
 * The Element class represents the four basic elements: Fire, Earth, Air, and Water.
 */
public final class Element {
    /**
     * The Fire element.
     */
    public static final Element FEUER = new Element("Feuer");
    /**
     * The Earth element.
     */
    public static final Element ERDE = new Element("Erde");
    /**
     * The Air element.
     */
    public static final Element LUFT = new Element("Luft");
    /**
     * The Water element.
     */
    public static final Element WASSER = new Element("Wasser");

    /** The name of the element. */
    private String name;

    /**
     * Constructor for creating an element.
     *
     * @param name The name of the element.
     */
    private Element(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the element.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }
}
