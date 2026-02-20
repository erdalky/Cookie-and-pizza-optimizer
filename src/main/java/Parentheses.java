package com.student_word;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static class ResizingCharStack {
        private char[] stack;
        private int size;

        public ResizingCharStack() {
            stack = new char[1];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(char c) {
            if (size == stack.length) {
                resize(2 * stack.length);
            }
            stack[size++] = c;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            char item = stack[--size];

            if (size > 0 && size == stack.length / 4) {
                resize(stack.length / 2);
            }
            return item;
        }

        public void resize(int capacity) {
            char[] temp = new char[capacity];
            System.arraycopy(stack, 0, temp, 0, size);
            stack = temp;
        }
    }

    public static boolean isBalanced(String s) {
        ResizingCharStack stack = new ResizingCharStack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = StdIn.readLine().trim();
        boolean result = isBalanced(input);
        StdOut.println(result);
    }
}
