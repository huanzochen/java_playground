import java.util.Arrays;

class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("Stack is empty");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}

class FullStackException extends Exception {
    public FullStackException() {
        super("Stack is full");
    }

    public FullStackException(String message) {
        super(message);
    }
}

public class ThreeInOneFixedStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOneFixedStack(int stackSize) {
        stackCapacity = stackSize;

        // the 3 stack will be the same size? YES!
        values = new int[stackSize * numberOfStacks];

        // The values count that has been pushed to the stackNo
        sizes = new int[numberOfStacks];

        // System.out.println("values:" + Arrays.toString(values));
        // System.out.println("sizes:" + Arrays.toString(sizes));
    }

    /* Push value onto stack */
    public void push(int stackNo, int value) throws FullStackException {
        /* Check that we have space for the next element */
        if (isFull(stackNo)) {
            throw new FullStackException();
        }
        /* Increment stack pointer and then update top value */
        sizes[stackNo]++;
        // sizes should be at the front, that it can be used as an index to put the
        // values.
        values[indexOfTop(stackNo)] = value;

        debugValue(stackNo);
    }

    public int pop(int stackNo) throws EmptyStackException {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        int currentValueIndex = indexOfTop(stackNo);
        int currentValue = values[currentValueIndex];
        values[currentValueIndex] = 0; // Clear value
        sizes[stackNo]--; // shrink sizes

        debugValue(stackNo);

        return currentValue;
    }

    public int peek(int stackNo) throws EmptyStackException {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }

        debugValue(stackNo);

        return values[indexOfTop(stackNo)];
    }

    public boolean isEmpty(int stackNo) {
        return sizes[stackNo] == 0;
    }

    public boolean isFull(int stackNo) {
        return sizes[stackNo] == stackCapacity;
    }

    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNo) {
        int offset = stackNo * stackCapacity;
        int size = sizes[stackNo];
        return offset - 1 + size;
    }

    // Debug only
    public void debugValue(int stackNo) {
        System.out.println("indexOfTop(stackNo):" + indexOfTop(stackNo));
        System.out.println("values:" + Arrays.toString(values));
        System.out.println("sizes:" + Arrays.toString(sizes));
    }

    public static void main(String[] args) {
        ThreeInOneFixedStack stacks = new ThreeInOneFixedStack(5);

        try {
            stacks.push(0, 1);
            stacks.push(0, 2);
            stacks.push(0, 3);

            stacks.push(1, 6);
            stacks.push(1, 7);
            stacks.push(1, 8);

            stacks.push(2, 88);
            stacks.push(2, 99);

            stacks.peek(2);
            stacks.peek(0);
            stacks.pop(2);
            stacks.peek(0);
            stacks.peek(2);

        } catch (FullStackException e) {
            System.out.println("Caught FullStackException: " + e.getMessage());
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException: " + e.getMessage());
        }

    }
}
