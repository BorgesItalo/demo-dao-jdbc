package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		/*System.out.println("=== TESTE 1: Department Insert ===");
		System.out.println("Digite o nome do departamento");
		String depart = sc.next();
		Department dep = new Department(null, depart);
		depDao.insert(dep);
		System.out.println("Ação concluida com sucesso!");*/
		
		System.out.println("=== TESTE 2: Department UpDate ===");
		System.out.println("Digite o nome para atualizar");
		Department dep = new Department();
		String name = sc.next();
		dep.setName(name);
		System.out.println("Digite o ID");
		int id = sc.nextInt();
		dep.setId(id);
		depDao.update(dep);
		System.out.println("Ação concluida");
		
	
	}

}
