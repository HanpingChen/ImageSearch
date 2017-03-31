package chen.calculate;

/**
 * Created by chen on 2017/2/26.
 * 矩阵运算
 */
public class MatrixOperator {


    /**
     * 两个矩阵相加
     * @param a
     * @param b
     * @return
     */
    public  int[][] add(int[][]a,int[][]b){

        int[][] result = null;
        if (a == null||b == null){
            System.out.println("矩阵为空");
            return null;
        }
        int height = a[0].length;
        int width = a.length;
        //判断两个矩阵是否相等
        if (height!=b[0].length || width!=b.length){
            System.out.println("矩阵不相等");
            return null;
        }
        //相加
        result = new int[width][height];
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++){
                //对于元素相加
                result[i][j] = a[i][j]+b[i][j];
            }
        }
        return result;
    }

    /**
     * 两个矩阵相乘
     * @param a
     * @param b
     * @return
     */
    public int[][] multiply(int[][]a,int[][]b){
        int result[][] = null;
        
        return result;
    }
}
