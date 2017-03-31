package chen.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lionschen on 2017/3/8.
 * 颜色熵的几个加权函数的实现
 */
public class WeightEntropy {

    /**
     * 排序直方图的加权函数
     * f(H) = 1+ MH/Mmax
     * 其中MH是当前移动总次数
     * Mmax是直方图分量需要移动的最大次数
     * @param h
     * @return
     */
    public static double f1(List<Integer> h){
        double f1 = 0;

        List<Integer> des = new ArrayList<Integer>();
        des =  h;
        //排序
        Collections.sort(h);

        //定义移动的最大的次数和移动的总次数
        int Mh = 0;
        int MMax = 0;
        //计算移动的次数
        for (int i=0;i<h.size();i++){
            int beforeCount = Collections.binarySearch(des,h.get(i));
            //分量的移动次数
            int length = Math.abs(i - beforeCount);
            //累加
            Mh += length;
            //判断是否大于当前移动的最大次数
            if (length>MMax){
                MMax = length;
            }
        }

        //计算f1
        f1 = 1+Mh/MMax;
        return f1;
    }

    /**
     * 直方图面积的加权函数
     * @param h
     * @return
     */
    public static double f2(List<Integer> h){

        double f2 = 0;
        //计算直方图面积
        double Ah = 0;
        //直方图分量的最大面积
        double AMax = 0;
        for (int i=0;i<h.size();i++){

            if (AMax<h.get(i)){
                AMax = h.get(i);
            }
            Ah += h.get(i)*i;
        }

        f2 = 1 + Ah/AMax;
        return f2;
    }

    /**
     * 对直方图排序发和直方图面积法的线性组合
     * @param h
     * @return
     */
    public static double f3(List<Integer> h){
        double f3 = 0;

        f3 = 0.75*f1(h) + 0.25*f2(h);
        return f3;
    }
}
