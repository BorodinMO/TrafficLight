package homework1;

import java.util.Scanner;

public class TrafficLightRunner implements Runnable {
    TrafficLight trafficLight;
    Scanner scanner;

    public TrafficLightRunner(TrafficLight trafficLight, Scanner scanner) {
        this.trafficLight = trafficLight;
        this.scanner = scanner;
    }

    public TrafficLightRunner(TrafficLight trafficLight) {
        this(trafficLight, new Scanner(System.in));
    }


    @Override
    public void run() {
        System.out.println("Welcome to TrafficLight.");
        System.out.println("To exit type 'exit'.");

        while (true) {
            System.out.println("Enter minute:");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")){
                return;
            }
            int time;

            try {
                time = Integer.parseInt(userInput);
                if (time < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Wrong imput. Please try again. To exit type 'exit'.");
                continue;
            }
            try {
                trafficLight.runFor(time);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Whoops! Looks like something went wrong. Let's try again.");
                continue;
            }
            System.out.println("Light at " + time + " minute is " + trafficLight.getColour());
        }

    }
}