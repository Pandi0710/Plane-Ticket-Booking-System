import java.io.IOException;
import java.util.Scanner;
public class w2051725_Planemanagment {

    //Arrays to represent seating rows
    public static int[] row_A = new int[14];
    public static int[] row_B = new int[12];
    public static int[] row_C = new int[12];
    public static int[] row_D = new int[14];
    //Arrays to store tickets
    public static Ticket[] tickets= new Ticket[54];
    public static int ticketCount = 0;

//Method to initialize seating rows
    public static void main(String[] args) {
        for (int i = 1; i < row_A.length; i++) {
            row_A[i] = 0;
        }
        for (int i = 1; i < row_B.length; i++) {
            row_B[i] = 0;
        }
        for (int i = 1; i < row_C.length; i++) {
            row_C[i] = 0;
        }
        for (int i = 1; i < row_D.length; i++) {
            row_D[i] = 0;
        }
        //Method to display "Menu Options"
        while (true) {
            Scanner book = new Scanner(System.in);
            System.out.println("Welcome to Plane Management application");
            System.out.println("********************************************");
            System.out.println("*            MENU OPTIONS                  *");
            System.out.println("********************************************");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first availabe seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and local sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            System.out.println("********************************************");
            System.out.println("Please Select an option: ");
            String option = book.nextLine();

            try{
                //Check the user's selected options
                if (option.equals("1")) {
                    buy_seat();
                } else if (option.equals("2")) {
                    cancel_seat();
                } else if (option.equals("3")) {
                    find_first_available();
                } else if (option.equals("4")) {
                    show_seating_plan();
                } else if (option.equals("5")) {
                    print_tickets_information();
                } else if (option.equals("6")) {
                    search_ticket();
                } else if (option.equals("0")) {
                    break; //Exit the programme
                }else{
                    System.out.println("Invalid option");
                }
           //Handle IOExeption if any error occurs during execution
            }catch (IOException e){
                System.out.println("An error occurred" + e.getMessage());
            }


        }
    }
    //Method to get information about a person
    private static Person info(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name =sc.next();
        System.out.println("Enter the surname: ");
        String surname =sc.next();
        System.out.println("Enter the E-mail: ");
        String email =sc.next();
        return new Person(name,surname,email);  //Return a new Person object with the entered information
    }

    public static void buy_seat() throws IOException {

        Scanner book = new Scanner(System.in);
        System.out.println("Enter the row letter: ");
        String row = book.nextLine().toUpperCase();
        //Validate entered row letter
        while (!row.matches("[a-dA-D]+")){
            System.out.println("Select a letter between A-D");
            row =book.next();
        }
        //Validate entered seat number
        while(true) {
            System.out.println("Enter the seat number: ");

            while (!book.hasNextInt()){
                System.out.println("Integer Required");
                System.out.println("Enter the valid seat");
                book.next();

            }

            //Determine the price based on seat number
            int seat_num = book.nextInt();
            double price = 0.0;
            if (seat_num <= 5) {
                price = 200;
            } else if (seat_num >= 6 && seat_num <= 9) {
                price = 150;
            } else {
                price = 180;
            }

           //Process the seat booking based on entered row and seat number
            if (row.equals("A")) {
                if (seat_num >= 1 && seat_num <= 14) {
                    if (row_A[seat_num - 1] == 0) {
                        row_A[seat_num - 1] = 1;
                        Person person = info(); //Get information about the person booking seat
                        Ticket ticket = new Ticket(row, seat_num, price, person); //Create a new ticket
                        tickets[ticketCount] = ticket;  //Add the ticket to Array
                        ticketCount++;     //Increment ticket count
                        ticket.save();     //Save the ticket information
                        System.out.println("Seat is booked.");
                        break;

                    } else {
                        System.out.println("Seat is unavailable");
                    }

                }
                System.out.println("Out of range");
            }
            else if (row.equals("B")) {
                if (seat_num >= 1 && seat_num <= 12) {
                if (row_B[seat_num - 1] == 0) {
                    row_B[seat_num - 1] = 1;
                    Person person = info();
                    Ticket ticket = new Ticket(row, seat_num, price, person);
                    tickets[ticketCount] = ticket;
                    ticketCount++;
                    ticket.save();
                    System.out.println("Seat is booked.");
                    break;

                } else {
                    System.out.println("Seat is unavailable");
                }

            }
            System.out.println("Out of range");
        }
             if (row.equals("C")) {
                if (seat_num >= 1 && seat_num <= 12) {
                if (row_C[seat_num - 1] == 0) {
                    row_C[seat_num - 1] = 1;
                    Person person = info();
                    Ticket ticket = new Ticket(row, seat_num, price, person);
                    tickets[ticketCount] = ticket;
                    ticketCount++;
                    ticket.save();
                    System.out.println("Seat is booked.");
                    break;

                } else {
                    System.out.println("Seat is unavailable");
                }

            }
            System.out.println("Out of range");
        }
             if (row.equals("D")) {
                if (seat_num >= 1 && seat_num <= 14) {
                if (row_D[seat_num - 1] == 0) {
                    row_D[seat_num - 1] = 1;
                    Person person = info();
                    Ticket ticket = new Ticket(row, seat_num, price, person);
                    tickets[ticketCount] = ticket;
                    ticketCount++;
                    ticket.save();
                    System.out.println("Seat is booked.");
                    break;

                } else {
                    System.out.println("Seat is unavailable");
                }

            }
            System.out.println("Out of range");
        }
        }

    }

