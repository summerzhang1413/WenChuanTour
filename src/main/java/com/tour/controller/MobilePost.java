package com.tour.controller;

import com.tour.domain.*;
import com.tour.exception.DaoException;
import com.tour.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("mobile")
public class MobilePost {

    @Autowired
    private UserService userService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private MessageboardService messageboardService;

    @Autowired
    private GoodsOrderService goodsOrderService;

    @Autowired
    private ShareService shareService;

    @RequestMapping("register")
    public String rigister(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String userName = request.getParameter("myName");
        String userPwd = request.getParameter("password");
        User existedUser = userService.findUserByTel(userTel);
        if (existedUser == null) {
            User user = new User();
            user.setUserTel(userTel);
            user.setUserName(userName);
            user.setUserPwd(userPwd);
            user.setIsOnline("0");
            userService.save(user);
            model.addAttribute("info", "注册成功");
        }else {
            model.addAttribute("info", "手机号已被注册");
        }
        return "result_mobile_post";
    }

    @RequestMapping("login")
    public String login(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String userPwd = request.getParameter("password");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        User user = userService.findUserByTelAndPwd(userTel, userPwd);
        if (user == null){
            model.addAttribute("info", "手机号或密码错误");
        }else {
            user.setLongitude(longitude);
            user.setLatitude(latitude);
            user.setIsOnline("1");
            userService.update(user);
            model.addAttribute("info", "登录成功");
        }
        return "result_mobile_post";
    }

    @RequestMapping("addComplaint")
    public String addComplaint(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String userName = request.getParameter("myName");
        String type = request.getParameter("type");
        String date = request.getParameter("date");
        String content = request.getParameter("content");
        String state = "未处理";
        Complaint complaint = new Complaint();
        complaint.setUserTel(userTel);
        complaint.setUserName(userName);
        complaint.setType(type);
        complaint.setDate(date);
        complaint.setContent(content);
        complaint.setState(state);
        complaintService.save(complaint);
        model.addAttribute("info", "提交成功");

        return "result_mobile_post";
    }

    @RequestMapping("addMessageBoard")
    public String addMessageBoard(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String userName = request.getParameter("myName");
        String date = request.getParameter("date");
        String content = request.getParameter("content");
        String state = "未处理";
        Messageboard messageboard = new Messageboard();
        messageboard.setUserTel(userTel);
        messageboard.setUserName(userName);
        messageboard.setDate(date);
        messageboard.setContent(content);
        messageboard.setState(state);
        messageboardService.save(messageboard);
        model.addAttribute("info", "提交成功");

        return "result_mobile_post";
    }

    @RequestMapping("addGoodsOrder")
    public String addGoodsOrder(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String goodsName = request.getParameter("goodsName");
        String date = request.getParameter("date");
        String businessName = request.getParameter("businessName");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String remarks = request.getParameter("remarks");
        Goodsorder goodsorder = new Goodsorder();
        goodsorder.setUserTel(userTel);
        goodsorder.setGoodsName(goodsName);
        goodsorder.setDate(date);
        goodsorder.setBusinessName(businessName);
        goodsorder.setPrice(price);
        goodsorder.setNumber(number);
        goodsorder.setRemarks(remarks);
        goodsOrderService.save(goodsorder);
        model.addAttribute("info", "提交成功");

        return "result_mobile_post";
    }

    @RequestMapping("addShare")
    public String addShare(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("userTel");
        String content = request.getParameter("content");
        String toUserTel = request.getParameter("toUserTel");
        String tag = "0";
        Share share = new Share();
        share.setUserTel(userTel);
        share.setContent(content);
        share.setToUserTel(toUserTel);
        share.setTag(tag);
        shareService.save(share);
        model.addAttribute("info", "分享成功");

        return "result_mobile_post";
    }

}
