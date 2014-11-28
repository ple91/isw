// Application class
package app;

import java.util.Iterator;
import java.util.List;

import logic.Ambulance;
import logic.EmergencyCallService;
import logic.EmergencyCallService2;
import logic.Patient;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// A demo for using EmergencyCallService methods:
		EmergencyCallService ecs = new EmergencyCallService();

		// my database had initially 4 patients
		showAllAmbulances(ecs.getAmbulances());
		showAllPatients(ecs.getPatients());

		// adding some new patients
		ecs.addPatient(new Patient("58654588X", "Neil", "Armstrong", "M", 70,
				"+01987653443", "The moon"));
		ecs.addPatient(new Patient("13453835Z", "Amadeus", "Mozart", "M", 27,
				"+02384784", "Austria St."));

		// finding an existent and non-existent patient
		Patient p;
		p = ecs.findPatient("123456");
		if (p != null)
			System.out.println("Patient 123456 is in the collection");
		p = ecs.findPatient("XXX134");
		if (p == null)
			System.out
					.println("Patient XXX134 has not been found in memory+database");

		// showing all the patients now
		showAllPatients(ecs.getPatients());
		showAllAmbulances(ecs.getAmbulances());
	}

	private static void showAllAmbulances(List<Ambulance> list) {
		for (Ambulance a : list) {
			showAmbulance(a);
		}

	}

	private static void showAmbulance(Ambulance p) {
		System.out
				.println("The ambulance with data [reg_no equipment long lat]: ["
						+ p.getRegistrationNumber()
						+ " "
						+ p.getEquipmentType()
						+ " "
						+ p.getLongitude()
						+ " "
						+ p.getLatitude() + "]");
	}

	private static void showAllPatients(Iterator<Patient> patients) {
		while (patients.hasNext()) {
			showPatient(patients.next());
		}
	}

	private static void showPatient(Patient p) {
		System.out.println("The patient with data [dni name surname age]: ["
				+ p.getDni() + " " + p.getName() + " " + p.getSurname() + " "
				+ p.getAge() + "]");
	}
}