    public static void cancel_seat() {
        System.out.println("***Cancel Seat***");
        Scanner book = new Scanner(System.in);
        System.out.println("Enter row letter: ");
        char row_letter = book.nextLine().toUpperCase().charAt(0); //Read the row letter and convert it to the uppercase
        if (row_letter < 'A' || row_letter > 'D') {   //Check if the entered row letter id valid or invalid
            System.out.println("Invalid row letter ");
            return;
        }
        //Process of the seat cancel based on the entered row letter
        if (row_letter == 'A') {
            System.out.println("Enter a seat number to cancel: ");
            int input = book.nextInt();
            //Check the entered seat number is booked, then cancel the process
            while (row_A[input - 1] != 0) {
                row_A[input - 1] = 0;  //Mark the seat is canceled by setting and create its value to 0
                System.out.println("Seat is canceled");
            }
        } else if (row_letter == 'B') {
            System.out.println("Enter a seat number to cancel: ");
            int input = book.nextInt();
            while (row_B[input - 1] != 0) {
                row_B[input - 1] = 0;
                System.out.println("Seat is canceled");
            }
        } else if (row_letter == 'C') {
            System.out.println("Enter a seat number to cancel: ");
            int input = book.nextInt();
            while (row_C[input - 1] != 0) {
                row_C[input - 1] = 0;
                System.out.println("Seat is canceled");
            }
        } else {
            System.out.println("Enter a seat number to cancel: ");
            int input = book.nextInt();
            while (row_D[input - 1] != 0) {
                row_D[input - 1] = 0;
                System.out.println("Seat is canceled");
            }
        }
    }

    public static void find_first_available() {
        boolean found = false;  //Indicate if a free seat is found
        while (true) {
            for (int i = 0; i < row_A.length; i++) {
                if (row_A[i] == 0) { //if seat is availble then mared it as 0
                    System.out.println("Free seat is available in row A " + (i + 1) + " seat");
                    found = true; // Set found flag to true
                    break;
                }
            }
            //if the free seat is found in row the exit the loop
            if (found){
                break;
            }

            for (int i = 0; i < row_B.length; i++) {
                if (row_B[i] == 0) {
                    System.out.println("Free seat is available in row B " + (i + 1) + " seat");
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
            for (int i = 0; i < row_C.length; i++) {
                if (row_C[i] == 0) {
                    System.out.println("Free seat is available in row C " + (i + 1) + " seat");
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
            for (int i = 0; i < row_D.length; i++) {
                if (row_D[i] == 0) {
                    System.out.println("Free seat is available in row D " + (i + 1) + " seat");
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }

        }

    }

    public static void show_seating_plan() {
        System.out.println("Seating Plan");
        System.out.print("A: ");
        for (int i = 0; i < row_A.length; i++) {
            if (row_A[i] == 0) {
                System.out.print("O "); // If seat is available marked it as "O"
            } else {
                System.out.print("X ");  //If seat is booked marked it as "X"
            }
        }
        System.out.println();  //Moved on to the next line
        System.out.print("B: ");
        for (int i = 0; i < row_B.length; i++) {
            if (row_B[i] == 0) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
        System.out.print("C: ");
        for (int i = 0; i < row_C.length; i++) {
            if (row_C[i] == 0) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
        System.out.print("D: ");
        for (int i = 0; i < row_D.length; i++) {
            if (row_D[i] == 0) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();

    }

    public static void print_tickets_information() {
        System.out.println("Total amount of tickets ");
        double Total_price = 0.0; //Set variable to store the total price of all tickets
        //Ticket in the tickets array
        for (Ticket ticket : tickets) {
            if (ticket != null) { //Check if the current ticket is not null
                ticket.printInfo(); //Print information about the current ticket
                Total_price += ticket.getPrice();   //Add the price of the current ticket

            }
        }
        //Print total price of all tickets
        System.out.println("Total tickets price: £" + Total_price);
    }

    public static void search_ticket() {
        Scanner book = new Scanner(System.in);  //Make a Scanner object to read user input
        System.out.println("Enter the row letter: ");
        String row = book.nextLine().toUpperCase(); //Read row letter and convert it to the uppercase

        System.out.println("Enter the seat number: ");
        int seat_num = book.nextInt(); //Read the seat number
        //Check if the entered row and seat number is valid
        if (row.equals("A") && (seat_num >= 1 && seat_num <= 14)) {
            System.out.println("Seat is found");
        } else if (row.equals("B") && (seat_num >= 1 && seat_num <= 12)) {
            System.out.println("Seat is found");

        }else if (row.equals("C") && (seat_num >= 1 && seat_num <= 12)) {
            System.out.println("Seat is found");

        } else if (row.equals("D") && (seat_num >= 1 && seat_num <= 14)) {
            System.out.println("Seat is found");

        } else {
            System.out.println("Invalid input. Please try again");
        }
        boolean seat_found = false;  //Make boolean variable if the seat is found
        //Iterate each ticket in tickets array
        for (Ticket ticket : tickets) {
            //Check current ticket is not null match entered row and seat number
            if (ticket != null && ticket.getRow().equals(row) && ticket.getSeat() == seat_num) {
                seat_found = true;
                ticket.printInfo(); //Print information about found ticket
                break; //Exit the loop when the ticket has been found
            }
        }
        //Check if the seat was not found
        if (!seat_found) {
            System.out.println("This seat is available.");
        }


    }
}
