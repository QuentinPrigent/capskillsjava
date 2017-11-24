package com.capgemini.capskills.manager;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.capskills.dao.UserDAO;
import com.capgemini.capskills.entities.User;

public class InputManager {

	public static void createUser(){
		User user = new User();

		Scanner sc = new Scanner(System.in);		
		System.out.println("Please insert user's firstname");
		user.setFirstname(sc.nextLine());
	
		System.out.println("Please insert user's lastname");
		user.setLastname(sc.nextLine());
		
		System.out.println("Please insert user's email");
		user.setEmail(sc.nextLine());
		
		System.out.println("Please insert user's password");
		user.setPassword(sc.nextLine());
	
		sc.close();
		
		UserDAO daoU = new UserDAO();
		daoU.insert(user);
		
	}
	
}
