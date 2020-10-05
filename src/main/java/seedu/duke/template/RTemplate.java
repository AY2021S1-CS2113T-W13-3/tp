package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;

public class RTemplate extends Template {
    private static final String R_TEMPLATE =
              "\t+---R---------+\n"
            + "\t|             |\n"
            + "\t|             |\n"
            + "\t+----+V_ac+---+\n";
    protected Resistor resistor;

    public RTemplate(double resistance, double powerSupply) {
        super(powerSupply);
        resistor = new Resistor(resistance);
    }

    /**
     * Returns impedance of Resistor.
     *
     * @return impedance of Resistor.
     */
    @Override
    public double calcImpedance() {
        return resistor.getValue();
    }

    /**
     * Returns resistor object, an attribute of the instance of LrTemplate.
     *
     * @return resistor, an instance of the Resistor class.
     */
    public Resistor getResistor() {
        return resistor;
    }

    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return R_TEMPLATE + "Total Resistance: " + resistor + System.lineSeparator();
    }


    /**
     * Returns LoadComponent object depending on input String.
     *
     * @param component String representing the component.
     * @return LoadComponent object.
     * @throws DukeException If input String does not match a component.
     */
    @Override
    public LoadComponent getComponent(String component) throws DukeException {
        if (!component.equals("r")) {
            throw new DukeException("Invalid component");
        }
        return resistor;
    }
}

