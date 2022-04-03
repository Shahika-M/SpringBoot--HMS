package com.example.SpringBootHMS.serviceImpl;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.SpringBootHMS.entity.User;
import com.example.SpringBootHMS.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found "+ userName));
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}

}