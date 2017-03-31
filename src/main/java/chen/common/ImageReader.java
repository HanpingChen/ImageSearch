package chen.common;

import chen.bean.ImageBean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chen on 17/2/24.
 */
public class ImageReader {
    private int [][] result;
    private int width = 0;
    private int height = 0;
    private int rgb[];
    private String path;
    public ImageReader(String path) {
        // TODO Auto-generated constructor stub
        rgb = new int[3];
        this.path = path;
        result = readImage(path);
    }

    public int[][] getResult() {
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getRgb() {
        return rgb;
    }

    public void setRgb(int[] rgb) {
        this.rgb = rgb;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setResult(int[][] result) {
        this.result = result;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPath() {
        return path;
    }

    /**
     * 读取给定文件夹路径下的所有文件
     * @param path
     * @return
     */
    private int[][] readImage(String path) {
        File file = new File(path);
        int result[][] = null;
        try {
            BufferedImage bi = ImageIO.read(file);
            System.out.println("读取图片中");
            int width = bi.getWidth();
            int height = bi.getHeight();
            System.out.println("大小为"+width+"*"+height);
            setHeight(height);
            setWidth(width);
            result = new int[width][height];
            for(int i=0;i<width;i++){
                for(int j=0;j<height;j++){
                    result[i][j] = bi.getRGB(i, j);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取image bean
     * @return
     */
    public ImageBean getImageBean(){
        //读取图像文件中的RGB元素
        ImageBean bean = new ImageBean();
        bean.setHeight(getHeight());
        bean.setMatrix(getResult());
        bean.setWidth(getWidth());
        bean.setPath(getPath());

        return bean;
    }
    public void display() {
        for(int i=0;i<width/3;i++){
            for(int j=0;j<height/3;j++){
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");
            }
        }
    }
}
