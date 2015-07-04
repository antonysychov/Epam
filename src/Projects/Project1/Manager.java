package Projects.Project1;

import Projects.Project1.ElectricalAppliances.*;
import Projects.Project1.ElectricalAppliances.State.StateOn;
import Projects.Project1.Utils.StringFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Manager {
    private static List<ElectricAppliance> appliances = new LinkedList<ElectricAppliance>() {{
        add(new WashingMachine(1900));
        add(new Computer(400));
        add(new Fan(500));
        add(new Fridge(600));
        add(new Heater(1200));
        add(new WashingMachine(2000));
        add(new WaterBoiler(2000));
        add(new Microwave(1600));
    }};

    public static void main(String[] args) throws InterruptedException, IOException {
        showConsoleMenu();
    }

    private static void showConsoleMenu() throws IOException, InterruptedException {
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("Управление бытовыми электроприборами");
            System.out.println("1. Включить/выключить");
            System.out.println("2. Вывести текущие параметры прибора");
            System.out.println("3. Отсортировать по мощности");
            System.out.println("4. Найти прибор по диапазону мощности");
            System.out.println("5. Мониторинг всех электроприборов");
            System.out.println("6. Выйти из программы");
            System.out.println("------------------------------------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice;
            try {
                choice = Integer.valueOf(reader.readLine());
            } catch (Exception e) {
                System.out.println("неверный ввод, введите целое число из диапазона ");
                continue;
            }
            switch (choice) {
                case 1:
                    ElectricAppliance ea = chooseAppliance();
                    switchAppliance(ea);
                    Thread.sleep(2000);
                    continue;
                case 2:
                    ea = chooseAppliance();
                    showAppliance(ea);
                    Thread.sleep(2000);
                    continue;
                case 3:
                    sortAppliances(appliances);
                    showAppliances(appliances);
                    Thread.sleep(2000);
                    continue;
                case 4:
                    List<ElectricAppliance> list = findSpecificAppliance();
                    showAppliances(list);
                    Thread.sleep(2000);
                    continue;
                case 5:
                    monitorAppliances(appliances);
                    continue;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор, выберите из данного диапазона ");
            }
        }
    }

    private static void monitorAppliances(List<ElectricAppliance> appliances) throws IOException {
        int x = 3; // wait 3 seconds at most
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean stop = false;
        while (!stop) {
            showAppliances(appliances);
            System.out.println("Для возврата нажмите Enter");
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < x * 1000
                    && !in.ready()) {
            }

            if (in.ready()) {
                in.readLine();
                stop = true;
            }
        }
    }

    private static ElectricAppliance chooseAppliance() throws IOException {
        System.out.println("Выберить прибор :");
        while (true) {
            int i = 0;
            for (ElectricAppliance ea : appliances) {
                System.out.println(++i + ". " + ea.getType() + " " + "(" + ea.getState() + ")");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.valueOf(reader.readLine());
            if (choice >= appliances.size()) {
                System.out.println("Прибора с таким номером нет, выберите прибор из предлагаемого диапазона");
            } else return appliances.get(choice - 1);
        }
    }

    private static void switchAppliance(ElectricAppliance ea) throws IOException {
        if (ea.getState().getClass() == StateOn.class) {
            ea.turnOff();
            ea.plugOut();
        } else {
            ea.plugIn(220);
            ea.turnOn();
        }
    }

    private static void showAppliance(ElectricAppliance e) {

        String cc = String.valueOf(e.getCurrentConsumption());
        String cp = String.valueOf(e.getConsumedPower());
        String ep = String.valueOf(e.getElectricPower());

        String[] array = {
                StringFormat.fitToSpecificLength(e.getType().toString(), 25),
                StringFormat.fitToSpecificLength(ep, 10),
                StringFormat.fitToSpecificLength(cp, 10).substring(0, 7),
                StringFormat.fitToSpecificLength(cc, 10).substring(0, 7)};

        System.out.println(array[0] + ": мощность - " + array[1] + ", Вт | потребленная мощность - " + array[2]
                + ", Вт*ч | текущее потребление - " + array[3] + ", А");
    }

    private static void showAppliances(List<ElectricAppliance> appliances) {
        for (ElectricAppliance e : appliances) {
            showAppliance(e);
        }
    }

    private static List<ElectricAppliance> findSpecificAppliance() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите нижний предел мощности : ");
        Float min = Float.valueOf(reader.readLine());
        System.out.println("Введите верхний предел мощности : ");
        Float max = Float.valueOf(reader.readLine());
        List<ElectricAppliance> list = new LinkedList<>();
        for (ElectricAppliance e : appliances) {
            if (e.getElectricPower() > min && e.getElectricPower() < max) {
                list.add(e);
            }
        }
        return list;
    }

    private static void sortAppliances(List<? extends Comparable> list) {
        Collections.sort(list);
    }

}
