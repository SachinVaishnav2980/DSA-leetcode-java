class Solution {
    class Pair{
        int plant;
        int grow;

        public Pair(int plant, int grow){
            this.plant=plant;
            this.grow=grow;
        }
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n=plantTime.length;
        List<Pair> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new Pair(plantTime[i], growTime[i]));
        }

        Collections.sort(list, (a, b) -> Integer.compare(b.grow, a.grow));

        int maxBloom=0;
        int prevPlant=0;

        for(int i=0;i<n;i++){
            int currPlantTime=list.get(i).plant;
            int currGrowTime=list.get(i).grow;

            prevPlant+=currPlantTime;
            int bloomTime= currGrowTime + prevPlant;
            maxBloom=Math.max(maxBloom, bloomTime);
        }
        return maxBloom;
    }
}