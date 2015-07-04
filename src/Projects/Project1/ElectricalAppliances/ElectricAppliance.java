package Projects.Project1.ElectricalAppliances;

import Projects.Project1.ElectricalAppliances.State.State;
import Projects.Project1.ElectricalAppliances.State.StateOff;
import Projects.Project1.ElectricalAppliances.State.StateOn;

import java.util.concurrent.TimeUnit;

public abstract class ElectricAppliance implements Comparable<ElectricAppliance> {

    protected ApplianceType type;

    protected float electricPower;
    protected float consumedPower;

    protected State state = new StateOff();
    protected int inputVoltage;
    protected final Thread work = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (work) {
                while (true)
                    if (state.getClass() == StateOn.class) {
                        consumedPower += ((electricPower / 220) * (inputVoltage) / (3600)) * 5;     // consumption within 5 seconds
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                        }
                    } else {
                        try {
                            work.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    });

    @Override
    public int compareTo(ElectricAppliance o) {
        return (int) (this.electricPower * 100 - o.electricPower * 100);
    }

    public ElectricAppliance(float electricPower) {
        this.electricPower = electricPower;
        work.start();
    }

    public void turnOn() {
        state.on(this);
    }

    public void turnOff() {
        state.off(this);
    }

    public void plugIn(int voltage) {
        inputVoltage = voltage;
    }

    public void plugOut() {
        inputVoltage = 0;
    }

    public float getCurrentConsumption() {
        return inputVoltage == 0 ? 0 : (electricPower / inputVoltage);
    }

    public float getConsumedPower() {
        return consumedPower;
    }

    public float getElectricPower() {
        return electricPower;
    }

    public int getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(int inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ApplianceType getType() {
        return type;
    }

    public void setType(ApplianceType type) {
        this.type = type;
    }

    public Thread getWork() {
        return work;
    }
}