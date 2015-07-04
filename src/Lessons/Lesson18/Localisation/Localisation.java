package Lessons.Lesson18.Localisation;

import java.util.Locale;

public class Localisation {
    //Локаль - страна, язык, м.б. ОС
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        Locale loc = Locale.CANADA;
        Locale loc1 = new Locale("ua", "UA");


    }
}
