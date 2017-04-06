package Math.Q_15_MaxPointsOnALine;

import java.util.HashMap;

/**
 Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {

    public static int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){

            //Hash Map that will store the slopes and their frequency for each point vs rest of the points
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();

            int samex = 1; // same x cordinate, o.e the points are in vertical straight line, note if we calculate slope of vertical line its infinite
            int samep = 0; //duplicate points

            for(int j = 0; j < points.length; j++){
                if(j != i){

                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(1,1), new Point(1,3), new Point(2,0), new Point(3,3), new Point(3,4), new Point(4,3), new Point(5,3), new Point(4,4), new Point(4,5)};
        System.out.println(maxPoints(points));
    }
}
