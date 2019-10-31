package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reservation rs = new Reservation();

		try {
			System.out.print("Número do quarto: ");
			Integer roomNumber = sc.nextInt();
			System.out.print("Data do Check-in(dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out(dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			rs = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(rs);
	
			System.out.println();

			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Check-in(dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out(dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			rs.UpdateDates(checkIn, checkOut);
			System.out.println(rs);
		} catch(ParseException e) {
			System.out.println("Data inválida!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Erro de argumentos!");
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
