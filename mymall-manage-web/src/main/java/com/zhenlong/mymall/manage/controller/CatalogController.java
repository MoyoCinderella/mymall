package com.zhenlong.mymall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenlong.mymall.bean.PmsBaseCatalog1;
import com.zhenlong.mymall.bean.PmsBaseCatalog2;
import com.zhenlong.mymall.bean.PmsBaseCatalog3;
import com.zhenlong.mymall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-21 17:02
 */
@CrossOrigin
@Controller
public class CatalogController {
    @Reference
    private CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){

     List<PmsBaseCatalog1> pmsBaseCatalog1List =   catalogService.getCatalog1();
        return pmsBaseCatalog1List;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        //System.out.println("=========>"+catalogService);
        List<PmsBaseCatalog2> pmsBaseCatalog2List =   catalogService.getCatalog2(catalog1Id);
        return pmsBaseCatalog2List;
    }

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        //System.out.println("=========>"+catalogService);
        List<PmsBaseCatalog3> pmsBaseCatalog3List =   catalogService.getCatalog3(catalog2Id);
        return pmsBaseCatalog3List;
    }
}
