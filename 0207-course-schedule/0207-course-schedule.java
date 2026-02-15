class Solution {
    public boolean canFinish(int N, int[][] edges) {
        // Your Code goes here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        //prepare list
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
        }
        int []indegree=new int[N];
        
        //calculate indegree
        for(int i = 0; i < N; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        List<Integer> topo=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            topo.add(node);
            
            for(int el:adj.get(node)){
                indegree[el]--;
                if(indegree[el]==0) queue.add(el);
            }
        }
        if(topo.size()==N) return true;
        else return false;
    }
}