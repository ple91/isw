package logic;

import java.util.HashMap;

public class Hospital {

	private String name;
	private String address;
	private double latitude;
	private double longitude;
	private HashMap<String, Speciality> specialitiesHM;
	private HashMap<String, EmergencyCall> emergencyCallsHM;
	private HashMap<String, HospitalBased> hospitalBasedHM;

	public Hospital(String name, String address, double latitude,
			double longitude) {
		super();
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void addSpeciality(Speciality s) {
		specialitiesHM.put(s.getName(), s);
	}

	public void removeSpeciality(String name) {
		specialitiesHM.remove(name);
	}

	public Speciality findSpeciality(String name) {
		return specialitiesHM.get(name);
	}

	public void addEmergencyCall(EmergencyCall s) {
		emergencyCallsHM.put(s.getId(), s);
	}

	public void removeEmergencyCall(String id) {
		emergencyCallsHM.remove(id);
	}

	public EmergencyCall findEmergencyCall(String id) {
		return emergencyCallsHM.get(id);
	}

	public void addHospitalBased(HospitalBased s) {
		hospitalBasedHM.put(s.getRegistrationNumber(), s);
	}

	public void removeHospitalBased(String registrationNumber) {
		hospitalBasedHM.remove(registrationNumber);
	}

	public HospitalBased findHospitalBased(String registrationNumber) {
		return hospitalBasedHM.get(registrationNumber);
	}
}
