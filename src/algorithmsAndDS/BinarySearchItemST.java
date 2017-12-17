package algorithmsAndDS;
import edu.princeton.cs.algs4.Merge;

/**
 * Created by Administrator on 2017/12/10.
 */
public class BinarySearchItemST {

    class Item<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Item>{
        K k;
        V v;

        public Item(K k,V v){this.k = k;this.v = v;}

        @Override
        public int compareTo(Item o) {
            if(this.k.compareTo((K)o.k) < 0){
                return -1;
            }else if(this.k.compareTo((K)o.k) > 0){
                return 1;
            }else{return 0;}
        }


    }

    private Item[] items;

    public BinarySearchItemST(Item[] items){
        Merge.sort(items);
        this.items = items;
    }

}
