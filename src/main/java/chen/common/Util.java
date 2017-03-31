package chen.common;

/**
 * Created by chen on 2017/2/26.
 */
public class Util {

    public static void display(int[][] a) {
        int height = a[0].length;
        int width = a.length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static double min(double r,double g,double b){
        int min = 0;
        if (r<b){
            if (g<r){
                //最小值为g
                return g;
            }
            else {
                return r;
            }
        }

        else {
            if (b<g){
                return b;
            }
            else {
                return g;
            }
        }

    }
}
