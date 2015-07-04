package Projects.Project1.ElectricalAppliances;

public class Fridge extends ElectricAppliance {
    public Fridge(float electricPower) {
        super(electricPower);
        type = ApplianceType.FRIDGE;
    }
}
