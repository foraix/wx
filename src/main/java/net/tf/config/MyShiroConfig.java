package net.tf.config;

import net.tf.shiro.MyShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/10 14:27
 * @desc Shiro配置类
 */
@Configuration
public class MyShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //保证次序使用LinkedHashMap
        Map<String,String> map = new LinkedHashMap<>();
        //需要注意的是，一定要加上斜杠
        map.put("/add", "authc");
        map.put("/delete", "authc");
        //设置跳转登录页面
        filterFactoryBean.setLoginUrl("/login");
        //设置Shrio过滤器:
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @Qualifier("MyShiroRealm")： 该方法可以调用getRealm对象创建的Realm
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") MyShiroRealm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建Realm
     *
     * @Bean： 注解的作用是将创建的Realm对象放入Spring容器中
     */
    @Bean(name = "realm")
    public MyShiroRealm getRealm() {
        return new MyShiroRealm();
    }
}
