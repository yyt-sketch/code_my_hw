/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework2;

class DNode<E> {
    E data;
    DNode<E> prev;
    DNode<E> next;
    
    public DNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DLL<E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size = 0;


    public DNode<E> getHead() {
        return head;
    }

    public DNode<E> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }


    
    // 1. إضافة في النهاية
    public void append(E data) {
        DNode<E> newNode = new DNode<>(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    // 2. إضافة في البداية
    public void prepend(E data) {
        DNode<E> newNode = new DNode<>(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void setHead(DNode<E> newHead) {
        this.head = newHead;
        
        
        if (newHead == null) {
            this.tail = null;
            this.size = 0;
            return;
        }
        
        // ابحث عن الذيل الجديد
        DNode<E> current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        this.tail = current;
        
        
        updateSize();
    }
    
    // 2. تعديل الذيل
    public void setTail(DNode<E> newTail) {
        this.tail = newTail;
        
        if (newTail == null) {
            this.head = null;
            this.size = 0;
            return;
        }
        
        
        newTail.next = null;
        
        // ابحث عن الرأس الجديد
        DNode<E> current = newTail;
        while (current.prev != null) {
            current = current.prev;
        }
        this.head = current;
        
        updateSize();
    }
    
    // 3. تحديث الحجم
    public void updateSize() {
        size = 0;
        DNode<E> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
    }

    
    // 3. الطباعة من البداية للنهاية
    public void printForward() {
        DNode<E> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" ↔ ");
            }
            current = current.next;
        }
        System.out.println(" → null");
    }
    
    // 4. الطباعة من النهاية للبداية
    public void printBackward() {
        DNode<E> current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" ↔ ");
            }
            current = current.prev;
        }
        System.out.println(" → null");
    }
}

