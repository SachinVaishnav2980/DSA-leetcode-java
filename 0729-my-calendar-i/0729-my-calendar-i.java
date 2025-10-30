class MyCalendar {

        List<List<Integer>> outer;

    public MyCalendar() { 
        outer=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        if(outer.isEmpty()){
            List<Integer> inner=new ArrayList<>();
            inner.add(startTime);
            inner.add(endTime);
            outer.add(inner);
            return true;
        }
            int j=0;
            while (j<outer.size()) {
                int nextStart=outer.get(j).get(0);
                int nextEnd=outer.get(j).get(1);

                if(startTime<nextEnd && nextStart<endTime){
                    return false;
                }
                j++;
            }
            List<Integer> inner=new ArrayList<>();
            inner.add(startTime);
            inner.add(endTime);
            outer.add(inner);
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */