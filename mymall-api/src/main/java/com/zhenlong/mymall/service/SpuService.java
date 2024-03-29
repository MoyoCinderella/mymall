package com.zhenlong.mymall.service;

import com.zhenlong.mymall.bean.PmsProductImage;
import com.zhenlong.mymall.bean.PmsProductInfo;
import com.zhenlong.mymall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
