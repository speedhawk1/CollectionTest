package algorithmsAndDS;

/**
 * Created by Administrator on 2018/1/13.
 */
public class HashTables<Key,Value> {
    private final int M = 31;
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M ;
    }

    public int hashcode(){  // hashcode方法作用：将键转化为32位整形值；
        return 0;
    }
}
