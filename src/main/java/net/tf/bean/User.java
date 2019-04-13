package net.tf.bean;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hy
 * @version 1.00
 * @time 2019/4/13 14:59
 * @desc
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户账号
     */
    private String psw;

    public User(String username, char[] password) {
        this.name = username;
        this.psw = String.valueOf(password);
    }
}
