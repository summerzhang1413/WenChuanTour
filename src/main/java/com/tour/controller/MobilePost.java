package com.tour.controller;

import com.tour.domain.*;
import com.tour.exception.DaoException;
import com.tour.services.*;
import com.tour.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private NewsService newsService;

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
            model.addAttribute("info", user.getUserName());
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

    @RequestMapping("getComplaint")
    public String getComplaint(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        List<Complaint> complaintByUserTel = complaintService.findComplaintByUserTel(userTel);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < complaintByUserTel.size(); i ++){
            Complaint complaint = complaintByUserTel.get(i);
            buffer.append(complaint.getType());
            buffer.append("/");
            buffer.append(complaint.getDate());
            buffer.append("/");
            buffer.append(complaint.getState());
            buffer.append("/");
            buffer.append(complaint.getContent());
            buffer.append("/");
            buffer.append("*");
        }
        String s1 = buffer.toString();

        model.addAttribute("info", s1);
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
        String date = ControllerUtil.getCurrentDate();
        String toUserTel = request.getParameter("toUserTel");
//        System.out.println(">>>>>" + userTel + content + toUserTel);
        String tag = "0";
        boolean isExisted = false;
        User userSelf = userService.findUserByTel(userTel);
        String friends = userSelf.getFriend();
        if(userSelf != null && !(friends == null || friends == "")){
            String[] friendTels = friends.split("/");

            for (int i = 0; i < friendTels.length; i++){
                //判断是否有此好友
                if (friendTels[i].equals(toUserTel)){
                    isExisted = true;
                }
            }
        }
        if (isExisted) {
            Share share = new Share();
            share.setUserTel(userTel);
            share.setContent(content);
            share.setDate(date);
            share.setToUserTel(toUserTel);
            share.setTag(tag);
            shareService.save(share);
            model.addAttribute("info", "分享成功");
        }else {
            model.addAttribute("info", "此手机号不是您的好友");
        }

        return "result_mobile_post";
    }

    @RequestMapping("addFriend")
    public String addFriend(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String friendTel = request.getParameter("friendTel");
        User userSelf = userService.findUserByTel(userTel);
        User userFriend = userService.findUserByTel(friendTel);
        if (userFriend == null){
            model.addAttribute("info", "没有此用户");
        }else{
            String friends = userSelf.getFriend();
            userSelf.setFriend(friends + "/" + friendTel);
            userService.update(userSelf);
            model.addAttribute("info", userFriend.getUserName() + "/" + userFriend.getIsOnline());
        }

        return "result_mobile_post";
    }

    @RequestMapping("getAllShareMessage")
    public String getAllShareMessage(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        List<Share> shareList = shareService.findShareListByUserTel(userTel);
        if (shareList == null){
            model.addAttribute("info", "无分享内容");
        }else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < shareList.size(); i++){
                stringBuffer.append(shareList.get(i).getUserTel());
                stringBuffer.append("/");
                stringBuffer.append(shareList.get(i).getContent());
                stringBuffer.append("/");
                stringBuffer.append(shareList.get(i).getDate());
                stringBuffer.append("*");
            }
            model.addAttribute("info", stringBuffer.toString());
        }

        return "result_mobile_post";
    }

    @RequestMapping("getAllFriends")
    public String getAllFriends(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String allFriends = userService.findAllFriends(userTel);
        String[] split = allFriends.split("/");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < split.length; i++){
            User user = userService.findUserByTel(split[i]);
            buffer.append(user.getUserTel());
            buffer.append("/");
            buffer.append(user.getUserName());
            buffer.append("*");

        }
        model.addAttribute("info", buffer.toString());

        return "result_mobile_post";
    }

    @RequestMapping("getMessageBoard")
    public String getMessageBoard(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        List<Messageboard> messagesByUserTel = messageboardService.findMessageByUserTel(userTel);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < messagesByUserTel.size(); i++){
            Messageboard messageboard = messagesByUserTel.get(i);
            String tel = messageboard.getUserTel();
            String name = messageboard.getUserName();
            String content = messageboard.getContent();
            String date = messageboard.getDate();
            String state = messageboard.getState();
            buffer.append(tel);
            buffer.append("/");
            buffer.append(name);
            buffer.append("/");
            buffer.append(content);
            buffer.append("/");
            buffer.append(date);
            buffer.append("/");
            buffer.append(state);
            buffer.append("*");

        }
        model.addAttribute("info", buffer.toString());

        return "result_mobile_post";
    }

    @RequestMapping("getFriendLocation")
    public String getFriendLocation(Model model, HttpServletRequest request) throws DaoException{
        String friendTel = request.getParameter("friendTel");
        User userByTel = userService.findUserByTel(friendTel);
        String longitude = userByTel.getLongitude();
        String latitude = userByTel.getLatitude();
        model.addAttribute("info", longitude + "/" + latitude);

        return "result_mobile_post";
    }

    @RequestMapping("updateUserLocation")
    public String updateUserLocation(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        User user = userService.findUserByTel(userTel);
        user.setLongitude(longitude);
        user.setLatitude(latitude);
        userService.update(user);
        model.addAttribute("info", "更新成功");

        return "result_mobile_post";
    }

    @RequestMapping("getAllGoodsOrder")
    public String getAllGoodsOrder(Model model, HttpServletRequest request) throws DaoException{
        String userTel = request.getParameter("myNumber");
        List<Goodsorder> allGoodsOrderByUserTel = goodsOrderService.findAllGoodsOrderByUserTel(userTel);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < allGoodsOrderByUserTel.size(); i++){
            Goodsorder goodsorder = allGoodsOrderByUserTel.get(i);
            buffer.append(goodsorder.getGoodsName());
            buffer.append("/");
            buffer.append(goodsorder.getDate());
            buffer.append("/");
            buffer.append(goodsorder.getBusinessName());
            buffer.append("/");
            buffer.append(goodsorder.getPrice());
            buffer.append("/");
            buffer.append(goodsorder.getNumber());
            buffer.append("/");
            buffer.append(goodsorder.getRemarks());
            buffer.append("*");
        }
        model.addAttribute("info", buffer.toString());

        return "result_mobile_post";
    }

    @RequestMapping("getNews")
    public String getNewsTheLast8(Model model) throws DaoException{
        List<News> theLast8 = newsService.findTheLast8();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < theLast8.size(); i ++){
            News news = theLast8.get(i);
            buffer.append(news.getNewsTitle());
            buffer.append("/");
            buffer.append(news.getNewsTime());
            buffer.append("/");
            buffer.append(news.getNewsContent());
            buffer.append("/");
            buffer.append("*");

        }
        model.addAttribute("info", buffer.toString());
        return "result_mobile_post";
    }

}
