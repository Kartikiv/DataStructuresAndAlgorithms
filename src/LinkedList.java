class Node {
    int data;
    Node next;
    public Node(int data ){
        this.data=data;
        this.next=null;

    }
}

public class LinkedList {
 Node head;
 private  int size;


 public void reverse(){
    Node curr = head;
    Node prev = null;
    Node next;

    while(curr!=null){

        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

    }
    head= prev;
 }

 public Boolean insert(int data){


    Node temp = new Node(data);
    Node curr = head;
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
     Node curr = head;
     Node prev= null;
     while (curr.next.next!=null){

         curr=curr.next;
     }
     curr.next=null;
     // System.out.println(curr.data);

 }
 public void display(){
     Node curr = head;
 while (curr!= null){
     System.out.println(curr.data);
     curr = curr.next;
 }
 }
public int length(){

return  size;
 }

 
}

