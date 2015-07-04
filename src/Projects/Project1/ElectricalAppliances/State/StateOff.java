package Projects.Project1.ElectricalAppliances.State;

import Projects.Project1.ElectricalAppliances.ElectricAppliance;

public class StateOff extends State {
    private static State instance = new StateOff();

    public static State getInstance() {
        return instance;
    }

    @Override
    public void on(ElectricAppliance ea) {
        ea.setState(StateOn.getInstance());
        synchronized (ea.getWork()) {
            ea.getWork().notify();
        }
        System.out.println(ea.getType() + " �������/�");
    }

    @Override
    public void off(ElectricAppliance ea) {
        System.out.println(ea.getType() + " ��� ��������/�");
    }

    @Override
    public String toString() {
        return "��������/�";
    }
}