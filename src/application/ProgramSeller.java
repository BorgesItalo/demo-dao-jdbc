package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramSeller {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("=== TESTE 2: Seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TESTE 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("=== TESTE 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id = " + newSeller.getId());
		System.out.println("=== TESTE 5: Seller UpDate ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update Concluido");
		System.out.println("=== TESTE 6: Seller Delete ===");
		System.out.println("Enter id for delete");
		Scanner sc = new Scanner(System.in);
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Delete computer");
		sc.close();
	}

}
