package com.net.jianshu.controller;

import com.net.jianshu.pojo.Detail;
import com.net.jianshu.util.JsonsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class DetailController
{
    @GetMapping("detail")
    public JsonsData getDetail(@RequestParam("id") String id){
        Detail detail = new Detail();
        detail.setId(id);
        detail.setContent( "<img src='//upload-images.jianshu.io/upload_images/8681868-607c10f94192dd25.jpg'></img><p>提到《金瓶梅》，大家自然而然就会想到潘金莲。不错，今天我就和大家聊一聊这本奇书中间的奇女子——潘金莲</p><p>翆弯弯的新月的眉儿，请冷冷杏子眼儿，香喷喷樱桃口儿，直隆隆琼瑶鼻儿，粉浓浓红艳腮儿，娇滴滴银盆脸儿，轻嬝嬝花朵身儿，玉纤纤葱枝手儿，一捻捻杨柳腰儿，软浓浓粉白肚儿，窄星星尖趫脚儿，肉奶奶胸儿，白生生腿儿</p>"
        );
        detail.setTitle("她是《金瓶梅》里最美的女人");
        return JsonsData.buildSuccess(detail);
    }
}
