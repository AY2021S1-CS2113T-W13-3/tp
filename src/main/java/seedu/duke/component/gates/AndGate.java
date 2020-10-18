package seedu.duke.component.gates;

public class AndGate extends TwoInputGate {
    private static final String AND = "--(&|--";

    public AndGate(int input1, int input2) {
        input = input1;
        secondInput = input2;
    }

    @Override
    public int getOutput() {
        return input & secondInput;
    }

    @Override
    public String toString() {
        return AND;
    }
}