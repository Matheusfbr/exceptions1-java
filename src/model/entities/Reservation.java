package model.entities;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		Date now = new Date();
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out deve ser posterior ao check-in");
		}
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Erro na reserva: as datas da reserva devem ser futuras.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Long duration() {
		Long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void UpdateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Erro na reserva: as datas da reserva devem ser futuras.");
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva: a data de check-out deve ser posterior ao check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reserva: Quarto " + roomNumber + ", checkIn: " + sdf.format(checkIn) + ", checkOut: "
				+ sdf.format(checkOut) + duration() + " nights";
	}

}
