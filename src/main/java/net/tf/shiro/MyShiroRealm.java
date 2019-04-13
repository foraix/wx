package net.tf.shiro;

import net.tf.bean.User;
import net.tf.service.UserService;
import net.tf.utils.R;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/10 14:33
 * @desc 自定义Realm类
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        R r = userService.getUser(token.getUsername());

        if ((int)(r.get("code")) != 200) {
            //此时返回空，Shiro会抛出未知账户异常
            return null;
        }

        //判断密码
        return new SimpleAuthenticationInfo("", ((User) r.get("user")).getPsw(), "");
    }
}
