package Projects.Project1.ElectricalAppliances.State;

import Projects.Project1.ElectricalAppliances.ElectricAppliance;

abstract public class State {
    public abstract void on(ElectricAppliance ea);

    public abstract void off(ElectricAppliance ea);
}





