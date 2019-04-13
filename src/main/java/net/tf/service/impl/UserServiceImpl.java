package net.tf.service.impl;

import net.tf.bean.User;
import net.tf.mapper.UserMapper;
import net.tf.service.UserService;
import net.tf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/13 15:49
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public R userLogin(User user) {
        User userLogin = this.userMapper.userLogin(user);
        if (userLogin == null) {
            return R.error("Login Error");
        }
        return R.ok();
    }

    @Override
    public R getUser(String name) {
        User user = this.userMapper.getUser(name);
        if (user == null) {
            return R.error("User Not Found").put("user",null);
        }
        return R.ok().put("user",user);
    }
}
