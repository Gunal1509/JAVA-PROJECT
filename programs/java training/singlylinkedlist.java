class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class Linkedlist{
    Node head;
    void insert(int data)
    {
        Node newnode= new Node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newnode;
    }
    void display()
    {
           Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    void insertbeginning(int data)
    {
        Node newnode = new Node(data);
        if(head!=null)
        {
            newnode.next=head;
            head=newnode;
            System.out.println("inserted in beginning");
            return;
        }
        head=newnode;
    }
    void insertend(int data)
    {
        Node newnode = new Node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        Node temp= head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newnode;
        System.out.println("inserted at end");
    }
}
class singlylinkedlist{
    public static void main(String[] args){
        Linkedlist list= new Linkedlist();
    list.insert(10);
    list.insert(20);
    list.insert(30);
    list.insert(40);
    list.insertbeginning(50);
    list.insertend(67);

    list.display();
    }
}