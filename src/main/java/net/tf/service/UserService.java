package net.tf.service;

import net.tf.bean.User;
import net.tf.utils.R;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/13 15:49
 * @desc
 */
public interface UserService {
    R userLogin(User user);
    R getUser(String name);
}
