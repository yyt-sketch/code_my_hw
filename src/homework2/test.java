package homework2;

import Stack.SlinkedStack;
import Queue.SLinkedQueue;

public class test{
    
    public static void main(String[] args) {
        hw2<Integer> intSolver = new hw2<>();
        hw2<String> stringSolver = new hw2<>();
        
        // ========== اختبار السؤال 1: عكس سلسلة نصية ==========
        System.out.println("=== Test 1: Reverse String ===");
        String test1 = hw2.reverseStack("Java"); // هذه static فلا مشكلة
        System.out.println("Input: Java");
        System.out.println("Output: " + test1);
        System.out.println("Expected: avaJ");
        System.out.println("Test 1 passed: " + test1.equals("avaJ"));
        
        // ========== اختبار السؤال 2: ترتيب مكدس ==========
        System.out.println("\n=== Test 2: Sort Stack ===");
        SlinkedStack<Integer> stack = new SlinkedStack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);
        System.out.println("Original stack (top to bottom): 1, 8, 2, 5");
        
        SlinkedStack<Integer> sorted = intSolver.sortStack(stack);
        System.out.print("Sorted stack (top to bottom): ");
        boolean test2Passed = true;
        int expected2 = 1;
        while (!sorted.isEmpty()) {
            int value = sorted.pop();
            System.out.print(value + " ");
            if (value != expected2) {
                test2Passed = false;
            }
            expected2++;
        }
        System.out.println("\nTest 2 passed: " + test2Passed);
        
        // ========== اختبار السؤال 3: عكس قائمة الانتظار ==========
        System.out.println("\n=== Test 3: Reverse Queue ===");
        SLinkedQueue<String> queue = new SLinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        System.out.println("Original queue: A, B, C, D");
        

        SLinkedQueue<String> reversedQueue = stringSolver.reverseQueue(queue);
        System.out.print("Reversed queue: ");
        boolean test3Passed = true;
        String[] expected3 = {"D", "C", "B", "A"};
        int i = 0;
        while (!reversedQueue.isEmpty()) {
            String value = reversedQueue.dequeue();
            System.out.print(value + " ");
            if (!value.equals(expected3[i])) {
                test3Passed = false;
            }
            i++;
        }
        System.out.println("\nTest 3 passed: " + test3Passed);
        
        // ========== اختبار السؤال 4: قائمة الانتظار ذات الأولوية ==========
        System.out.println("\n=== Test 4: Priority Queue ===");
        hw2.PriorityQueue<Integer> pq = new hw2.PriorityQueue<>();
        pq.enqueue(10);
        pq.enqueue(5);
        pq.enqueue(20);
        pq.enqueue(3);
        pq.enqueue(15);
        System.out.println("Added: 10, 5, 20, 3, 15");
        
        System.out.print("Dequeued order: ");
        boolean test4Passed = true;
        int[] expected4 = {3, 5, 10, 15, 20};
        int j = 0;
        while (!pq.isEmpty()) {
            int value = pq.dequeue();
            System.out.print(value + " ");
            if (value != expected4[j]) {
                test4Passed = false;
            }
            j++;
        }
        System.out.println("\nTest 4 passed: " + test4Passed);
        
        // ========== اختبار السؤال 5: دمج قائمتي انتظار ==========
        System.out.println("\n=== Test 5: Merge Sorted Queues ===");
        SLinkedQueue<Integer> q1 = new SLinkedQueue<>();
        q1.enqueue(1);
        q1.enqueue(4);
        q1.enqueue(7);
        
        SLinkedQueue<Integer> q2 = new SLinkedQueue<>();
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(8);
        q2.enqueue(9);
        
        System.out.println("Queue 1: 1, 4, 7");
        System.out.println("Queue 2: 2, 3, 8, 9");
        
        // استخدام الكائن intSolver
        SLinkedQueue<Integer> merged = intSolver.mergeSortedQueues(q1, q2);
        System.out.print("Merged queue: ");
        boolean test5Passed = true;
        int[] expected5 = {1, 2, 3, 4, 7, 8, 9};
        int k = 0;
        while (!merged.isEmpty()) {
            int value = merged.dequeue();
            System.out.print(value + " ");
            if (value != expected5[k]) {
                test5Passed = false;
            }
            k++;
        }
        System.out.println("\nTest 5 passed: " + test5Passed);
        
        // ========== نتيجة الاختبارات الكلية ==========
        System.out.println("\n=== Final Results ===");
        System.out.println("Test 1: " + (test1.equals("avaJ") ? "PASS" : "FAIL"));
        System.out.println("Test 2: " + (test2Passed ? "PASS" : "FAIL"));
        System.out.println("Test 3: " + (test3Passed ? "PASS" : "FAIL"));
        System.out.println("Test 4: " + (test4Passed ? "PASS" : "FAIL"));
        System.out.println("Test 5: " + (test5Passed ? "PASS" : "FAIL"));
    }
}