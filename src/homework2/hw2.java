/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework2;


import Stack.SlinkedStack;
import Queue.SLinkedQueue;
import Queue.DLinkedQueue;

public class hw2<E extends Comparable<E>> {

    // سؤال 1: عكس سلسلة نصية باستخدام المكدس
    public static String reverseStack(String input) {
        if (input == null) return null;
        
        SlinkedStack<Character> stack = new SlinkedStack<>();
        
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }

    // سؤال 2: ترتيب مكدس باستخدام مكدس آخر فقط
    public SlinkedStack<E> sortStack(SlinkedStack<E> stack) {
        SlinkedStack<E> tempStack = new SlinkedStack<>();
        
        while (!stack.isEmpty()) {
            E current = stack.pop();
            
            while (!tempStack.isEmpty() && tempStack.top().compareTo(current) > 0) {
                stack.push(tempStack.pop());
            }
            
            tempStack.push(current);
        }
        
        return tempStack;
    }

    // سؤال 3: عكس ترتيب العناصر في قائمة الانتظار
    public SLinkedQueue<E> reverseQueue(SLinkedQueue<E> queue) {
        SlinkedStack<E> stack = new SlinkedStack<>();
        
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        
        return queue;
    }

    // سؤال 4: قائمة انتظار ذات أولوية (الأصغر أولاً)
    public static class PriorityQueue<E extends Comparable<E>> {
        private SlinkedStack<E> stack = new SlinkedStack<>();
        
        public void enqueue(E data) {
            SlinkedStack<E> tempStack = new SlinkedStack<>();
            
            while (!stack.isEmpty() && stack.top().compareTo(data) < 0) {
                tempStack.push(stack.pop());
            }
            
            stack.push(data);
            
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }
        
        public E dequeue() {
            return stack.pop();
        }
        
        public boolean isEmpty() {
            return stack.isEmpty();
        }
        
        public E peek() {
            return stack.top();
        }
    }

    // سؤال 5: دمج قائمتي انتظار مرتبتين في قائمة انتظار واحدة مرتبة
    public SLinkedQueue<E> mergeSortedQueues(SLinkedQueue<E> q1, SLinkedQueue<E> q2) {
        SLinkedQueue<E> result = new SLinkedQueue<>();
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.front().compareTo(q2.front()) <= 0) {
                result.enqueue(q1.dequeue());
            } else {
                result.enqueue(q2.dequeue());
            }
        }
        
        while (!q1.isEmpty()) {
            result.enqueue(q1.dequeue());
        }
        
        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }
        
        return result;
    }

}
