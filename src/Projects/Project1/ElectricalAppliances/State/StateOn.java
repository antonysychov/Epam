package Projects.Project1.ElectricalAppliances.State;


import Projects.Project1.ElectricalAppliances.ElectricAppliance;

public class StateOn extends State {
    private static State instance = new StateOn();

    public static State getInstance() {
        return instance;
    }

    @Override
    public void on(ElectricAppliance ea) {
        System.out.println(ea.getType() + " уже включен/а");
    }

    @Override
    public void off(ElectricAppliance ea) {
        ea.setState(StateOff.getInstance());
        ea.getWork().interrupt();
        System.out.println(ea.getType() + " выключен/а");
    }

    @Override
    public String toString() {
        return "включен/а";
    }
}