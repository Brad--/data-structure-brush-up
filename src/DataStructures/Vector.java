package DataStructures;

import java.util.Arrays;

public class Vector{

    private static final int START_SIZE = 16;

    private int [] content;
    private int numItems;
    private int size;

    public Vector () {
        this.content = new int[START_SIZE];
        this.numItems = 0;
        this.size = START_SIZE;
    }

    public int size() {
        return this.numItems;
    }

    public int capacity() {
        return this.size;
    }

    public boolean isEmpty () {
        return this.numItems == 0;
    }

    public void push(int item) {
        if (contentIsFull()) {
            resize(this.size * 2);
        }
        this.content[++this.numItems] = item;
    }

    public int at(int index) throws IndexOutOfBoundsException{
        if (index > this.numItems - 1) {
            throw new IndexOutOfBoundsException();
        }
        return content[index];
    }

    public void insert(int index, int item) {
        if (contentIsFull()) {
            resize(this.size * 2);
        }
        for(int i = this.numItems - 1; i > index - 1; i--) {
            this.content[i + 1] = this.content[i];
        }
        this.content[index] = item;
        this.numItems++;
    }

    public void prepend(int item) {
        insert(0, item);
    }

    public int pop() {
        int value = this.content[--this.numItems];
        if (this.numItems < (this.size / 4)) {
            resize(this.size / 2);
        }
        return value;
    }

    public void delete(int index) throws IndexOutOfBoundsException{
        if (index > this.numItems - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < numItems - 1; i++) {
            this.content[i] = this.content[i + 1];
        }
        this.numItems--;
        if (this.numItems < this.size / 4) {
            resize(this.size / 2);
        }
    }

    private boolean contentIsFull() {
        return this.numItems == (this.size - 1);
    }

    private void resize(int capacity) {
        // I could just pass this capacity, but that defeats the purpose of the exercise imo
        int[] swap = Arrays.copyOf(this.content, this.size);

        this.size = capacity;
        this.content = new int[this.size];

        for (int i = 0; i < swap.length; i++) {
            content[i] = swap[i];
        }
    }

//    delete(index) - delete item at index, shifting all trailing elements left
//    remove(item) - looks for value and removes index holding it (even if in multiple places)
//    find(item) - looks for value and returns first index with that value, -1 if not found

}
