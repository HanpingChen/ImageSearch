package chen.util;

import chen.bean.HSVBean;
import chen.color.ColorQuantization;
import chen.color.ColorSpace;
import chen.common.ColorHistogram;

import java.security.interfaces.DSAPublicKey;
import java.util.*;

/**
 * Created by lionschen on 2017/3/8.
 */
public class ColorUtil {

    /**
     * 根据归一化的直方图得出颜色熵
     * 颜色熵的区分度低，但可以作为检索的第一个过滤的方式
     * @param h
     * @return
     */
    public static double getColorEntropyFromHistogram(List<Integer> h){
        double colorEntropy = 0;

        for (int i=0;i<h.size();i++){
            if (h.get(i)!=0) {
                colorEntropy += Math.log(h.get(i)) * h.get(i);
            }
        }
        return -colorEntropy;
    }


    /**
     * 获取利用直方图排序法加权的颜色熵
     * @param h
     * @return
     */
    public static double getSortedColorEntropy(List<Integer> h){
        double colorEntropy = 0;

        //获得加权函数f1(h)
        double f1 =  WeightEntropy.f1(h);
        colorEntropy = f1*getColorEntropyFromHistogram(h);
        return colorEntropy;
    }


    /**
     *获取组合加权函数的颜色熵
     * @param h
     * @return
     */
    public static double getCombinationEntropy(List<Integer> h){
        double colorEntropy = 0;

        double f3 = WeightEntropy.f3(h);
        colorEntropy = f3*getColorEntropyFromHistogram(h);

        return colorEntropy;
    }

    /**
     * 获取制定路径的颜色熵
     * @param path
     * @return
     */
    public static double getCombinationEntropy(String path){
        ColorSpace space = new ColorSpace();
        List<HSVBean> hsv = space.getHSVFromPath(path);

        Map<HSVBean, Integer> quantization = ColorQuantization.quantization(hsv);

        double entropy = getCombinationEntropy(new ColorHistogram().getHistogram(quantization));

        return entropy;
    }


}
