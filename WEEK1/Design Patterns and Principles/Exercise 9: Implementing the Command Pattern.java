interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class Light {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.buttonPressed();

        remote.setCommand(lightOff);
        remote.buttonPressed();
    }
}
