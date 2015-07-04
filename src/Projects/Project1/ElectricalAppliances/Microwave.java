package Projects.Project1.ElectricalAppliances;

public class Microwave extends ElectricAppliance {
    public Microwave(float electricPower) {
        super(electricPower);
        type = ApplianceType.MICROWAVE;
    }
}
