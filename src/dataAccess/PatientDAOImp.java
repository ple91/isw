// PatientDAOImp class

package dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Patient;
import exceptions.DAOException;

public class PatientDAOImp implements IPatientDAO {

	private ConnectionManager connManager;

	public PatientDAOImp() throws DAOException {
		super();

		try {
			connManager = new ConnectionManager("ISW_DB");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	public Patient findPatient(String dni) throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select * from PATIENT where DNI= '" + dni + "'");
			connManager.close();

			if (rs.next())
				return new Patient(dni, rs.getString("NAME"),
						rs.getString("SURNAME"), rs.getString("GENDER"),
						rs.getInt("AGE"), rs.getString("PHONE_NUMBER"),
						rs.getString("ADDRESS"));
			else
				return null;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void createPatient(Patient p) throws DAOException {
		try {
			connManager.connect();
			connManager
					.updateDB("insert into PATIENT (DNI, NAME, SURNAME, GENDER, AGE, PHONE_NUMBER, ADDRESS) values('"
							+ p.getDni()
							+ "','"
							+ p.getName()
							+ "','"
							+ p.getSurname()
							+ "', '"
							+ p.getGender()
							+ "', "
							+ p.getAge()
							+ ", '"
							+ p.getPhoneNumber()
							+ "', '"
							+ p.getAddress() + "')");
			connManager.close();

		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<Patient> getPatients() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from PATIENT");
			connManager.close();

			List<Patient> listPatients = new ArrayList<Patient>(); // the
																	// collection
																	// as an
																	// ArrayList
			while (rs.next()) {
				Patient pa = findPatient(rs.getString("DNI"));
				listPatients.add(pa);
			}

			return listPatients;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
