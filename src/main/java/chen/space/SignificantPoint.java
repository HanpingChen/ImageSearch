package chen.space;

import chen.bean.ImageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lionschen on 2017/3/10.
 * 显著点颜色特征
 */
public class SignificantPoint {

    private ImageBean bean;
    private int[][] grayValue;
    private static int M = 3;

    private class ImageBlock{
        private int[][] imageBlock;

        public ImageBlock(int[][] imageBlock) {
            this.imageBlock = imageBlock;
        }

        public int[][] getImageBlock() {
            return imageBlock;
        }
    }
    public SignificantPoint(ImageBean bean) {
        this.bean = bean;
    }

    public SignificantPoint(int[][] grayValue) {
        this.grayValue = grayValue;
    }

    /**
     * 将原图像划分成很多3x3的小块
     * 并计算出它相应的BDIP值
     * @return
     */
    public List<Double> blockDifference(){
        //获取原图像所有灰度值
        int [][] originalMatrix = grayValue;
        List<Double> blocks = new ArrayList<Double>();

        //图像的宽高
        int width = originalMatrix.length;
        int height = originalMatrix[0].length;

        //划分成小块
        for (int i=2;i<width;i+=3){
            for (int j=2;j<height;j+=3){
                int[][] temp = new int[3][3];
                for(int k=0;k<3;k++){
                    for (int l=0;l<3;l++){
                        temp[k][l] = originalMatrix[i+k-2][j+l-2];
                    }
                }
                //将分割出来的图像块计算成BDIP
                double bdip = getBDIPFromBlock(temp);
                blocks.add(bdip);
            }
        }
        return blocks;
    }

    /**
     * 计算出一个图像块的BDIP值
     * @param block
     * @return
     */
    private double getBDIPFromBlock(int [][] block){
        double bdip = 0;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                int color = block[i][j];
                if (color>max){
                    max = color;
                }
                sum += color;
            }
        }
        bdip = (M*M-sum/max)/(M*M);
        return bdip;
    }
}
