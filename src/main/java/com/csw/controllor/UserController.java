package com.csw.controllor;

import com.csw.entity.User;
import com.csw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String LoginAction(User user, String captchaCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("securityCode");
        System.out.println("code:" + code);
        System.out.println("captchaCode//:" + captchaCode);
        String a = "abc";
        String b = "ABC";
        System.out.println("a.equals(b)://" + a.equals(b));
        System.out.println("code.equals(captchaCode)://" + code.equals(captchaCode));
        User user2 = userService.login(user.getUsername(), user.getPassword());
        if (user2 != null && code.equalsIgnoreCase(captchaCode)) {
            request.getSession().setAttribute("user", user2);
            return "redirect:/file/showAll";
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("safe")
    public String safeOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.jsp";
    }

}
