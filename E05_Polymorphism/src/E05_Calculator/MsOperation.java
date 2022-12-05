package E05_Calculator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MsOperation implements Operation{

    private Deque<Integer> memory;

    public MsOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        return memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}