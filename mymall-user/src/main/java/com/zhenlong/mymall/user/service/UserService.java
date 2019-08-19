package com.zhenlong.mymall.user.service;

import com.zhenlong.mymall.user.bean.UmsMember;
import com.zhenlong.mymall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    /**
     * 查询所有会员
     * @return
     */
    List<UmsMember> getAllUser();


    /**
     * 查询会员收货 地址
     * @param memberId
     * @return
     */
     List<UmsMemberReceiveAddress> findUmsRecAddrById(String memberId);

     void addUmsMember(UmsMember umsMember);


}
