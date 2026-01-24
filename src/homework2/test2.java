/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework2;


public class test2 {
    public static void main(String[] args) {
        System.out.println("=== Testing All Functions ===\n");
        
        // 1. Test Array Functions
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("1. remove_random: " + java.util.Arrays.toString(hw.remove_random(arr)));
        System.out.println("2. reverse: " + java.util.Arrays.toString(hw.reverse(arr)));
        
        // 2. Test SLL Functions
        SLL<Integer> sll = new SLL<>();
        for (int i = 1; i <= 5; i++) sll.append(i);
        System.out.println("\n3. findIndex(3): " + hw.findIndex(sll, 3));
        
        System.out.print("   Before rotateRight: ");
        sll.printList();
        hw.rotateRight(sll, 2);
        System.out.print("   After rotateRight(2): ");
        sll.printList();
        
        // 3. Test DLL Functions
        DLL<String> dll = new DLL<>();
        String[] words = {"A", "B", "A", "C", "B"};
        for (String w : words) dll.append(w);
        
        System.out.println("\n4. search('C'): " + hw.search(dll, "C"));
        System.out.print("   Before removeDuplicates: ");
        dll.printForward();
        hw.removeDuplicates(dll);
        System.out.print("   After removeDuplicates: ");
        dll.printForward();
        
        // 4. Test CLL Functions
        CLL<Integer> cll = new CLL<>();
        for (int i = 1; i <= 5; i++) cll.append(i);
        
        System.out.println("\n5. deletePosition(3):");
        System.out.print("   Before delete: ");
        cll.printList();
        hw.deletePosition(cll, 3);
        System.out.print("   After delete: ");
        cll.printList();
        
        CLL<Integer> cll2 = new CLL<>();
        for (int i = 1; i <= 6; i++) cll2.append(i);
        
        System.out.println("\n6. splitList:");
        System.out.print("   Original: ");
        cll2.printList();
        CLL<Integer> part2 = hw.splitList(cll2);
        System.out.print("   Part 1: ");
        cll2.printList();
        System.out.print("   Part 2: ");
        part2.printList();
        
        System.out.println("\n=== Testing Complete ===");
    }
}

