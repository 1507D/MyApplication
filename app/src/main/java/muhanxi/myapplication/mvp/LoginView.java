package muhanxi.myapplication.mvp;

/**
 * Created by muhanxi on 17/9/28.
 */

public interface LoginView {


    public void usernameNull();
    public void passwordNull();

    public void loginSuccess(String result);

}
