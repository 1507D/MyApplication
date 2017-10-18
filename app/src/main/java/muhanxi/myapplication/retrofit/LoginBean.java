package muhanxi.myapplication.retrofit;

/**
 * Created by muhanxi on 17/10/11.
 */

public class LoginBean {




    /**
     * ret_code : 0
     * ret_msg : 登录失败，清先注册
     */

    private int ret_code;
    private String ret_msg;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }
}
