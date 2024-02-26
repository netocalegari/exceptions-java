package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.println("Check-in date (DD/MM/YYYY)");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (DD/MM/YYYY)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data do update the reservation: ");

            System.out.println("Check-in date (DD/MM/YYYY)");
            checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (DD/MM/YYYY)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        } catch (ParseException err) {
            System.out.println("Invalid date format!");
        } catch (DomainException err) {
            System.out.println("Error in reservation: " + err.getMessage());
        } catch (RuntimeException err) {
            System.out.println("Unexpected error: " + err.getMessage());
        }

        sc.close();
    }
}
