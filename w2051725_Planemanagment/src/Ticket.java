import java.io.FileWriter;
import java.io.IOException;
import java.io.Serial;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;
    public Ticket(String row,int seat,double price,Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public Ticket(String row, int seatNum, double price) {
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //Prints the ticket details
    public void printInfo(){
        System.out.println("Ticket information: ");
        System.out.println("Row: "+row);
        System.out.println("Seat: "+seat);
        System.out.println("Price "+price);
        System.out.println("Person "+person);
        person.printInfo();


    }
    //Save all detail of ticket to the new text file
    public void save() {
        String file_name = row + seat +".txt";
        try (FileWriter writer = new FileWriter(file_name)){

            writer.write("***Ticket Information***\n");
            writer.write("Seat Row: " + row + "\n");
            writer.write("Seat Number: " + seat + "\n");
            writer.write("Price: " + price + "\n");
            writer.write("*** Person Information ***\n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket Information save to " + file_name);
        }catch (IOException e) {
            System.out.println("Error is occured");

        }
    }
}

