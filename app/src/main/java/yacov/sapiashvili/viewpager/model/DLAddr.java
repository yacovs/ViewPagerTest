package yacov.sapiashvili.viewpager.model;

import java.io.Serializable;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class DLAddr  implements Serializable {
    private String Addr;
    private String DAd;

    public DLAddr(String addr, String DAd) {
        Addr = addr;
        this.DAd = DAd;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getDAd() {
        return DAd;
    }

    public void setDAd(String DAd) {
        this.DAd = DAd;
    }
}
