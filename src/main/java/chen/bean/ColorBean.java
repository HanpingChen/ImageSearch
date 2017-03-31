package chen.bean;

import chen.common.Util;

/**
 * Created by chen on 17/2/24.
 */
public class ColorBean {

    private double R;
    private double B;
    private double G;

    public ColorBean() {
        R = 0;
        B = 0;
        G = 0;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getG() {
        return G;
    }

    public void setG(double g) {
        G = g;
    }

    public HSVBean castToHsv(){
        HSVBean hsvBean = new HSVBean();

        double v = 0;
        //计算v的值
        //v = (R + B +G)/Math.pow(3,1/2);
        v = Math.max(Math.max(R,G),B);
        //计算H的值
        double s = 0;
        //s = 1 - (Math.pow(3,1/2)/v)* Util.min(R,G,B);
        if (v == 0){
            s = 0;
        }else {
            s = (v - Util.min(R,G,B))/v;
        }
        double h = 0;

        double content = v - Util.min(R,G,B);

        if (v == R){
            h = 60*(G-B)/content;
        }
        else if (v == G){
            h = 120 + 60*(B-R)/content;
        }
        else {
            h = 240 + 60*(R-G)/content;
        }
        hsvBean.setH(h);
        hsvBean.setS(s);
        hsvBean.setV(v);
        return hsvBean;
    }


}
