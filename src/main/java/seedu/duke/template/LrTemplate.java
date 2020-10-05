package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;

public class LrTemplate extends RTemplate {
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";

    private Inductor inductor;

    public LrTemplate(double resistance, double inductance, double powerSupply) {
        super(resistance, powerSupply);
        inductor = new Inductor(inductance);
    }

    public LrTemplate() {
        this(0,0,0);
    }

    /**
     * Returns calculated impedance of the LrTemplate circuit.
     *
     * @return double type calculated Impedance.
     */
    @Override
    public double calcImpedance() {
        return Math.sqrt(Math.pow(getResistor().getValue(), 2)
                + Math.pow(inductor.getValue() * angularFrequency, 2));
    }

    /**
     * Returns inductor object, an attribute of the instance of LrTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    public Inductor getInductor() {
        return inductor;
    }

    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return RL_TEMPLATE + "Total Resistance: " + getResistor() + System.lineSeparator()
                           + "Total Inductance: " + inductor + System.lineSeparator();
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
        if (component.equals("l")) {
            return inductor;
        }
        return super.getComponent(component);
    }
}
