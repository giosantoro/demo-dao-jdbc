package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		//test
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== Test 2: findAll ====");
		List<Department> result = new ArrayList<>();
		result = departmentDao.findAll();
		for(Department line : result) {
			System.out.println(line);
		}
		
		System.out.println("\n=== Test 3: Insert ====");
		Department newDepartment = new Department(null, "Illumination");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: Update ====");
		department = departmentDao.findById(1);
		department.setName("Computer");
		departmentDao.update(department);
		System.out.println("Updated: " + department);
		
		System.out.println("\n=== Test 5: Delete ====");
		System.out.print("Type an id of the department to be deleted: ");
		int del = sc.nextInt();
		departmentDao.deleteById(del);
		System.out.println("Deleted department with id " + del);
		
		sc.close();
		
	}

}
