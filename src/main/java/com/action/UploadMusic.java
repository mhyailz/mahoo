package com.action;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.OSSObject;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import java.io.*;

/**
 * Created by mahongyao on 2014/10/22.
 */
@Controller
@RequestMapping("/music")
public class UploadMusic {

    private static final String key = "mFWWkEuk91KbNaGm";

    private static final String value = "YYGuHLVPIP7zmyQ7jadyOSEmiVbTT9";

    private static final OSSClient client = new OSSClient("http://oss-cn-qingdao.aliyuncs.com",key, value);

    @RequestMapping(value="uploadMusic", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("music/uploadMusic");
        try{
            getObject("mahoo","后悔无期.mp3");
        }catch(Exception e){

        }
        return mv;
    }


    @RequestMapping(value="upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(
            @RequestParam(value = "musicName", required = false) String musicName,
            @RequestParam(value = "musicUrl", required = false) String musicUrl) {
        try{
            uploadObject("mahoo",musicName,musicUrl);
        }catch (Exception e){
            System.out.print("错误日志：" + e);
        }
        ModelAndView mv = new ModelAndView("music/uploadMusic");
        return mv;
    }


    /**
     *  上传文件
     * @param bucketName，文件夹名字
     * @param key
     * @param filePath
     * @throws FileNotFoundException
     */

    public void uploadObject(String bucketName, String key, String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());

        meta.addUserMetadata("name","music");

        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, key, content, meta);

        // 打印ETag
        System.out.println(result.getETag());
    }

    /**
     *
     * @param bucketName
     * @param key
     * @throws IOException
     */
    public void getObject(String bucketName, String key) throws IOException {


        // 获取Object，返回结果为OSSObject对象
        OSSObject object = client.getObject(bucketName, key);

        // 获取ObjectMeta
        ObjectMetadata meta = object.getObjectMetadata();


        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();

        // 关闭流
        objectContent.close();
    }
}
