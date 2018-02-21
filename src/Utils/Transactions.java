package Utils;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/13.
 */
public class Transactions {
    private String who;
    private Date time;
    private double amount;

    public int hashcode(){
        int hash = 17;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + time.hashCode();
        hash = 31 * hash + ((Double)amount).hashCode();
        return hash;
    }
}
