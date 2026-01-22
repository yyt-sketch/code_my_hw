/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework2;


class Node<E> {
    E data;
    Node<E> next;
    
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

public class SLL<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setHead(Node<E> head) {
        this.head = head;
        updateTailAndSize();
    }
    public void setTail(Node<E> newTail) {
    this.tail = newTail;
    if (tail != null) {
        tail.next = null;
    }}

    public int getSize() {
        return size;
    }

    private void updateTailAndSize() {
        size = 0;
        if (head == null) {
            tail = null;
            return;
        }
        
        Node<E> current = head;
        Node<E> prev = null;
        while (current != null) {
            prev = current;
            current = current.next;
            size++;
        }
        tail = prev;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    // 1. إضافة في النهاية (الأساسية)
    public void append(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
}
