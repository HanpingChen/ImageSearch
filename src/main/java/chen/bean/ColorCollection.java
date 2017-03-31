package chen.bean;

import javax.naming.ldap.PagedResultsControl;

/**
 * Created by chen on 2017/3/3.
 * 量化的颜色
 */
public class ColorCollection {

    private int part;

    private int H;

    public ColorCollection(int part, int h) {
        this.part = part;
        H = h;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    @Override
    public String toString() {
        return "part = "+part+"h = "+H;
    }

    @Override
    public boolean equals(Object obj) {
        ColorCollection colorCollection = (ColorCollection) obj;

        if (colorCollection.getPart() == part&&colorCollection.getH()==H){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return H*30+ part;
    }
}
