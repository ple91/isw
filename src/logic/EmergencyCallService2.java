package logic;

import java.util.HashMap;

public class EmergencyCallService2 {
	private HashMap<String, Hospital> hospitalsHM;
	private HashMap<String, Ambulance> ambulancesHM;
	private HashMap<String, EmergencyCall> emergenciesHM;

	public void addHospital(Hospital hospital) {
		hospitalsHM.put(hospital.getName(), hospital);
	}

	public void addAmbulance(Ambulance ambulance) {
		ambulancesHM.put(ambulance.getRegistrationNumber(), ambulance);
	}

	public void addEmergency(EmergencyCall emergency) {
		emergenciesHM.put(emergency.getId(), emergency);
	}

	public Hospital getHospital(String name) {
		return hospitalsHM.get(name);
	}

	public Ambulance getAmbulance(int id) {
		return ambulancesHM.get(id);
	}

	public EmergencyCall getEmergency(int id) {
		return emergenciesHM.get(id);
	}

	public void removeHospital(String name) {
		hospitalsHM.remove(name);
	}

	public void removeAmbulance(int id) {
		ambulancesHM.remove(id);
	}

	public void removeEmergency(int id) {
		emergenciesHM.remove(id);
	}

}
