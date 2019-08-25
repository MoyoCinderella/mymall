package com.zhenlong.mymall.service;

import com.zhenlong.mymall.bean.PmsBaseAttrInfo;
import com.zhenlong.mymall.bean.PmsBaseAttrValue;
import com.zhenlong.mymall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
