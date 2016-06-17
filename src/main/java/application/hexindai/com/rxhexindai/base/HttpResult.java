package application.hexindai.com.rxhexindai.base;

/**
 * Created by zhangruiyu on 16/5/19.
 */
public class HttpResult<T> {

    public int ret_code;
    public String ret_msg;
    public T data;

    @Override
    public String toString() {
        return "HttpResult{" +
                "ret_code=" + ret_code +
                ", ret_msg='" + ret_msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
