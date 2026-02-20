package com.student_word;

import edu.princeton.cs.algs4.StdOut;

public class Josephus {

    public static class IntNode {
        public int data;
        public IntNode next;

        public IntNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedQueue {
        public IntNode first;
        public IntNode last;
        public int n;

        public LinkedQueue() {
            this.first = null;
            this.last = null;
            this.n = 0;
        }

        public void enqueue(int value) {
            IntNode oldLast = last;
            last = new IntNode(value);
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            n++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue underflow");
            }
            int item = first.data;
            first = first.next;
            n--;
            if (isEmpty()) {
                last = null;
            }
            return item;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return n;
        }
    }

    public static void printJosephusOrder(int N, int M) {
        if (M <= 0) {
            StdOut.println();
            return;
        }

        LinkedQueue queue = new LinkedQueue();

        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            int eliminated = queue.dequeue();
            StdOut.print(eliminated);
            if (!queue.isEmpty()) {
                StdOut.print(" ");
            }
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            StdOut.println("Usage: Josephus <N> <M>");
            return;
        }

        try {
            int N = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            printJosephusOrder(N, M);
        } catch (NumberFormatException e) {
            StdOut.println("Usage: Josephus <N> <M>");
        }
    }
}

