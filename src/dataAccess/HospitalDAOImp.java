// HospitalDAOImp class

package dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Ambulance;
import logic.Hospital;
import logic.Private;
import exceptions.DAOException;

public class HospitalDAOImp implements IHospitalDAO {

	private ConnectionManager connManager;

	public HospitalDAOImp() throws DAOException {
		super();

		try {
			connManager = new ConnectionManager("ISW_DB");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	public Hospital findHospital(String name) throws DAOException {
		try {
			// TODO check if the ambulance is private/hospital and search it and
			// return.
			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select * from HOSPITAL where NAME= '" + name
							+ "'");
			connManager.close();

			if (rs.next()) {

				return new Hospital(name, rs.getString("ADDRESS"),
						rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE"));

			} else
				return null;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Hospital> getHospital() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from HOSPITAL");
			connManager.close();

			List<Hospital> listHospitals = new ArrayList<Hospital>(); // the
																		// collection
																		// as an
																		// ArrayList
			while (rs.next()) {

				Hospital pa = findHospital(rs.getString("NAME"));
				listHospitals.add(pa);

			}

			return listHospitals;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public ArrayList<String> getCurrentSpecList(String hospital)
			throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select IDSPECIALITY from SUPPORTS WHERE IDHOSPITAL= '"
							+ hospital + "'");
			connManager.close();

			ArrayList<String> specList = new ArrayList<String>(); // the
																	// collection
																	// as an
																	// ArrayList
			while (rs.next()) {

				String pa = rs.getString("IDSPECIALITY");
				specList.add(pa);

			}

			return specList;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
