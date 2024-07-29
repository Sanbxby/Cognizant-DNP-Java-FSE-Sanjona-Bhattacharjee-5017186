

public class BuilderPatternExample {


    public static class Computer {
        
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return storage;
        }

        public String getGraphicsCard() {
            return graphicsCard;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage +
                   ", graphicsCard=" + graphicsCard + ", operatingSystem=" + operatingSystem + "]";
        }

        
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        
        Computer highEndComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setOperatingSystem("Windows 11")
                .build();
        System.out.println("High-End Computer: " + highEndComputer);
    }
}
