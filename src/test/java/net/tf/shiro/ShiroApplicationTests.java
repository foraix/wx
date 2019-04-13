package net.tf.shiro;

import net.tf.bean.User;
import net.tf.mapper.UserMapper;
import net.tf.service.UserService;
import net.tf.utils.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("yuan");
        user.setPsw("sss");
        R yuan = this.userService.userLogin(user);
        System.out.println(yuan.get("code"));
        if ((int)(yuan.get("code")) == 200) {
            System.out.println("xxfdsfgsd");
        }

    }

}
