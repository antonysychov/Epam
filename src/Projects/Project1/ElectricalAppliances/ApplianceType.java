package Projects.Project1.ElectricalAppliances;

public enum ApplianceType {
    WASHING_MACHINE {
        @Override
        public String toString() {
            return "���������� ������";
        }
    }, TV {
        @Override
        public String toString() {
            return "���������";
        }
    }, FRIDGE {
        @Override
        public String toString() {
            return "�����������";
        }
    }, FAN {
        @Override
        public String toString() {
            return "����������";
        }
    }, HEATER {
        @Override
        public String toString() {
            return "������������";
        }
    }, WATER_BOILER {
        @Override
        public String toString() {
            return "������";
        }
    }, COMPUTER {
        @Override
        public String toString() {
            return "���������";
        }
    }, MICROWAVE {
        @Override
        public String toString() {
            return "������������� ����";
        }
    }
}
