package org.project.Official_ajeet;

import java.time.LocalTime;
import java.util.Scanner;

public class SmartBusCardSystem {
    public static void main(String[] args) {

        //initialize balance with 10 by default
        BusCard busCard = new BusCard(10);

        Scanner scanner = new Scanner(System.in);

        while(true){

        System.out.println("------------------------------------");
        System.out.println("Press 1 to travel");
        System.out.println("Press 2 for balance details");
        System.out.println("Press -1 to exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1: {
                System.out.print("Enter start stop (1-15): ");
                int startStop = scanner.nextInt();

                BusSystem.swipeIn(busCard);

                System.out.print("Enter end stop: ");
                int endStop = scanner.nextInt();

                BusSystem.swipeOut(busCard, startStop, endStop);
                break;
            }
            case 2:{
                System.out.println("------------------------------------");
                System.out.println("Press 1 to check balance");
                System.out.println("Press 2 to add balance");
                System.out.print("Enter your choice: ");
                int choice2 = scanner.nextInt();
                switch (choice2){
                    case 1:{
                        System.out.println("Your current balance is: "+busCard.getBalance());
                        break;
                    }
                    case 2:{
                        System.out.print("Enter the balance: ");
                        double balance = scanner.nextDouble();
                        double addBalance = balance+ busCard.getBalance();
                        System.out.println("Balance added successfully! Now current balance is: "+addBalance);

                        break;
                    }
                    default:
                        System.out.println("Make a valid choice!");
                }
                break;
            }

            case -1:
                System.out.println("Exiting the program...");
                break;

            default:
                System.out.println("Make a valid choice!!");
        }
            if(choice == -1)break;
        }
        scanner.close();

    }

}

 class BusCard{
    double balance;

    //constructor to initialize balance
    public BusCard(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public double addBalance(double balance){
        return this.balance+=balance;
    }

    //minimum balance in the card should be 10 rupees
    public boolean hasMinimumBalance(){
        return balance >= 10;
    }

    public boolean canAffordFare(double fare){
            return balance >= fare;
    }

    public boolean deductFare(double fare){
        if(balance >= fare){
            balance -= fare;
        }else return false;

        return true;
    }
}

class BusSystem{
    private static final double DAY_FARE = 0.80;
    private static final double NIGHT_FARE = 0.60;
    private static int MIN_STOP = 1;
    private static int MAX_STOP = 15;

    //to check for weekends - we will give discount on weekends
    public static boolean isWeekend(){
        String currentDay = java.time.LocalDate.now().getDayOfWeek().toString();
        return currentDay.equals("SATURDAY") || currentDay.equals("SUNDAY");
    }

    //to check its night time or day time
    public static boolean isNightTime(){
        LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(LocalTime.of(8,0))||
                currentTime.isBefore(LocalTime.of(6,0));
    }

    public static double calculateFare(int startStop, int endStop){
        //check for valid stops
        if(startStop < MIN_STOP || endStop > MAX_STOP || startStop >= endStop){
            System.out.println("Invalid stops! Choose between "+MIN_STOP+" and "+MAX_STOP);
            return -1;
        }

        //if entered valid stops then calculate fare
        int actualStops = endStop - startStop;
        double farePerStop = isNightTime() ? NIGHT_FARE : DAY_FARE;
        double actualFare = 0.0;

        if(actualStops > 5){
            // give 10 % discount beyond travelling more than 5 stops
            actualFare = (5*farePerStop) + ((actualStops - 5) * farePerStop*0.9);
        }else{
            actualFare = actualStops * farePerStop;
        }

        //check for discount
        if(isWeekend()){
            actualFare *= 0.80;// give discount of 20%
        }

        return actualFare;
    }

    public static void swipeIn(BusCard busCard){
        if(!busCard.hasMinimumBalance()){
            System.out.println("Insufficient balance! Please recharge before swiping in.");
        }else{
            System.out.println("Swipe-in successful. You may board the bus.");
        }
    }

    public static void swipeOut(BusCard busCard, int startStop, int endStop){
        double fare = calculateFare(startStop, endStop);
        if(fare == -1)return;

        if(!busCard.canAffordFare(fare)){
            System.out.println("Insufficient balance to swipe out. Please recharge to exit.");
            return;
        }

        if(busCard.deductFare(fare)){
            System.out.println("Swipe-out successful! Journey from stop " + startStop + " to stop " + endStop);
            System.out.println("Fare deducted: ₹" + fare);
            System.out.println("Remaining Balance: ₹" + busCard.getBalance());
        }
    }
}


