package com.company;

import java.io.*;



public class Main {
    static int buyTicket = 0;
    static int ticketPrice = 0;
    static int totalIncome = 0;
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of rows:");
        int number = stringParseToInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = stringParseToInt();
        String[][] array = new String[number + 1][seats + 1];
        createToMatrix(array, number, seats);
        while (true) {
            toShowMenu();
            int menuNumber = stringParseToInt();
            if (menuNumber == 1) {
                rezArrays(array, number, seats);
                System.out.println();
            } else if (menuNumber == 2) {
                buyTicket(number, seats, array);
            } else if (menuNumber == 3){
                statistics(number, seats);
            } else if (menuNumber == 0) {
                break;
            }
        }
    }
    public static void buyTicket(int number, int seats, String[][] array) throws IOException {
        boolean fl = true;
        while (fl) {
            System.out.println("Enter a row number:");
            int number1 = stringParseToInt();
            System.out.println("Enter a seat number in that row:");
            int number2 = stringParseToInt();
            if (number1 > number || number2 > seats || number1 <= 0 || number2 <= 0) {
                System.out.println("Wrong input!");
            } else if (array[number1][number2] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                fl = false;
                ++buyTicket;
                array[number1][number2] = "B";
                setTicketPrice(number, seats, number1);
                System.out.println();
            }
        }
    }

    public static int setTotalIncome(int number, int seats) {
        if (number * seats <= 60) {
            totalIncome = number * seats * 10;
        } else {
            totalIncome = number / 2 * seats * 10 + (number - number / 2) * seats * 8;
        }
        return totalIncome;
    }

    public static void statistics(int number, int seats){
        System.out.println(String.format("Number of purchased tickets: %d", buyTicket));
        System.out.println(String.format("Percentage: %.2f%c" ,  100 * (float)buyTicket / (number * seats), '%'));
        System.out.println(String.format("Current income: $%d", ticketPrice));
        System.out.println(String.format("Total income: $%d", setTotalIncome(number, seats)));
    }

    public static void createToMatrix(String[][] array, int number, int seats) {
        for (int i = 1; i < seats + 1; ++i) {
            array[0][i] = Integer.toString(i);
        }
        for (int i = 1; i < number + 1; ++i) {
            array[i][0] = Integer.toString(i);
            for (int j = 1; j < seats + 1; ++j) {
                array[i][j] = "S";
            }
        }
    }

    public static void toShowMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static int stringParseToInt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        return Integer.parseInt(name);
    }

    public static void setTicketPrice(int number, int seats, int number1) {
        if (number * seats <= 60) {
            System.out.print("Ticket price: ");
            System.out.println("$" + 10);
            ticketPrice += 10;
            totalIncome = number * seats * 10;
        } else {
            totalIncome = number / 2 * seats * 10 + (number - number / 2) * seats * 8;
            if ( number / 2 >= number1 ) {
                System.out.print("Ticket price: ");
                System.out.println("$" + 10);
                ticketPrice += 10;
            } else {
                System.out.print("Ticket price: ");
                System.out.println("$" + 8);
                ticketPrice += 8;
            }
        }
    }

    public static void rezArrays(String[][] array, int number, int seats) {
        System.out.println("Cinema:");
        for (int i = 0; i < number + 1; ++i) {
            for (int j = 0; j < seats + 1; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

