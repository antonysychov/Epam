package Projects.Project1.ElectricalAppliances;

public class Computer extends ElectricAppliance {
    public Computer(float electricPower) {
        super(electricPower);
        type = ApplianceType.COMPUTER;
    }
}
