package Projects.Project1.ElectricalAppliances;

public class Fan extends ElectricAppliance{
    public Fan(float electricPower) {
        super(electricPower);
        type = ApplianceType.FAN;
    }
}
