package socketserver;

import java.io.Serializable;

/**
 * Created by Sidus on 11/18/2014.
 */
public class Communication implements Serializable {
    private String action;
    private Object data;

    public Communication(String action, Object data) {
        this.action = action;
        this.data = data;
    }

    public Communication() {

    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
