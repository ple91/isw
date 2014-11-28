// SpecialityDAOImp class

package dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Speciality;
import exceptions.DAOException;

public class SpecialityDAOImp implements ISpecialityDAO {

	private ConnectionManager connManager;

	public SpecialityDAOImp() throws DAOException {
		super();

		try {
			connManager = new ConnectionManager("ISW_DB");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	public Speciality findSpeciality(String name) throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select * from Speciality where name= '" + name
							+ "'");
			connManager.close();

			if (rs.next())
				return new Speciality(name);
			else
				return null;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Speciality> getSpeciality() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from Speciality");
			connManager.close();

			List<Speciality> listSpecialitys = new ArrayList<Speciality>(); // the
																			// collection
																			// as
																			// an
																			// ArrayList
			while (rs.next()) {
				Speciality pa = findSpeciality(rs.getString("DNI"));
				listSpecialitys.add(pa);
			}

			return listSpecialitys;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
