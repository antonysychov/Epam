package Projects.Project1.ElectricalAppliances;

public enum ApplianceType {
    WASHING_MACHINE {
        @Override
        public String toString() {
            return "Стиральная машина";
        }
    }, TV {
        @Override
        public String toString() {
            return "Телевизор";
        }
    }, FRIDGE {
        @Override
        public String toString() {
            return "Холодильник";
        }
    }, FAN {
        @Override
        public String toString() {
            return "Вентилятор";
        }
    }, HEATER {
        @Override
        public String toString() {
            return "Обогреватель";
        }
    }, WATER_BOILER {
        @Override
        public String toString() {
            return "Бойлер";
        }
    }, COMPUTER {
        @Override
        public String toString() {
            return "Компъютер";
        }
    }, MICROWAVE {
        @Override
        public String toString() {
            return "Микроволновая печь";
        }
    }
}
