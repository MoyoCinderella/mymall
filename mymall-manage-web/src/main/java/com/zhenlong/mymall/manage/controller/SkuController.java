package com.zhenlong.mymall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenlong.mymall.bean.PmsSkuInfo;
import com.zhenlong.mymall.service.PmsSkuInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Administrator
 * @date 2019-08-25 14:53
 */
@CrossOrigin
@Controller
public class SkuController {
    @Reference
    private PmsSkuInfoService pmsSkuInfoService;
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImg)){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }


        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        pmsSkuInfoService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }


}
