package logic;

import java.util.HashMap;

public class Speciality {
	private String name;
	private HashMap<String, Symptom> symptomsHM;
	private HashMap<String, Hospital> hospitalsHM;

	public Speciality(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSymptom(Symptom s) {
		symptomsHM.put(s.getName(), s);
	}

	public void removeSpeciality(String name) {
		symptomsHM.remove(name);
	}

	public Symptom findSpeciality(String name) {
		return symptomsHM.get(name);
	}

	public void addHospital(Hospital s) {
		hospitalsHM.put(s.getName(), s);
	}

	public void removeHospital(String name) {
		hospitalsHM.remove(name);
	}

	public Hospital findHospital(String name) {
		return hospitalsHM.get(name);
	}

}
