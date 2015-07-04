package Projects.Project1.ElectricalAppliances;

public class Heater extends ElectricAppliance {
    public Heater(float electricPower) {
        super(electricPower);
        type = ApplianceType.HEATER;
    }
}
