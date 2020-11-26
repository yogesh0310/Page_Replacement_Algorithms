import java.util.*;
import java.lang.*;

class LRU{
    void computeLRU(){
        int pageFrames,numberOfReference,pageFault=0;
        int[] pageReference;
        Stack<Integer> stack=new Stack<Integer>();
        System.out.println("Enter number of page frames");
        Scanner sc=new Scanner(System.in);
        pageFrames=sc.nextInt();
        System.out.println("Enter number of page reference you want to make");
        numberOfReference=sc.nextInt();
        pageReference=new int[numberOfReference];
        System.out.println("Enter page references");
        for (int i = 0; i < pageReference.length; i++) {
            pageReference[i]=sc.nextInt();
        }
        stack.setSize(pageFrames);
        for (int i = 0; i < pageReference.length; i++) {
            if (stack.size()==pageFrames) {
                int pos=stack.search(pageReference[i]);
                if (pos < 0) {
                    stack.remove(0);
                }
                else{
                    //System.out.println(pos+" "+pageReference[i]);
                    int ele=pageFrames-pos;
                    stack.remove(ele);
                    // System.out.println(stack);
                    stack.push(pageReference[i]);
                    System.out.println("Stack is :"+stack);
                    continue;
                }
            }
            stack.push(pageReference[i]);
            pageFault++;
            System.out.println("Stack is :"+stack);
        }
        System.out.println("Number of Page Faults are :"+pageFault);
    }
}
public class LRU_Page_Replacement {
    public static void main(String[] args) {
        LRU l=new LRU();
        l.computeLRU();
    }
}
