package com.zhenlong.mymall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhenlong.mymall.bean.PmsSkuAttrValue;
import com.zhenlong.mymall.bean.PmsSkuImage;
import com.zhenlong.mymall.bean.PmsSkuInfo;
import com.zhenlong.mymall.bean.PmsSkuSaleAttrValue;
import com.zhenlong.mymall.manage.mapper.PmsSkuAttrValueMapper;
import com.zhenlong.mymall.manage.mapper.PmsSkuImageMapper;
import com.zhenlong.mymall.manage.mapper.PmsSkuInfoMapper;
import com.zhenlong.mymall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.zhenlong.mymall.service.PmsSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-25 15:09
 */
@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {
    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;



    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        int i = pmsSkuInfoMapper.insert(pmsSkuInfo);

        String skuId = pmsSkuInfo.getId();
        //插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
                    pmsSkuAttrValue.setSkuId(skuId);
                    pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }
        
        //插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);

            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        //插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }


    }
}
