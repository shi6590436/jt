package com.net.jianshu.controller;

import com.net.jianshu.util.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@PropertySource({"classpath:application.properties"})
public class UploadController {
    @Value("${web.file.path}")
//    private String filePath;
    private String path;
    @RequestMapping("/upload")
    public JsonData upload(@RequestParam("img-file")MultipartFile file, HttpServletRequest request){
        if(file.isEmpty()){
            return new JsonData("1","图片不存在");
        };
        if(file.getSize() >2*1024*1024){
            return new JsonData("1","图片过大");
        }
        //获取姓名
        String name = request.getParameter("name");
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("fileName"+fileName);

        //获取后缀名
        String subName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件名
        String fName =fileName.substring(0,fileName.length()-subName.length());
        //获取时间️格式
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
       String d = s.format(new Date());
        //获取随机数
        Random ran = new Random(99999+10000);
        int r = ran.nextInt();
        String destPath = path+d+"/";
        File pathFile = new File(destPath);
        pathFile.mkdirs();
        fileName = path+d+"/"+fName+r+subName;
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
            return new JsonData("0","上传成功",fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new JsonData("1","上传失败",name);
    }

}
