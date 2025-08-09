/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public Codec(){

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
            StringBuilder string=new StringBuilder();
            preorder(root, string);
            return string.toString();
        }

        public void preorder(TreeNode node,  StringBuilder string){
            if(node==null){
                string.append("null,");
                return ;
            }
            string.append(node.val).append(",");
            preorder(node.left, string);
            preorder(node.right, string);

        }

        public TreeNode deserialize(String data){
            if(data==null || data.isEmpty()) return null;
            
            String []values=data.split(",");
            Queue<String> queue=new LinkedList<>(Arrays.asList(values));
            return helper(queue);
        }        

        public TreeNode helper(Queue<String> queue){
            String val=queue.poll();
            if(val.equals("null")) return null;

            TreeNode node=new TreeNode(Integer.parseInt(val));
            node.left=helper(queue);
            node.right=helper(queue);
            return node;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));