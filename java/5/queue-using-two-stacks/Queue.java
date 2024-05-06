import java.util.Stack;
import java.util.NoSuchElementException;

public class Queue<T> {
    private Stack<T> enqueue;
    private Stack<T> dequeue;

    public Queue() {
        this.enqueue = new Stack<>();
        this.dequeue = new Stack<>();
    }

    public void push(T value) {
        enqueue.push(value);
    }

    private void transfer() {
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop());
        }
    }

    public T pop() {
        if (dequeue.isEmpty()) {
            transfer();
        }
        if (dequeue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty!\n");
        }
        return dequeue.pop();
    }

    public T peek() {
        if (dequeue.isEmpty()) {
            transfer();
        }
        if (dequeue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty!\n");
        }
        return dequeue.peek();
    }
}