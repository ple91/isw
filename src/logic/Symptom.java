package logic;

import java.util.HashMap;

public class Symptom {
	private int stageOfGravity;
	private double duration; // in hours!
	private String description;
	private String name;
	private String id;

	private String idSpeciality;
	private HashMap<String, EmergencyCall> emergenciesHM;

	public Symptom(String id, String idSpeciality, String name,
			String description, double duration, int stageOfGravity) {
		super();
		this.stageOfGravity = stageOfGravity;
		this.duration = duration;
		this.description = description;
		this.name = name;
		this.id = id;
		this.idSpeciality = idSpeciality;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStageOfGravity() {
		return stageOfGravity;
	}

	public void setStageOfGravity(int stageOfGravity) {
		this.stageOfGravity = stageOfGravity;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addEmergency(EmergencyCall s) {
		emergenciesHM.put(s.getId(), s);
	}

	public void removeEmergency(String id) {
		emergenciesHM.remove(id);
	}

	public EmergencyCall findEmergency(String i) {
		return emergenciesHM.get(i);
	}

	public String getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(String idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

}
