package chen.bean;

/**
 * Created by chen on 17/3/23.
 * 图片标签模型
 */
public class TagBean {

    //标签名
    private String tagName;

    //标签可信度
    private int tagConfidence;

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
