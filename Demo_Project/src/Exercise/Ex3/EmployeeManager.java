package Exercise.Ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
	//Create List, File to store Emp data
	//And method for addToList, saveToFile, searchById
	
	private static List<Employee> employeeList = new ArrayList<>();
	
	private static String FILE_NAME = "employee.txt";
	
	
	private static void addEmpToList(String id, String name) {
		
		Employee newEmployee = new Employee(id, name);
		employeeList.add(newEmployee);
	}
	
	private static void saveEmpToFile() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			
			for (Employee employee : employeeList) {
				writer.write(employee.getId() + "," + employee.getName());
				writer.newLine();
			}
			
			System.out.println("Save emp to file successful !!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void searchEmpById(String id) {
		
		for(Employee employee : employeeList) {
			
			if (employee.getId().equals(id)) {
				
				System.out.println("Employee ID: " + employee.getId() + ", Employee Name: " + employee.getName());
				return;
			}
		}		
	}
	
	private static void loadEmpFromFileToList() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 2) {
					employeeList.add(new Employee(data[0], data[1]));
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		loadEmpFromFileToList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter A for add new employee, S for search employee: ");
		String choice = scanner.nextLine();
		
		if(choice.equalsIgnoreCase("A")) {
			
			System.out.print("Pls enter ID: ");
			String id = scanner.nextLine();
			
			System.out.print("Pls enter Name: ");
			String name = scanner.nextLine();
			
			addEmpToList(id, name);
			saveEmpToFile();
			
		} else if(choice.equalsIgnoreCase("S")) {
			
            System.out.print("Pls enter ID: ");
            String id = scanner.nextLine();
            
            searchEmpById(id);
		} else {
			System.out.println("Invalid choice. Please try again.");
		}
		
	}
	
	
	
	
}



















