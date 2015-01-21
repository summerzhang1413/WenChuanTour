package com.tour.controller;

import com.tour.domain.Complaint;
import com.tour.domain.User;
import com.tour.exception.DaoException;
import com.tour.services.ComplaintService;
import com.tour.services.UserService;
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
    public void addComplaint(HttpServletRequest request) throws DaoException{
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

    }

}
