package net.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
