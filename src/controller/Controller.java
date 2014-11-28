package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logic.Ambulance;
import logic.EmergencyCallService;
import logic.Hospital;
import logic.Patient;

public class Controller {

	// A UNIQUE controller for all Use Cases. Singleton pattern with
	// lazy initialization (the Controller instance is created when it is
	// firstly required)
	private static Controller controller = null;

	// The private attribute EmergencyCallService of the business logic layer
	private static EmergencyCallService emergencyCS;

	private Controller() {
		emergencyCS = new EmergencyCallService();
	}

	public static Controller getSingletonController() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void CreateNewPatient(Patient pat) {
		emergencyCS.addPatient(pat);
	}

	public Iterator<Patient> getPatients() {
		return emergencyCS.getPatients();
	}

	public List<Ambulance> getAmbulances() {
		return emergencyCS.getAmbulances();
	}

	public static void setAmbuState(String reg, String newState, double newLat,
			double newLong) {

		emergencyCS.setAmbuState(reg, newState, newLat, newLong);
	}

	public static Ambulance getAmbuState(String string) {
		// TODO Auto-generated method stub
		return null; // emergencyCS.getAmbuState(string);;
	}

	public Ambulance getAmbulance(String selectedItem) {
		// TODO Auto-generated method stub
		return emergencyCS.getAmbulance(selectedItem);
	}

	public List<Hospital> getHospitals() {
		return emergencyCS.getHospitals();
	}

	public ArrayList<String> getSpecList(String hospital) {
		return emergencyCS.getSpecList(hospital);
	}
}
