package logic;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class EmergencyCall {
	private double latitude;
	private double longitude;
	private Date date;
	private Time time;
	private Hospital hosp;
	private String id;
	private ArrayList<Symptom> mySymptoms;
	private Patient patient;
	private Ambulance ambulance;

	public Ambulance getAmbulance() {
		return ambulance;
	}

	public void setAmbulance(Ambulance ambulance) {
		this.ambulance = ambulance;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Hospital getHosp() {
		return hosp;
	}

	public void setHosp(Hospital hosp) {
		this.hosp = hosp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void addSymptom(Symptom s) {
		mySymptoms.add(s);
	}

	public void removeSymptom(Symptom s) {
		mySymptoms.remove(s);
	}

	public Symptom getSymptom(int i) {
		return mySymptoms.get(i);
	}

}
