package chen.common;

import chen.bean.HSVBean;

import java.util.*;

/**
 * Created by chen on 2017/2/26.
 * 获取图像的全局颜直方图
 */
public class ColorHistogram {


    /**
     * 根据颜色量化结果得到全局颜色直方图
     * @param map
     * @return
     */
    public List<Integer> getHistogram(Map<HSVBean,Integer> map){

        List<Integer> list = new ArrayList<Integer>();

        double [] h;
        Iterator<Map.Entry<HSVBean, Integer>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()){

            count++;
            Map.Entry<HSVBean, Integer> entry = iterator.next();
            list.add(entry.getValue());
            System.out.println(entry.getKey().toString()+" :"+entry.getValue());
        }




        return list;
    }
}
