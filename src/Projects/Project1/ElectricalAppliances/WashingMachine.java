package Projects.Project1.ElectricalAppliances;

public class WashingMachine extends ElectricAppliance {
    public WashingMachine(float electricPower) {
        super(electricPower);
        type = ApplianceType.WASHING_MACHINE;
    }
}
