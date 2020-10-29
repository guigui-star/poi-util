

import java.io.Serializable;

/**
 * @author guigui
 * @create 2020-10-27 17:09
 */

public class ExeclTest implements Serializable {
    private String name;
    private String addar;

    public ExeclTest(String name, String addar) {
        this.name = name;
        this.addar = addar;
    }

    public ExeclTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddar() {
        return addar;
    }

    public void setAddar(String addar) {
        this.addar = addar;
    }

    @Override
    public String toString() {
        return "ExeclTest{" +
                "name='" + name + '\'' +
                ", addar='" + addar + '\'' +
                '}';
    }
}
