package chen.color;

import chen.bean.ColorCollection;
import chen.bean.HSVBean;

import java.util.*;

/**
 * Created by chen on 2017/3/3.
 * 将颜色量化
 */
public class ColorQuantization {


    /**
     * 将输入图像量化
     * 将亮度（V）大于75% 且饱和度（S）大于20%的区域定义为亮彩色区域，
     * @param cList HSV颜色空间
     * @return 经过量化后的调色板
     */
    public static Map<HSVBean,Integer> quantization(List<HSVBean> cList){
        Map<HSVBean,Integer> colorMap = new HashMap<HSVBean, Integer>();

        //初始化
        for (int h=0;h<6;h++){
            for (int s = 0;s<2;s++){
                for (int v = 0;v<3;v++){
                    HSVBean bean = new HSVBean();
                    bean.setH(h);
                    bean.setS(s);
                    bean.setV(v);
                    colorMap.put(bean,0);
                }
            }
        }
        //量化法
        for (int i=0;i<cList.size();i++){
            HSVBean temp = cList.get(i);
            double hb = temp.getH();
            double sb = temp.getS();
            double vb= temp.getV();

            int h = (int) (hb/60)+1;
            int s;
            if (sb>=0&&sb<0.25){
                s = 0;
            }else {
                s = 1;
            }
            int v;
            if (vb>=0&&vb<0.3){
                v = 0;
            }
            else if (vb<0.8){
                v = 1;
            }
            else {
                v = 2;
            }

            HSVBean after = new HSVBean();
            after.setH(h);
            after.setV(v);
            after.setS(s);
            //量化的之后送入map
            colorMap.put(after,colorMap.get(after)+1);
        }

        return colorMap;
    }


    /**
     * 获取量化的H
     * @param h
     * @return
     */
    private static double getQuantizationH(double h){
        double qh = 0;

        if (h%18==0){
            return h;
        }
        //分成十等分,计算当前h处于0-180这十等分区间中的哪一个
        int count = (int) (h/18);
        int mod = (int)h%18;

        qh = mod>9?(18*count+1):(18*count);
        return qh;
    }
}
