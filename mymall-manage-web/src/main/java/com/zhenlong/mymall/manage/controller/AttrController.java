package com.zhenlong.mymall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenlong.mymall.bean.PmsBaseAttrInfo;
import com.zhenlong.mymall.bean.PmsBaseAttrValue;
import com.zhenlong.mymall.bean.PmsBaseSaleAttr;
import com.zhenlong.mymall.bean.PmsProductSaleAttr;
import com.zhenlong.mymall.manage.util.PmsUploadUtil;
import com.zhenlong.mymall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-21 19:52
 */

@Controller
@CrossOrigin
public class AttrController {
    @Reference
    private AttrService attrService;

    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }

    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
          String success = attrService.saveAttrInfo(pmsBaseAttrInfo);

        return success;
    }

    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
   List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues = attrService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }
}
