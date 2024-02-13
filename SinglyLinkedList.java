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
        System.out.println("Singly linked list does not exist");
    }
    else {
        Node tempNode =head;
        for (int i =0; i <size;i++){
            System.out.println(tempNode.value);
            if (i != size-1){
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }
    }
    System.out.println();
    }

public static void main(String[] args) {
    SinglyLinkedList sLL = new SinglyLinkedList();
    sLL.createSinglyLinkedList(1);

   // System.out.println(sLL.head.value);
   sLL.insertInLinkedList(6,1);
   sLL.insertInLinkedList(7,3);
   sLL.insertInLinkedList(8,4);
   sLL.insertInLinkedList(9,5);
   sLL.traverseSinglyLinkedList();


}


}