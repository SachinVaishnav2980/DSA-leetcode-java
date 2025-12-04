class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st=new Stack<>();
        int coll=0;
        //iterate and find curr dir for comparing with prev
        for(char ch:directions.toCharArray()){
            if(st.isEmpty()){st.push(ch); continue;}
            //if current dir is left
            if(ch=='L'){
                if(st.peek()=='R'){
                    //pop all left R
                    int cntr=0;
                    while(!st.isEmpty() && st.peek()=='R'){
                        cntr++;
                        st.pop();
                    }
                    coll+=cntr+1;
                    if(st.isEmpty() || st.peek()!='S') st.push('S');
                }else if(st.peek()=='S'){
                    coll+=1;
                    st.push('S');
                }else{
                    st.push('L');
                }
            }
            //if current dir is stop
            else if(ch=='S'){
                if(st.peek()=='R'){
                    int cntr = 0;
                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        cntr++;
                    }
                    coll+=cntr;
                    if(st.isEmpty() || st.peek()!='S') st.push('S');
                }
                else{
                    st.push('S');
                }
            }
            else{
                st.push(ch);
            }
        }
        return coll;
    }
}