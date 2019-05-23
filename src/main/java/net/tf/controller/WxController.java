package net.tf.controller;

import net.tf.service.impl.WxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author hy
 * @version 1.00
 * @time 2019/5/22 11:08
 * @desc
 */
@Controller()
@RequestMapping(value = "wx")
public class WxController {

    /**
     * 接收用户消息
     *
     * @param request
     * @param response
     */
    @PostMapping(value = "/test")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
//        try {
////            ServletInputStream is = request.getInputStream();
////            byte[] bytes = new byte[1024];
////            int len;
////            StringBuilder stringBuilder = new StringBuilder();
////            while ((len = is.read(bytes)) != -1) {
////                stringBuilder.append(new String(bytes, 0, len));
////            }
////            System.out.println(stringBuilder);
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
        //处理消息和事件推送
        try {
            Map<String, String> requestMap = WxService.parseRequest(request.getInputStream());
            System.out.println(requestMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/test")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //校验请求
        if (WxService.check(timestamp, nonce, signature)) {
            try {
                PrintWriter writer = response.getWriter();
                writer.print(echostr);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("xx");
            }
        }
    }
}
