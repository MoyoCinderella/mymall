package com.zhenlong.mymall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhenlong.mymall.bean.UmsMember;
import com.zhenlong.mymall.bean.UmsMemberReceiveAddress;
import com.zhenlong.mymall.user.mapper.UmsRecAddrMapper;
import com.zhenlong.mymall.user.mapper.UserMapper;
import com.zhenlong.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-19 16:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UmsRecAddrMapper umsRecAddrMapper;
    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> findUmsRecAddrById(String memberId) {
        UmsMemberReceiveAddress umsRecAddr = new UmsMemberReceiveAddress();
        umsRecAddr.setMemberId(memberId);
        //return umsRecAddrMapper.selectByExample(umsRecAddr);
        //List<UmsMemberReceiveAddress> umsRecAddrs = umsRecAddrMapper.select(umsRecAddr);
        Example example = new Example(umsRecAddr.getClass());
        example.createCriteria().andEqualTo("memberId",memberId);
        List<UmsMemberReceiveAddress> umsRecAddrs = umsRecAddrMapper.selectByExample(example);
        return umsRecAddrs;
    }

    @Override
    public void addUmsMember(UmsMember umsMember) {
        userMapper.insert(umsMember);

    }
}
