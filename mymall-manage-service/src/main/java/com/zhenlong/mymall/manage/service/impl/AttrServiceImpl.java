package com.zhenlong.mymall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhenlong.mymall.bean.PmsBaseAttrInfo;
import com.zhenlong.mymall.bean.PmsBaseAttrValue;
import com.zhenlong.mymall.bean.PmsBaseSaleAttr;
import com.zhenlong.mymall.manage.mapper.PmsBaseSaleAttrMapper;
import com.zhenlong.mymall.service.AttrService;
import com.zhenlong.mymall.manage.mapper.PmsBaseAttrInfoMapper;
import com.zhenlong.mymall.manage.mapper.PmsBaseAttrValueMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-21 20:01
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

      String id =  pmsBaseAttrInfo.getId();

      if (StringUtils.isBlank(id)){
          //id为空是保存操作
          try {
              //保存属性
              pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);//insert 是把null值也插入 insertSelective是不插入空值
              //获取属性值集合并set外键值
              //保存属性值
              List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
              for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                  pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                  pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
              }
              return "保存成功！";
          } catch (Exception e) {
              return "保存失败!";
          }
      }else {
          try {
              //否则是修改操作
              Example example = new Example(PmsBaseAttrInfo.class);
              example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
              pmsBaseAttrInfoMapper.updateByExample(pmsBaseAttrInfo,example);

              //先删除某个属性值
              PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
              pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
              pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
                //在遍历插入数据
              List<PmsBaseAttrValue> attrValues =   pmsBaseAttrInfo.getAttrValueList();
              for (PmsBaseAttrValue attrValue : attrValues) {
                  attrValue.setAttrId(pmsBaseAttrInfo.getId());
                  pmsBaseAttrValueMapper.insertSelective(attrValue);
              }

              return "修改成功!";
          } catch (Exception e) {
              return "修改失败!";
          }
          //按照属性id删除所有属性值

      }
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {

        return pmsBaseSaleAttrMapper.selectAll();
    }
}
