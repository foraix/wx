package net.tf.utils;

import net.tf.exception.RException;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>返回数据</h3>
 *
 * <p>简化的使用方法</p>
 *
 * @author chenshun, cox
 * @version 1.0.1
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private R() {
        put("code", 200);
        put("msg", "success");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R error(RException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("message", e.getMsg());
        if (e.getData() != null) {
            r.data(e.getData());
        }
        return r;
    }

    @NotNull
    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public R data(Object value) {
        super.put("data", value);
        return this;
    }

    public Object data() {
        return super.get("data");
    }
}
