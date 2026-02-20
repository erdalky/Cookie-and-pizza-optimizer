# Custom Min-Heap & Greedy Algorithms

This repository contains a Java-based implementation of a custom Min-Heap data structure, built entirely from scratch to solve complex optimization problems using Greedy Algorithms. 

The project demonstrates a deep understanding of core data structures by explicitly avoiding Java's built-in `PriorityQueue` or any standard collection-based heaps.

## 🚀 Problems Solved

* **Cookie Sweetness Optimizer:** Calculates the minimum number of mixing operations required to ensure all elements meet a specific sweetness threshold `k`. It utilizes a custom `LongMinHeap` to repeatedly combine the two least sweet elements using a specific mathematical formula.
* **Pizza Shop Scheduler:** Minimizes the average waiting time for customers by intelligently scheduling orders based on their cook time rather than a standard first-come-first-served basis. It relies on a specialized `PizzaJobMinHeap` to process custom `PizzaJob` objects.

## 🧠 Technical Highlights

* **Native Implementation:** The Min-Heap is implemented dynamically via a 1-indexed array representation, utilizing internal `swim()` and `sink()` operations.
* **Memory Management:** Features automatic array resizing (doubling when full, halving when a quarter full) to ensure optimal space complexity.
* **Object-Oriented Design:** Uses inheritance with an `AbstractMinHeap` base class to create specialized heaps for different data types.
* **Strict I/O Handling:** Processes datasets efficiently using Princeton's `algs4` standard I/O library.


