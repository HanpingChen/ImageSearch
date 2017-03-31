package chen.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 17/2/24.
 */
public class FileHelper {

    /**
     * 获取文件夹下的所有文件
     * @param dic
     * @return
     */
    public static List<File> getAllFilesFromDic(String dic){

        List<File> files = new ArrayList<File>();
        File dicFile = new File(dic);
        File[] listfile = dicFile.listFiles();

        //获取所有文件
        for (int i=0;i<listfile.length;i++){

            String path = listfile[i].getAbsolutePath();

            //获取每一个名
            String[] pathnames = path.split("/");
            //图片的名字
            String filename = pathnames[pathnames.length-1];
            String indexs[] = filename.split("\\.");
            String regx = indexs[indexs.length-1];

            if (regx.equals("jpg")||regx.equals("png")||regx.equals("jpeg")&&regx.equals("bmp")){
                //是图片
                files.add(new File(listfile[i].getAbsolutePath()));
            }
        }
        return files;
    }
}
