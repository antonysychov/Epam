package Lessons.Lesson5.GC;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class GCTest {
    String[] f[], r;                            // обратить внимание

    public static void main(String[] args) {
        Byte[][]Byte = {{0}};
        System.out.println(Byte.class);
        String[] f[], r;                                //обратить внимание
        A pa = new A();                                 //Strong reference   !!!!!!

        Reference<A> sr = new SoftReference<A>(pa);     //Soft reference
        Reference<A> wr = new SoftReference<A>(pa);     //Weak reference
        ReferenceQueue<A> rq = new ReferenceQueue<A>();
        Reference<A> fr = new PhantomReference<A>(pa, rq);     //Phantom reference
        //System.out.println(fr.get()) + "phantom reference");
        pa=null;                                        //осталась только Soft Reference
                                                        //если есть только SoftReference то GC может удалить объект
        A paa = sr.get();
        if (paa==null){
            paa = new A();
        }

        //не стоит прямо вызывать finalize (), GC сам вызовет его
        //посмотреть что такое класс Unsafe
        //JNI посмотреть модификатор native
        //при использовании native мы теряем кроссплатформенность
        //посмотреть что такое hashCode()

    }
}

class A {                                       //так объект не удалиться
    static A p;
    protected void finalize(){
        p = this;
    }
}
