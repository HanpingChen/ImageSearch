package chen.bean;

/**
 * Created by chen on 17/2/24.
 * 图像对象的封装bean
 */
public class ImageBean {

    //图像的宽度
    private int width ;

    //图像的高度
    private int height;

    //图像的路径
    private String path;

    //图像的像素矩阵
    private int[][] matrix;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * 从dip读取rgb
     * @param dip
     * @return
     */
    public ColorBean getRGBFromDip(int dip){

        ColorBean colorBean = new ColorBean();
        int r = (dip & 0xff0000) >> 16;
        int g = (dip & 0xff00) >> 8;
        int b = (dip & 0xff);

        colorBean.setB((double) b/255);
        colorBean.setG((double) g/255);
        colorBean.setR((double) r/255);

        return colorBean;
    }
}
