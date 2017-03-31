package chen.tag;

import chen.bean.TagBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lionschen on 2017/3/23.
 * 解析腾讯云返回的tag json数据
 */
public class ImageTagHelper {

    private String tagResponse;

    public ImageTagHelper(String tagResponse) {
        this.tagResponse = tagResponse;
    }

    /**
     * 解析tag数据
     * @return 封装的tagbean
     */
    public TagBean resolveTag(){

        TagBean bean = new TagBean();
        JSONObject object = null;
        try {
            object = new JSONObject(tagResponse);
            int code = object.getInt("code");
            if (code != 0){
                //腾讯云分析失败
                return null;
            }

            //获取标签数组
            JSONArray tags = object.getJSONArray("tags");
            for (int i=0;i<tags.length();i++){
                JSONObject tag = tags.getJSONObject(i);
                String tagName = tag.getString("tag_name");
                int tagConfidence = tag.getInt("tag_confidence");
                System.out.println("tagname = "+tagName);
                System.out.println("tag_confidence = "+tagConfidence);
            }

            return bean;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
