/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework1;


class CNode<E> {
    E data;
    CNode<E> next;
    
    public CNode(E data) {
        this.data = data;
        this.next = null;
    }
}

public class CLL<E> {
    private CNode<E> head;
    private CNode<E> tail;
    private int size;
    
    public CLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    

    public CNode<E> getHead() {
        return head;
    }
    
    public CNode<E> getTail() {
        return tail;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    
    public void setHead(CNode<E> newHead) {
        this.head = newHead;
    }
    
    public void setTail(CNode<E> newTail) {
        this.tail = newTail;
        if (tail != null && head != null) {
            tail.next = head;
        }
    }
    
    public void setSize(int newSize) {
        this.size = newSize;
    }
    
    // الأساسية: إضافة في النهاية
    public void append(E data) {
        CNode<E> newNode = new CNode<>(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }
    
    // الأساسية: إضافة في البداية
    public void prepend(E data) {
        CNode<E> newNode = new CNode<>(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }
    
    // : الطباعة
    public void printList() {
        if (isEmpty()) {
            System.out.println("القائمة فارغة");
            return;
        }
        
        CNode<E> current = head;
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) {
                System.out.print(" → ");
            }
        } while (current != head);
        System.out.println();
    }
}
