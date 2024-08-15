class Node {
    int data;
    TwoThreeNode next;
    public Node(int data ){
        this.data=data;
        this.next=null;

    }
}

public class LinkedList {
 TwoThreeNode head;
 private  int size;


 public void reverse(){
    TwoThreeNode curr = head;
    TwoThreeNode prev = null;
    TwoThreeNode next;

    while(curr!=null){

        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

    }
    head= prev;
 }

 public Boolean insert(int data){


    TwoThreeNode temp = new TwoThreeNode(data);
    TwoThreeNode curr = head;
    if(curr == null){
        head = temp;
        size++;
        return true;
    }
  while (curr.next!=null){

      curr=curr.next;

  }
  curr.next=temp;
  size++;
 return true;
 }
 public void deleteFromBeginning(){
     if(head == null){
         return;
     }
     if (head.next == null){
         head= null;
         return;
     }
     head=head.next;

 }

 public void deleteFromTheEnd(){
     if(head == null){
         return;
     }
     if (head.next == null) {
         head =null;
      return;
     }
     TwoThreeNode curr = head;
     TwoThreeNode prev= null;
     while (curr.next.next!=null){

         curr=curr.next;
     }
     curr.next=null;
     // System.out.println(curr.data);

 }
 public void display(){
     TwoThreeNode curr = head;
 while (curr!= null){
     System.out.println(curr.data);
     curr = curr.next;
 }
 }
public int length(){

return  size;
 }

 
}

