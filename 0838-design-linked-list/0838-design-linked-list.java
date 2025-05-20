class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        this.size=0;
    }
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
 }
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        ListNode temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        if(tail==null){
            addAtHead(val); 
            return ;
        }
        tail.next=node;
        tail=node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
        return;
    }
        if (index == 0) {
        addAtHead(val);
        return;
    }
        if (index == size) {
        addAtTail(val);
        return;
    }
        ListNode node=new ListNode(val);
        ListNode temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

    if (index == 0) {
        head = head.next;
        if (head == null) tail = null; // Fix tail if list becomes empty
        size--;
        return;
    }

    ListNode temp = head;
    for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
    }

    if (temp.next == tail) {
        tail = temp;
    }

    temp.next = temp.next.next;
    size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */