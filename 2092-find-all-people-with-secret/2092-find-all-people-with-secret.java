class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> res=new HashSet<>();
        Arrays.sort(meetings, (a, b)->a[2]-b[2]);
        res.add(0);
        res.add(firstPerson);

        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            Map<Integer ,List<Integer>> graph=new HashMap<>();
            Set<Integer> sametime=new HashSet<>();

            //collect same time meetings
            while(i<meetings.length && meetings[i][2]==time){
                int x=meetings[i][0];
                int y=meetings[i][1];

                graph.computeIfAbsent(x, k-> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k-> new ArrayList<>()).add(x);

                sametime.add(x);
                sametime.add(y);
                i++;
            }

            //now bfs only for the people who know the secret
            Queue<Integer> q=new LinkedList<>();
            Set<Integer> visited=new HashSet<>();

            for(int p:sametime){
                if(res.contains(p)){
                    q.offer(p);
                    visited.add(p);
                }
            }

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int nei : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(nei);
                    }
                }
            }
            res.addAll(visited);
        }
        return new ArrayList<>(res);
    }
}