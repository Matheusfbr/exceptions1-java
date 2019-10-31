package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Reservation rs = new Reservation();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		Integer roomNumber = sc.nextInt();
		System.out.print("Data do Check-in(dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out(dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Erro na reserva: as datas da reserva devem ser futuras.");
		} else {

			if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior ao check-in!");
			} else {

				rs = new Reservation(roomNumber, checkIn, checkOut);
				System.out.println(rs);
			}
		}
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("Entre com os dados para atualizar a reserva: ");
		System.out.print("Check-in(dd/mm/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out(dd/mm/yyyy): ");
		checkOut = sdf.parse(sc.next());

		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Erro na reserva: as datas da reserva devem ser futuras.");
		} else {

			if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior ao check-in!");
			} else {
				rs.UpdateDates(checkIn, checkOut);
				System.out.println(rs);
			}
		}

		sc.close();
	}

}
