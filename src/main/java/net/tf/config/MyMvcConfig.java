package net.tf.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @time: 2018/12/13 9:33
 * @version: 1.00
 * @author: hy
 * @desc: springMVC 配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    /**
     * 配置视图跳转路径
     *
     * @param registry 注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //默认访问登录页面
        registry.addViewController("/").setViewName("test");
        //视图跳转设置
        registry.addViewController("/add").setViewName("/user/add");
        registry.addViewController("/delete").setViewName("/user/delete");
        registry.addViewController("/login").setViewName("/user/login");
        registry.addViewController("/unAuth").setViewName("/user/unAuth");
    }

}
