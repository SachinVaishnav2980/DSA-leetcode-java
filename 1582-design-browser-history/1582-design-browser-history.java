
class BrowserHistory {
    Node head;
    Node tail;
    Node currPoiNode;
    class Node{
        String url;
        Node next;
        Node prev;

        public Node(String s){
            this.url=s;
        }

    }
    Node nodeHP;
    public BrowserHistory(String homepage) {
        head=new Node(null);
        tail=new Node(null);
        nodeHP=new Node(homepage);
        nodeHP.next=tail;
        head.next=nodeHP;
        nodeHP.prev=head;
        tail.prev=nodeHP;
        currPoiNode=nodeHP;
    }
    
    public void visit(String url) {
        Node currNode=new Node(url);
        currPoiNode.next=currNode;
        currNode.prev=currPoiNode;
        currNode.next=tail;
        tail.prev=currNode;
        currPoiNode=currNode;
    }
    
    public String back(int steps) {
        while (steps!=0 && currPoiNode.prev!=head) {
            currPoiNode=currPoiNode.prev;
            steps--;
        }
        return currPoiNode.url;
    }
    
    public String forward(int steps) {
        while (steps!=0 && currPoiNode.next!=tail) {
            currPoiNode=currPoiNode.next;
            steps--;
        }
        return currPoiNode.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */