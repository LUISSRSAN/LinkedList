class SinglyLinkedList{
Node head;
Node tail;
public int size;



public Node createSinglyLinkedList(int nodeValue){
    head = new Node();     //0(1)
    Node node = new Node();  // 0(1)
    node.next = null;
    node.value = nodeValue;
    head = node;
    tail = node;
    size = 1;
    return head;


}

public void insertInLinkedList(int nodeValue,int location){
    Node node = new Node();
    node.value = nodeValue;
    
    //check for element in head and empty linked list 
    if ( head ==null){
        createSinglyLinkedList(nodeValue);

    }
    //check to add node to beginning of linked list 
    else if (location ==0){
        node.next = head;
        head = node;
    }
    // check to add node to end of linked list  
    else if (location >= size){
        //assign new node to null 
        node.next = null;
        //link to tail
        tail.next = node;
        tail = node;
    }
    else {
        //add node at any location 
        Node tempNode = head;
        int index =0 ;
        while (index < location -1){ // 0(N)
            tempNode = tempNode.next;
            index++;
        }
        //SWAR VALUES 
        Node nextNode = tempNode.next;
        tempNode.next =node;
        node.next = nextNode;
    }
    size ++;
}// TIME COMPLEXITY 0(N) SPACE COMPLEXITY 0 (1)
 
public void traverseSinglyLinkedList(){
    if (head ==null){
        System.out.println("Singly linked list does not exist");   // 0(1)
    }
    else {
        Node tempNode =head;//0(1)
        for (int i =0; i <size;i++){ // 0(N)
            System.out.print(tempNode.value);
            if (i != size-1){ // 0(1)
                System.out.print("->");
            }
            tempNode = tempNode.next;//0(1)
        }
    }
    System.out.println();// 0(1)
    }// time complexity 0(N) space complexity 0 (1)


    public boolean searchNode(int nodeValue){
        if (head != null){//0(1)
            Node tempNode = head;//0(1)
            for (int i=0 ; i <size;i++){ // 0(N)
                if (tempNode.value == nodeValue){
                    System.out.println("Found node at location "+i );//0(1)
                    return true;
                }
                tempNode = tempNode.next;
            }
        }

System.out.println("Node not found");
return false;

    }// tIME COMPLEXITY 0(N) SPACE COMPLEXITY 0(1)


public void deleteNode (int location){
if (head ==null){
    System.out.println("The SLL does not exist");
    return;
}
else if (location ==0){
    head = head.next;
    size --;
    if (size ==0){
        tail = null;
    }
}
else if (location >= size){
        Node tempNode = head;
        for (int i =0;i< size-1 ;i++){
            tempNode = tempNode.next;
        }
        if (tempNode == head){
            tail = head = null;
            size --;
            return ; 
        }
        tempNode.next = null;
        tail = tempNode;
        size--;
    }
else {
        Node tempNode = head;
        for (int i=0 ; i<location-1;i++){
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        size--;
    }

}


public void deleteSinglyLinkedList(){
head = null;
tail = null;
System.out.println("The SLL has been deleted");
}




    public static void main(String[] args) {
    SinglyLinkedList sLL = new SinglyLinkedList();
    sLL.createSinglyLinkedList(1);

   // System.out.println(sLL.head.value);
   sLL.insertInLinkedList(6,1);
   sLL.insertInLinkedList(5,2);
   sLL.insertInLinkedList(7,3);
   sLL.insertInLinkedList(8,4);
   sLL.insertInLinkedList(9,5);
   sLL.traverseSinglyLinkedList();
   //sLL.searchNode(6);
sLL.deleteNode(5);
sLL.traverseSinglyLinkedList();
sLL.deleteSinglyLinkedList();

}


}