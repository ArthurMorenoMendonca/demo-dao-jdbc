package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao dt = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department d = dt.findById(3);
		System.out.println(d);
		
		System.out.println("\n==== TEST 2: department findAll ====");
		List<Department> list = new ArrayList<>();
		list = dt.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: department Insert ====");
		Department dep = new Department(null, "Music");
		dt.insert(dep);
		System.out.println("Inserted! New id: " + dep.getId());
		
		
		System.out.println("\n==== TEST 4: department Update ====");
		
		Department dep2 = dt.findById(1);
		dep2.setName("Geek eletronics");
		dt.update(dep2);
		System.out.println("Update Completed!!!");
		
		System.out.println("\n==== TEST 5: department Delete ====");
		System.out.print("Enter id for delete test: ");
		int id = scan.nextInt();
		dt.deleteById(id);
		System.out.println("Delete Completed!!!");
		

	}

}
