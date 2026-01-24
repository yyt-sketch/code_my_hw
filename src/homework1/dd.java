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

public class dd<E> {
    private CNode<E> head;
    private CNode<E> tail;
    private int size;
    
    public dd() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Getters
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
     public void setTail(CNode<E> newTail) {
        this.tail = newTail;
        // إذا تغير الذيل، تأكد من دائرية القائمة
        if (newTail != null && head != null) {
            newTail.next = head;
        }
        // لا نحدث الحجم هنا، لأن setHead سيفعل ذلك
    }
    
    // واحدة لتعديل الحجم
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
    
    // الأساسية: الطباعة بدون نصوص إضافية
    public void printList() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        
        CNode<E> current = head;
        int count = 0;
        
        do {
            System.out.print(current.data);
            if (current.next != head) {
                System.out.print(" → ");
            }
            current = current.next;
            count++;
        } while (current != head && count < size * 2); // حماية
        System.out.println();
    }
}
