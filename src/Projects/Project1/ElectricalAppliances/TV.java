package Projects.Project1.ElectricalAppliances;

public class TV extends ElectricAppliance {
    public TV(float electricPower) {
        super(electricPower);
        type = ApplianceType.TV;
    }
}
