package chen.util;


import chen.calculate.MatrixOperator;

/**
 * Created by chen on 2017/2/26.
 */
public class MathUtil {

    /**
     * 两个矩阵相加
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixAdd(int[][]a,int[][]b){
        return new MatrixOperator().add(a, b);
    }

    /**
     * 两个矩阵相乘
     * @param a
     * @param b
     * @return
     */
    public int[][] matrixMultiply(int[][]a,int[][]b){
       return new MatrixOperator().add(a, b);
    }

}
