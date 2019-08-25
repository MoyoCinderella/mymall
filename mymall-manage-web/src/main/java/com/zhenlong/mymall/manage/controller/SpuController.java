package com.zhenlong.mymall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenlong.mymall.bean.PmsProductInfo;
import com.zhenlong.mymall.manage.util.PmsUploadUtil;
import com.zhenlong.mymall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-24 12:32
 */
@Controller
@CrossOrigin
public class SpuController {
    @Reference
    SpuService spuService;
    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
      List<PmsProductInfo> pmsProductInfos =  spuService.spuList(catalog3Id);

            return pmsProductInfos;
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 将图片或者音视频上传到分布式的文件存储系统
        // 将图片的存储路径返回给页面
        String imgUrl = PmsUploadUtil.upLoadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        spuService.saveSpuInfo(pmsProductInfo);

        return "success";
    }
}
