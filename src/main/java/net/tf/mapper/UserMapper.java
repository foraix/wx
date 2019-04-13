package net.tf.mapper;

import net.tf.bean.User;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/13 14:55
 * @desc
 */

public interface UserMapper {
    User getUser(String name);

    User userLogin(User user);

}

