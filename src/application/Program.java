package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: findByDepartment ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: Seller.insert() ====");
		Seller newSeller = new Seller(null, "Greg Cyan", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: Seller.update() ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Brown");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed: " + seller);
		
		System.out.println("\n=== Test 6: Seller.delete() ====");
		int delete = sc.nextInt();
		System.out.print("Enter Id of seller to be deleted: ");
		sellerDao.deleteById(delete);
		System.out.println("Deleted!");
		
		sc.close();
		
	}

}
