package logic;

import java.util.HashMap;

public abstract class Ambulance {

	private String registrationNumber;
	private String equipmentType;
	private double latitude;
	private double longitude;
	private String state = "free";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Ambulance(String registrationNumber, String equipmentType,
			double latitude, double longitude) {
		super();
		this.registrationNumber = registrationNumber;
		this.equipmentType = equipmentType;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// relations
	private HashMap<Integer, EmergencyCall> eCHM;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
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

	public void addEmergencyCall(int id, EmergencyCall a) {
		this.eCHM.put(id, a);
	}

	public void removeEmergencyCall(int id) {
		this.eCHM.remove(id);
	}

	public void getEmergencyCall(int id) {
		this.eCHM.get(id);
	}

}
