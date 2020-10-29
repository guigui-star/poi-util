/**
 * @author guigui
 * @create 2020-10-28 17:43
 */
public class test1 {
    private  String name;
    private String addar;
    private String ii;

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

    public String getIi() {
        return ii;
    }

    public void setIi(String ii) {
        this.ii = ii;
    }

    @Override
    public String toString() {
        return "test1{" +
                "name='" + name + '\'' +
                ", addar='" + addar + '\'' +
                ", ii='" + ii + '\'' +
                '}';
    }
}
