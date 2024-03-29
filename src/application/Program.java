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
		
		Scanner scan = new Scanner(System.in);
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
        System.out.println("\n==== TEST 3: seller findAll ====");
		
		list = sellerdao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4: seller Insert ====");
		
		Seller newSeller = new Seller(null,"Arthur","arthurmoreno@gmail.com",new Date(),6000.0,department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
        System.out.println("\n==== TEST 5: seller Update ====");
		
		seller = sellerdao.findById(1);
		seller.setName("gian freires");
		seller.setEmail("gianfreires@gmail.com");
		sellerdao.update(seller);
		System.out.println("Update completed !!! ");
		
		System.out.println("\n==== TEST 6: seller Delete ====");
		
		System.out.println("Enter id for delete teste: ");
		int id = scan.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed");
		

	}

}
