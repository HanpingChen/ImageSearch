package chen.util;

import chen.bean.HSVBean;
import chen.bean.SearchedImageBean;
import chen.bean.TagBean;
import chen.color.ColorQuantization;
import chen.color.ColorSpace;
import chen.common.ColorHistogram;
import chen.net.SubmitToTxHelper;
import chen.tag.ImageTagHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by chen on 17/3/23.
 * 通过一系列的操作将图片转成成可供搜所的图像对象
 */
public class SearchedImageUtil {

    /**
     * 将图片通过特征工程转换成可供搜索的模型
     * @param path
     * @return
     */
    public SearchedImageBean getSearchedImageBean(String path){

        SearchedImageBean bean = new SearchedImageBean();

        //获取颜色熵
        double entropy = ColorUtil.getCombinationEntropy(path);
        bean.setColorEntropy(entropy);

        //获取标签模型
        TagBean tagBean = new TagBean();
        SubmitToTxHelper helper = new SubmitToTxHelper();
        ImageTagHelper tagHelper = new ImageTagHelper(helper.submit(path));
        tagBean = tagHelper.resolveTag();

        //为搜索模型赋值
        bean.setTagConfidence(tagBean.getTagConfidence());
        bean.setTagName(tagBean.getTagName());

        return bean;
    }
}
