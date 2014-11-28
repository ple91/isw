package logic;

public class HospitalBased extends Ambulance {
	public HospitalBased(String registrationNumber, String equipmentType,
			double latitude, double longitude) {
		super(registrationNumber, equipmentType, latitude, longitude);
		// TODO Auto-generated constructor stub
	}

	private Hospital hosp;

	public Hospital getHosp() {
		return hosp;
	}

	public void setHosp(Hospital hosp) {
		this.hosp = hosp;
	}
}
