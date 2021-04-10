package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		//System.out.println("=== Test 1: findById ====");
		//Department department = departmentDao.findById(3);
		//System.out.println(departmentDao);
		
		//System.out.println("\n=== Test 2: findAll ====");
		
		System.out.println("\n=== Test 3: Insert ====");
		Department newDepartment = new Department(null, "Illumination");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		//System.out.println("\n=== Test 4: Update ====");
		
		//System.out.println("\n=== Test 5: Delete ====");
		
		sc.close();
		
	}

}
