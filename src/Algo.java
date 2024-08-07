import java.io.IOException;
import java.util.Arrays;

import static com.sun.deploy.perf.DeployPerfUtil.write;

public class Algo {
    public static void main(String[] args) throws IOException {
//    MaxHeap heap = new MaxHeap();
//    heap.insert(4);
//    heap.insert(5);
//    heap.insert(8);
//    heap.insert(2);
//        heap.insert(2);
//        heap.insert(2);
//   // heap.insert(60);
//    heap.delete();
// //   heap.delete();
//  //  heap.delete();

        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(12);
        linkedList.insert(14);
        linkedList.insert(22);
        linkedList.insert(24);
        linkedList.display();
        linkedList.reverse();
        linkedList.display();
        System.out.println("LinkedList " + linkedList.length());
        linkedList.deleteFromTheEnd();
        linkedList.deleteFromTheEnd();
        linkedList.display();
        linkedList.deleteFromBeginning();
        linkedList.deleteFromBeginning();
        //linkedList.deleteFromBeginning();

        System.out.println("------------------------------------------->");
        linkedList.display();
    }
}
