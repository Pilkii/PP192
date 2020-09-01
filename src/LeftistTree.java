import java.util.PriorityQueue;

public class LeftistTree<T extends Comparable> extends PriorityQueue {
    LTree<T > Wurzel;

    public boolean insert (T e){
        LTree<T> Tree =new LTree<T>(e);
        Tree.Rang=0;
        Wurzel=lmerge(Wurzel,Tree);
        return true;
    }

    public void merge(PriorityQueue<T> q){
        for (T e:q){
            insert(e);
        }
    }

    public T deleteMin(){
        T el=Wurzel.elem;
        if (el==null) throw new IllegalStateException();
        LeftistTree<T> RTree =new LeftistTree<T>();
        RTree.Wurzel=Wurzel.RKind;
        Wurzel=Wurzel.LKind;
        merge(RTree);
        return el;
    }

    public T getMin(){
        T el=Wurzel.elem;
        if (el==null) throw new IllegalStateException();
        return el;
    }

    public boolean IsEmpty(){
        if (Wurzel==null) return true;
        else return false;
    }
    public LTree lmerge(LTree l,LTree r){
        if (l.elem==null) return r;
        else if (r.elem==null) return l;
        else if (l.elem.compareTo(r.elem)<=0){
            l.Rang=1+Math.min(l.RKind.Rang,r.Rang);
            l.RKind=lmerge(l.RKind,r);

            return l;
        }else {
            r.Rang = 1 + Math.min(r.RKind.Rang, l.Rang);
            r.RKind = lmerge(r.RKind, l);
            return r;
        }
    }
    class LTree<T extends Comparable>{
        int Rang;
        LTree LKind,RKind;
        T elem;

        public LTree(T elem){
            this.elem=elem;
        }

    }
}


