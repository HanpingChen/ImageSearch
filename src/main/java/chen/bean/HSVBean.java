package chen.bean;

/**
 * Created by chen on 2017/3/2.
 */
public class HSVBean {

    private double H;
    private double S;
    private double V;

    public double getH() {
        return H;
    }

    public void setH(double h) {
        H = h;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    public double getV() {
        return V;
    }

    public void setV(double v) {
        V = v;
    }

    @Override
    public boolean equals(Object obj) {

        HSVBean bean = (HSVBean) obj;
        if (bean.getS()==S&&bean.getV()==V&&bean.getH()==H){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return (int) (H*H+S+V);
    }

    @Override
    public String toString() {

        return "H = "+H +" S = "+S+" V = "+V;
    }
}
