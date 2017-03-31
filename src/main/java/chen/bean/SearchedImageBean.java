package chen.bean;

/**
 * Created by lionschen on 2017/3/8.
 * 是用于搜索的图像的bean
 */
public class SearchedImageBean {

    //颜色熵
    private double colorEntropy;

    //标签名
    private String tagName;

    //标签的可信度
    private int tagConfidence;

    //图像的id
    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public double getColorEntropy() {
        return colorEntropy;
    }


    public void setColorEntropy(double colorEntropy) {
        this.colorEntropy = colorEntropy;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagConfidence() {
        return tagConfidence;
    }

    public void setTagConfidence(int tagConfidence) {
        this.tagConfidence = tagConfidence;
    }
}
