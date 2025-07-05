import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;
class StockSpanner {

    Stack<Map.Entry<Integer, Integer>> stack;
    int index=-1;

    public StockSpanner() {
        this.stack=new Stack<>();
    }
    
    public int next(int price) {
        index++;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            stack.pop();
        }
        int ans=index-(stack.isEmpty()?-1:stack.peek().getValue());
        stack.push(new AbstractMap.SimpleEntry<>(price, index));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */