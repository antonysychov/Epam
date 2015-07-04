package Lessons.Lesson5.GC;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class GCTest {
    String[] f[], r;                            // �������� ��������

    public static void main(String[] args) {
        Byte[][]Byte = {{0}};
        System.out.println(Byte.class);
        String[] f[], r;                                //�������� ��������
        A pa = new A();                                 //Strong reference   !!!!!!

        Reference<A> sr = new SoftReference<A>(pa);     //Soft reference
        Reference<A> wr = new SoftReference<A>(pa);     //Weak reference
        ReferenceQueue<A> rq = new ReferenceQueue<A>();
        Reference<A> fr = new PhantomReference<A>(pa, rq);     //Phantom reference
        //System.out.println(fr.get()) + "phantom reference");
        pa=null;                                        //�������� ������ Soft Reference
                                                        //���� ���� ������ SoftReference �� GC ����� ������� ������
        A paa = sr.get();
        if (paa==null){
            paa = new A();
        }

        //�� ����� ����� �������� finalize (), GC ��� ������� ���
        //���������� ��� ����� ����� Unsafe
        //JNI ���������� ����������� native
        //��� ������������� native �� ������ ��������������������
        //���������� ��� ����� hashCode()

    }
}

class A {                                       //��� ������ �� ���������
    static A p;
    protected void finalize(){
        p = this;
    }
}
