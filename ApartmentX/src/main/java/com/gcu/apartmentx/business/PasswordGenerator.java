package com.gcu.apartmentx.business;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class for generating encoded passwords using BCrypt
 * Demonstrates encoding a raw password using BCryptPasswordEncoder
 */
public class PasswordGenerator {
	/**
	 * Main method to generate and print an encoded password
	 * @param args command-line arguments (not used in this example)
	 */
	public static void main(String[] args) {
		String rawPassword = "admin";
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
	}
}
