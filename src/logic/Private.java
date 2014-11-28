package logic;

public class Private extends Ambulance {
	public Private(String registrationNumber, String equipmentType,
			double latitude, double longitude) {
		super(registrationNumber, equipmentType, latitude, longitude);
		// TODO Auto-generated constructor stub
	}

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
