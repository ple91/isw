// AmbulanceDAOImp class

package dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.*;
import exceptions.DAOException;

public class AmbulanceDAOImp implements IAmbulanceDAO {

	private ConnectionManager connManager;

	public AmbulanceDAOImp() throws DAOException {
		super();

		try {
			connManager = new ConnectionManager("ISW_DB");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	public Ambulance findAmbulance(String registrationNumber)
			throws DAOException {
		try {

			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select * from Ambulance where REGISTRATION_NUMBER= '"
							+ registrationNumber + "'");
			connManager.close();

			if (rs.next()) {
				return new Private(registrationNumber,
						rs.getString("EQUIPMENT_TYPE"),
						rs.getDouble("LATITUDE"), rs.getDouble("LONGITUDE"));
			} else
				return null;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Ambulance> getAmbulance() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from AMBULANCE");
			connManager.close();

			List<Ambulance> listAmbulances = new ArrayList<Ambulance>(); // the
																			// collection
																			// as
																			// an
																			// ArrayList
			while (rs.next()) {

				Ambulance pa = findAmbulance(rs
						.getString("REGISTRATION_NUMBER"));
				listAmbulances.add(pa);

			}

			return listAmbulances;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
