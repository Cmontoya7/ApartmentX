package com.gcu.apartmentx.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;

/**
 * Service class for managing user details and authentication logic
 * Implements Spring Security's UserDetailsService interface
 */
@Service
public class UserBusinessService implements UserDetailsService
{
	//Spring bean which interacts with the User repository
	@Autowired
	UserDataService service;
	
	/**
	 * Loads user details by username for authentication purposes
	 * @param username the username of the user
	 * @return a UserDetails object containing user information and roles
	 * @throws UsernameNotFoundException if the user is not found in the system
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// Try to find the User in the database. If not found throw a User Not found exception else return a Spring Security User.
		UserEntity user = service.findByUsername(username);
		if(user != null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(Integer.toString(user.getId()), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}

}
