class Solution {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;                  
        double h = (hour % 12) * 30 + minutes * 0.5;  
        double ang = Math.abs(m - h);            
        return Math.min(ang, 360 - ang);         
    }
}