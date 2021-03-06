package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department dep) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO Department " + "(Name) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, dep.getName());

			int linhasafetadas = st.executeUpdate();

			if (linhasafetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					dep.setId(id);

				}
				DB.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw new db.DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department dep) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ");
			st.setString(1, dep.getName());
			st.setInt(2, dep.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new db.DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
