class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int []edge:edges){
            int node1=edge[0];
            int node2=edge[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        int componentCount[]=new int [1];
        dfs(0, -1, adjList, values, k, componentCount);
        return componentCount[0];
    }

    long dfs(int currNode, int parent, List<List<Integer>> adjList, int []values, int k, int []component){
        long sum=0;
        for(int neighbour:adjList.get(currNode)){
            if(neighbour!=parent){
                sum+=dfs(neighbour, currNode, adjList, values, k, component);
            }
        }
        sum+=values[currNode];
        if(sum%k==0){
            component[0]++;
            sum=0;
        }
        return sum;
    }
}