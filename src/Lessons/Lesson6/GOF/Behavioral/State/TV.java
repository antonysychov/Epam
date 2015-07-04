package Lessons.Lesson6.GOF.Behavioral.State;

public class TV {
    State tvState;

    public TV() {
        tvState = new StateOff();
    }

    public void switchOn() {
        tvState.on(this);
    }

    public void switchOff() {
        tvState.off(this);
    }

    public void changeChannel() {
        tvState.change();
    }

    abstract class State {
        public abstract void on(TV tv);

        public abstract void off(TV tv);

        public abstract void change();
    }

    class StateOn extends State {
        @Override
        public void on(TV tv) {
            System.out.println("TV is already switched on");
        }

        @Override
        public void off(TV tv) {
            tv.tvState = new StateOff();
            System.out.println("we switch off TV");
        }

        @Override
        public void change() {
            System.out.println("we change channel");

        }
    }

    class StateOff extends State {
        @Override
        public void on(TV tv) {
            tv.tvState = new StateOn();
            System.out.println("we switch on TV");
        }

        @Override
        public void off(TV tv) {

            System.out.println("TV is already switched off");
        }

        @Override
        public void change() {
            System.out.println("we cannot channel");

        }
    }

}
