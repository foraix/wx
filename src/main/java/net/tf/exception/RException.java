package net.tf.exception;


import java.util.Set;

/**
 * <h3>自定义异常</h3>
 *
 * @author chenshun
 * @version 1.0.0
 */

public class RException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;
    private Set<String> data;

    public RException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }

    public RException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RException(String msg, Set<String> data) {
        super(msg);
        this.msg = msg;
        this.data = data;
    }

    public RException(String msg, int code, Set<String> data) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public RException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
