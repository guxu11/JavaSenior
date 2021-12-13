package com.guxu.dataStruture;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author: guxu
 * @create: 2021/11/1
 * @description: 堆
 */
public class MyHeap {
    private int capacity;
    private int size = 0;
    private int[] array;

    public MyHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }


    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        if (!hasLeftChild(parentIndex)) {
            throw new ArrayIndexOutOfBoundsException("没有左孩子");
        }
        return array[getLeftChildIndex(parentIndex)];
    }
    private int rightChild(int parentIndex) {
        if (!hasRightChild(parentIndex)) {
            throw new ArrayIndexOutOfBoundsException("没有右孩子");
        }
        return array[getRightChildIndex(parentIndex)];
    }
    private int parent(int childIndex) {
        if (!hasParent(childIndex)) {
            throw new ArrayIndexOutOfBoundsException("没有父母");
        }
        return array[getParentIndex(childIndex)];
    }

    public void insert(int item) {
        if(size == capacity) {
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
        array[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < array[index]) {
            int temp = array[index];
            array[index] = array[getParentIndex(index)];
            array[getParentIndex(index)] = temp;
            index = getParentIndex(index);
        }
    }
    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty!");
        }
        int head = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return head;
    }

    private void heapifyDown() {
        if (size == 1) {
            return;
        }
        int index = 0;
        int largerChildIndex = getLeftChildIndex(index);
        while (hasLeftChild(index) && array[largerChildIndex] > array[index]) {
            if (hasRightChild(index) && array[largerChildIndex] < rightChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
           int temp = array[index];
           array[index] = array[largerChildIndex];
           array[largerChildIndex] = temp;
            index = largerChildIndex;
            largerChildIndex = getLeftChildIndex(index);
        }
    }
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return array[0];

    }


    public static void main(String[] args) {
        MyHeap myheap = new MyHeap(100);
        int[] a = {2,45,1,6,34,5,23,4555};
        for (int i: a) {
            myheap.insert(i);
        }
        System.out.println("sizeBefore = " + myheap.size);
        for( int j = 0; j < myheap.size; j++) {
            System.out.println(myheap.array[j]);
        }
        int head = myheap.poll();
        System.out.println("head is " + head);
        System.out.println("sizeAfter = " + myheap.size);

        for( int j = 0; j < myheap.size; j++) {
            System.out.println(myheap.array[j]);
        }
    }
}
