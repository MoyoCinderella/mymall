package com.zhenlong.mymall.user.controller;

import com.zhenlong.mymall.bean.UmsMember;
import com.zhenlong.mymall.bean.UmsMemberReceiveAddress;
import com.zhenlong.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2019-08-19 16:35
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
     List<UmsMember> umsMembers =    userService.getAllUser();
    return umsMembers;
    }

    @GetMapping("/findUmsRecAddrByMeId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> findUmsRecAddrByMeId(String memberId){

        return userService.findUmsRecAddrById(memberId);
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "this is test data";
    }

    @PostMapping("/saveUmsMember")
    @ResponseBody
    public String saveUmsMember( UmsMember umsMember){

        userService.addUmsMember(umsMember);

        return "正在保存";
    }
}
