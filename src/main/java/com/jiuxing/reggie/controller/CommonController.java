package com.jiuxing.reggie.controller;

import com.jiuxing.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  20:23
 */

/**
 * 文件上传与下载
 */


@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){


        log.info(file.toString());
        //file 是临时文件，需要转存到指定位置，否则本次请求完成后临时文件删除

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();

        //截取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成文件名，防止文件被覆盖
        String filename = UUID.randomUUID().toString() + suffix;

        //创建一个目录对象
        File dir = new File(basePath);

        //判断目录是否存在
        if(!dir.exists()){
            //目录不存在，则创建
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name , HttpServletResponse response){


        try{
            //输入流 ， 通过输入流读取文件内容
            FileInputStream fileInputStream=new FileInputStream(new File(basePath+name));
            //输出流 ， 通过输出流将文件写回浏览器展示图片
            ServletOutputStream outputStream= response.getOutputStream();

            response.setContentType("image/jpeg");

            byte[] bytes=new byte[1024];
            int len=0;
            while((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
