package Entity;

import java.time.LocalDateTime;

import Entity.PositionName;
import Entity.Position;

public class Program {

	public static void main(String[] args) {
		//department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";
		
		Department department2 = new Department();
				department2.id = 2;
				department2.name = "Marketing";
		
		Department department3 = new Department();
				department3.id = 3;
				department3.name = "IT";
				
		//Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.Dev;
		
		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.PM;
		
		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.Test;
		
		//group
		
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Development";
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";
		
		//Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "lan@gmail.com";
		account1.userName = "lan1";
		account1.fullName = "Le Thi Lan";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDateTime.now();
		Group[] groupAcc1 = { group1, group2 };
		account1.groups = groupAcc1;
		
		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "locnguyen@gmail.com";
		acc2.userName = "locnguyen";
		acc2.fullName = "Nguyen Ba Loc";
		acc2.department = department2;
		acc2.position = position2;
		acc2.createDate = LocalDateTime.now();
		Group[] groupAcc2 = { group2 };
		acc2.groups = groupAcc2;
		
		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "duongtrinh@gmail.com";
		acc3.userName = "duongtrinh";
		acc3.fullName = "Trinh Ngoc Duong";
		acc3.department = department3;
		acc3.position = position3;
		acc3.createDate = LocalDateTime.now();
		Group[] groupAcc3 = { group2, group3 };
		acc3.groups = groupAcc3;
	}
	
	
	
	
	
}
