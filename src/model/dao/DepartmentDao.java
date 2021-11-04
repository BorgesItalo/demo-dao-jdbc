package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	void insert(Department dep);

	void update(Department dep);

	void deleteById(Integer dep);

	Department findById(Integer dep);

	List<Department> findAll();
}
