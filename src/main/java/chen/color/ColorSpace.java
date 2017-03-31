package chen.color;

import chen.bean.ColorBean;
import chen.bean.HSVBean;
import chen.bean.ImageBean;
import chen.common.ImageReader;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/3/3.
 * 颜色空间
 */
public class ColorSpace {

    private ImageBean bean;

    public ColorSpace(){

    }

    public ColorSpace(ImageBean bean){
        this.bean = bean;
    }

    /**
     * 获取RGB颜色空间
     * @param path
     * @return
     */
    public List<ColorBean> getRGBSpaceFromPath(String path){

        //读取图像文件中的RGB元素
        ImageReader reader = new ImageReader(path);
        ImageBean bean = new ImageBean();
        bean.setHeight(reader.getHeight());
        bean.setMatrix(reader.getResult());
        bean.setWidth(reader.getWidth());
        bean.setPath(path);

        List<ColorBean> list = new ArrayList<ColorBean>();

        //循环将每个像素点转换成RGB颜色空间
        for (int i=0;i<bean.getWidth();i++){
            for (int j = 0;j<bean.getHeight();j++){
                ColorBean colorBean = bean.getRGBFromDip(bean.getMatrix()[i][j]);
                list.add(colorBean);
            }
        }
        return list;
    }

    /**
     * 通过image bean获取RGB颜色空间
     * @param bean
     * @return
     */
    public List<ColorBean> getRGBSpaceFromImageBean(ImageBean bean){

        List<ColorBean> list = new ArrayList<ColorBean>();

        //循环将每个像素点转换成RGB颜色空间
        for (int i=0;i<bean.getWidth();i++){
            for (int j = 0;j<bean.getHeight();j++){
                ColorBean colorBean = bean.getRGBFromDip(bean.getMatrix()[i][j]);
                list.add(colorBean);
            }
        }
        return list;
    }

    /**
     * 以像素为单位转换成RGB
     * @param bean
     * @return
     */
    public ColorBean[][] getRGBMatrixFromImageBean(ImageBean bean){
        ColorBean[][] rgb = new ColorBean[bean.getWidth()][bean.getHeight()];
        //循环将每个像素点转换成RGB颜色空间
        for (int i=0;i<bean.getWidth();i++){
            for (int j = 0;j<bean.getHeight();j++){
                ColorBean colorBean = bean.getRGBFromDip(bean.getMatrix()[i][j]);
                rgb[i][j] = colorBean;
            }
        }

        return rgb;
    }

    /**
     * 获取灰度值矩阵
     * @param bean
     * @return
     */
    public int[][] getGrayValueFromImageBean(ImageBean bean){

        //获取rgb矩阵
        ColorBean[][] rgb = getRGBMatrixFromImageBean(bean);

        int[][] values = new int[bean.getWidth()][bean.getHeight()];

        for (int i=0;i<bean.getWidth();i++){
            for (int j=0;j<bean.getHeight();j++){
                ColorBean c = rgb[i][j];
                values[i][j] = (int) ((c.getR()*30 + c.getG()*59+c.getB()*11)/100);
            }
        }
        return values;
    }

    /**
     * 获取HSV颜色空间
     * @param path
     * @return
     */
    public List<HSVBean> getHSVFromPath(String path){

        List<HSVBean> list = new ArrayList<HSVBean>();

        List<ColorBean> colorBeanList = getRGBSpaceFromPath(path);
        for (int i=0;i<colorBeanList.size();i++){
            HSVBean hsv = colorBeanList.get(i).castToHsv();
            list.add(hsv);
        }
        return list;
    }

    /**
     * 通过imagebean获取HSV
     * @param bean
     * @return
     */
    public List<HSVBean> getHSVFromPath(ImageBean bean){
        List<HSVBean> list = new ArrayList<HSVBean>();

        List<ColorBean> colorBeanList = getRGBSpaceFromImageBean(bean);
        for (int i=0;i<colorBeanList.size();i++){
            HSVBean hsv = colorBeanList.get(i).castToHsv();
            list.add(hsv);
        }
        return list;
    }


}
