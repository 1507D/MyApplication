package muhanxi.myapplication.event;

/**
 * Created by muhanxi on 17/10/10.
 */

public class MessageEvent {


    public boolean type ;


    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public MessageEvent(boolean type){
        this.type = type;
    }

}
