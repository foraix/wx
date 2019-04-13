package net.tf.controller;

import net.tf.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.PasswordAuthentication;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/9 18:36
 * @desc
 */
@Controller
public class TestController {

    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "ok";
    }

    @GetMapping("/test1")
    public String test1(Model model) {
        model.addAttribute("xx","xx");
        return "test";
    }

    /**
     * 使用Shiro编写用户登录认证操作
     */
    @PostMapping(value = "/toLogin")
    public String toLogin(User user, Model model) {
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPsw());
        //执行登录操作,只要没有发生异常就说明登录成功
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "user/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "user/login";
        }
        catch (AuthenticationException e) {
            model.addAttribute("msg", "认证异常");
            return "user/login";
        }
        return "user/success";
    }


}
