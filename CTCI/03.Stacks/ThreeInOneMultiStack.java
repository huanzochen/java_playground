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

public class ThreeInOneMultiStack {
    private class StackInfo {
        public int start, size, capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index) {
            // If outside bounds of the array, return false;
            if (index < 0 || index >= values.length) {
                return false;
            }

            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        // if the current stack is full, then the lastElementIndex will be the
        // lastCapacityIndex.
        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

    private StackInfo[] info;
    private int[] values;

    public ThreeInOneMultiStack(int numberOfStacks, int defaultSize) {
        // Create metadata for all the stacks

        this.info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[defaultSize * numberOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (allStacksAreFull()) {
            throw new FullStackException();
        }

        /** if the stack is full, expand it */
        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        stack.size++;
        values[stack.lastElementIndex()] = value;
    }

    /* Remove value from stack */
    public int pop(int stackNum) throws EmptyStackException {
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        /* Remove last element */
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0; // Clear item
        stack.size--; // Shrink size
        return value;
    }

    /* Get Top element of the stack */
    public int peek(int stackNum) {
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
    }

    private void shift(int stackNum) {
        System.out.println("// Shifting stack" + stackNum);
        StackInfo stack = info[stackNum];

        if (stack.size >= stack.capacity) {
            // Need % info.length because we are shifting the stack with a circular
            // wrap-around.
            // if info.length is 3, stackNum is 2, then nextStack will be 0.
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity++; // claim index that next stack lost
        }

        /** Shift all elements in stack over by one. */
        int index = stack.lastCapacityIndex();
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        /* Adjust stack data. */
        values[stack.start] = 0; // Clear item
        stack.start = nextIndex(stack.start); // move start
        stack.capacity--; // Shrink capacity
    }

    private void expand(int stackNum) {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    public int numberOfElements() {
        int size = 0;
        for (StackInfo sd : info) {
            System.out.println("sd:" + sd);
            size += sd.size;
        }
        return size;
    }

    public boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    public static void main(String[] args) throws FullStackException, EmptyStackException {
        ThreeInOneMultiStack stack = new ThreeInOneMultiStack(3, 10);

        stack.push(0, 99);
        stack.push(2, 10);
        stack.push(2, 11);
        stack.push(2, 12);

        System.out.println("stack.peek():" + stack.peek(2));
        System.out.println("stack method test numberOfElements():" + stack.numberOfElements());

    }
}
