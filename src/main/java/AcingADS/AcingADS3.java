package AcingADS;

import java.util.*;

/**
 * Design and implement a priority queue, where the dequeue operation
 * removes and returns the kth smallest element.
 */
public class AcingADS3 {

    //2 steps to break down the dequeue process
    //-> Find out the element to be removes
    //-> Remove the element & restructure the priority queue (min-heap)

    public static class ExtendedPriorityQueue {

        private final List<Integer> heap;

        public ExtendedPriorityQueue() {
            this.heap = new ArrayList<>();
        }


        /**
         * THE QUESTION TO DO
         * Removes and returns the kth smallest element from the priority queue.
         * @param k the number of which smallest element order to be removed
         * @return the kth smallest element from the priority queue (in O(logn + klogk) runtime)
         */
        int dequeue(int k) {
            //data structure PQ to store the possible locations for next smallest element
            //-to find the next smallest element dequeue from the PQ
            //-then also add both children of this element

            //initialise PQ to store possible locations of smallest elements
            ExtendedPriorityQueue pq = new ExtendedPriorityQueue();

            //enqueue root to pq
//            int i = 0;
            pq.enqueue(heap.get(0));

            //repeat k-1 times
            for (int j = 0; j < k - 1; j++) {
                int curr = pq.dequeue();

//                int left = 2 * i + 1;
//                int right = 2 * i + 2;
            }
            return 1;
        }


        /**
         * Adds element e to the priority queue.
         *
         * @param e element to be added
         */
        void enqueue(int e) {
            heap.add(e);
            upHeap(heap.size() - 1);
        }

        /**
         * Retrieves and removes the first element of this priority queue.
         *
         * @return the first element of the queue
         */
        public int dequeue() {
            int max = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            downHeap(0);
            return max;
        }


        /**
         * Swaps two elements in the heap.
         *
         * @param i array index of one element to swap
         * @param j array index of the other element to swap
         */
        private void swap(int i, int j) {
            int t = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, t);
        }

        /**
         * Restores the heap order property top-down in a heap represented as an ArrayList.
         * When the heap property is invalid at node with index i,
         * the method fixes the heap first locally before fixing the affected subtree.
         *
         * @param i index of the node of the heap to start downHeap from
         */
        private void downHeap(int i) {
            // indices of left and right children
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;
            if (left < heap.size() && heap.get(left) > heap.get(smallest)) smallest = left;
            if (right < heap.size() && heap.get(right) > heap.get(smallest)) smallest = right;
            // heap property invalid at root
            if (smallest != i) {
                swap(i, smallest);
                downHeap(smallest);
            }
        }

        /**
         * Restores the heap order property bottom-up in a heap represented as an ArrayList.
         * The method compares the node to its parent, swaps if necessary,
         * and performs this same operation again and again while traversing up the heap
         * until the property is restored.
         *
         * @param i index of the node
         */
        public void upHeap(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(parent) >= heap.get(i)) return;
                swap(parent, i);
                i = parent;
            }
        }

        /**
         * Returns the number of elements in the heap.
         *
         * @return the current number of elements in the heap
         */
        public int size() {
            return this.heap.size();
        }
    }
}
