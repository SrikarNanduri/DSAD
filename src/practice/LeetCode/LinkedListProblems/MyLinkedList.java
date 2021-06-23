package practice.LeetCode.LinkedListProblems;

/**
 * Created by srikar on 21-06-2021.
 */

class MyLinkedList {
    Node head;
    int size;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        //head = new Node(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        System.out.println(node.val);
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        Node newNode = new Node(val);

        if(index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node node = head;
        if (node.next != null) {
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        } else {
            node.next = newNode;

        }
        size++;
        System.out.println("\n added at index " + index + " value is " + newNode.val + " next element is ");
        if(newNode.next != null) {
            System.out.println(newNode.next.val);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) return;
        if(index==0){
            if(head== null) return;
            head=head.next;
        }

        Node current = head;
        for(int i=0; i<index-1;i++){

            if(current == null) return ;
            current = current.next;
        }


        if(current == null) return ;
        if(current.next !=null){
            current.next= current.next.next;
            size--;
        }


    }
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " \n");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        /*myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtHead(4);// linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3*/

        /*myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(0);*/

        /*myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(0);    // now the linked list is 1->3
        myLinkedList.get(0);*/

        /*myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);
        myLinkedList.get(0);
        myLinkedList.printList();*/

        /*myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.printList();*/
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);

    }

    /*["MyLinkedList", []
    "addAtHead", [2]
    "deleteAtIndex", [1]
    "addAtHead", [2]
    "addAtHead", [7]
    "addAtHead", [3]
    "addAtHead", [2]
    "addAtHead", [5]
    "addAtTail", [5]
    "get",       [5]
    "deleteAtIndex", [6]
    "deleteAtIndex" [4]
    ]*/
}

