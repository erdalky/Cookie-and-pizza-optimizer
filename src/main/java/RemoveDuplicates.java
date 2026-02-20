package com.student_word;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RemoveDuplicates {

    public static class IntNode {
        public int data;
        public IntNode next;

        public IntNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class IntLinkedList {
        public IntNode head;

        public IntLinkedList() {
            this.head = null;
        }

        public void append(int value) {
            IntNode newNode = new IntNode(value);

            if (head == null) {
                head = newNode;
                return;
            }

            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void print(IntNode head) {
            IntNode current = head;
            while (current != null) {
                StdOut.print(current.data);
                if (current.next != null) {
                    StdOut.print(" ");
                }
                current = current.next;
            }
            StdOut.println();
        }

        public IntNode removeDuplicates(IntNode head) {
            if (head == null) {
                return null;
            }

            IntNode current = head;

            while (current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        int t = StdIn.readInt();

        for (int i = 0; i < t; i++) {
            int n = StdIn.readInt();

            IntLinkedList list = new IntLinkedList();

            for (int j = 0; j < n; j++) {
                int value = StdIn.readInt();
                list.append(value);
            }

            list.head = list.removeDuplicates(list.head);
            list.print(list.head);
        }
    }
}