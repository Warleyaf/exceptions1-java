package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    // FOrma correta de tratamento de exceções
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy):");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkin, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {// Tratando a Parseexception
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) { // aqui captura qualquer erro inesperado
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
