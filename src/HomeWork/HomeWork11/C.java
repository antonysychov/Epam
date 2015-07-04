package HomeWork.HomeWork11;

import HomeWork.HomeWork11.DI.DI;
import HomeWork.HomeWork11.DI.Factory;

public class C {
    A pa;

    {
        pa = Factory.injectDependency(C.class, "pa", DI.configFile);
    }

    public C() {
        System.out.println("Object of C class has been created");
    }
}
