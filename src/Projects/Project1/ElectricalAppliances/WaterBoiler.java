package Projects.Project1.ElectricalAppliances;

public class WaterBoiler extends ElectricAppliance{
    public WaterBoiler(float electricPower) {
        super(electricPower);
        type = ApplianceType.WATER_BOILER;
    }
}
