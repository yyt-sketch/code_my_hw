/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework2;
import java.util.Random;

public class hw {
    //السؤال رقم(2) 
    // إزالة عنصر عشوائي من مصفوفة وترجع مصفوفة جديدة
    public static int[] remove_random(int[] a){
        int[] arr;
    Random ran =new Random();
        if (a.length == 0) {
        return new int[0];
    }
        int ixran=ran.nextInt(a.length);
        arr=new int[a.length-1];
        for (int i = 0,j=0; i < a.length; i++) {
            if (i!=ixran) {
                arr[j] = a[i];
                j++;
            }}
            return arr;  
    }
    //السؤال رقم(4)
    // عكس ترتيب عناصر المصفوفة وترجع مصفوفة جديدة
    public static int[] reverse(int[] a){
        int[] arr;
        int last=a.length-1;
        arr=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[last];
            last--;
        }
        return arr;
    }
    //السؤال رقم(8)
    // البحث عن عنصر في SLL وإرجاع موقعه (تبدأ من 1)، -1 إذا لم يوجد
    public static <E> int findIndex(SLL<E> s,E val){
        if(s.isEmpty()){
            return -1;
        }
        Node current =s.getHead();
        int index =1;
        
        while (current!=null) {            
            if (current.data.equals(val)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
        
    }
    //السؤال رقم(6)
    // تدوير SLL لليمين k موقع (آخر k عنصر تصبح في البداية)
    public static <E>void rotateRight(SLL<E> s, int k){
        if(s==null || s.isEmpty()||s.getSize()==1){
            return;
        }
        int len=s.getSize();
        k= k%len;
        int rot=len-k-1;
        Node<E> current=s.getHead();
        if (k<=0) {
            return;
        }
        for (int i = 0; i < rot; i++) {
            current=current.next;
        }
        Node<E> newHead = current.next;
        Node<E> newTail = current;
        Node<E> oldTail = s.getTail();
        oldTail.next=s.getHead();
        current.next=null;
        s.setHead(newHead);
        s.setTail(newTail);
            
    }
    //السؤال رقم(10)
    // إزالة العناصر المكررة من DLL (تحتفظ بأول ظهور لكل عنصر)
    public static <E> void removeDuplicates(DLL<E> d){
        if(d==null || d.isEmpty()||d.getSize()==1){
            return;
        }
        DNode<E> current=d.getHead();
        while (current !=null && current.next!=null ) {   
            DNode<E> chek=current.next;
            while (chek!=null) {                
                if (current.data.equals(chek.data)) {
                    DNode<E> delete=chek;
                    chek=chek.next;
                    if (delete.prev != null) {
                        delete.prev.next=delete.next;
                    }
                    
                    if (delete.next != null) {
                        delete.next.prev=delete.prev;
                    }
                    if (delete==d.getTail()) {
                        d.setTail(delete.prev);
                    }
                    
                }
                else{
                    chek=chek.next;
                }
            }
            current=current.next;
            
        }  
        d.updateSize();
    }
    //السؤال رقم(12)
    // البحث عن عنصر في DLL (true إذا وجد، false إذا لم يوجد)
    public static <E> boolean search(DLL<E> d , E val){
        if (d==null || d.getHead()==null) {
            return false;
        }
        DNode<E> current=d.getHead();
        while (current!=null) {            
            if (current.data.equals(val)) {
                return true;
            }
            current=current.next;
        }
        return false;
    }
    //السؤال رقم(14)
    // حذف عقدة من موقع محدد في CLL (يبدأ الترقيم من 1)
    public static <E> void deletePosition (CLL<E> c , int pos){
        if(c==null || c.isEmpty()){
            return;
        }
        CNode<E> head = c.getHead();
        if (pos<1||pos>c.getSize()) {
            System.out.println("Invalid position");
            return;
        }
        if (c.getSize()==1 ) {
            c.setHead(null);
            c.setTail(null);
            c.setSize(c.getSize() - 1);
            return;
        }
        if (pos==1) {
             c.setHead(head.next);
            c.getTail().next = c.getHead();
            c.setSize(c.getSize() - 1);
            return;
        }
        CNode<E> current = head;
        CNode<E> previous = null;
       
        for (int i = 1; i < pos; i++) {
            previous = current;
            current = current.next;
        }
        
        previous.next = current.next;
        
        if (current == c.getTail()) {
            c.setTail(previous);
        }
        
        c.setSize(c.getSize() - 1);
        
    }
    //السؤال رقم(16)
    // تقسيم CLL إلى نصفين، ترجع النصف الثاني (إذا فردي: الأول أكبر)
    public static <E> CLL<E> splitList(CLL<E> c){
        CLL<E> c2 = new CLL<>();
        if(c==null || c.isEmpty()||c.getSize()==1){
            return c2;
        }
        CNode<E> head = c.getHead();
        CNode<E> tail = c.getTail();
        int total=c.getSize();
        int half = (total+1)/2;
        CNode<E> current = head;
        for (int i = 1; i < half; i++) {
            current=current.next;
        }
        CNode<E> firstc2 = current.next;
        c.setTail(current);
        c.getTail().next=head;
        c.setSize(half);
        
        c2.setHead(firstc2);
        c2.setTail(tail);
        c2.getTail().next=firstc2;
        c2.setSize(total-half);
        
        
        return c2;
        
    }
}
