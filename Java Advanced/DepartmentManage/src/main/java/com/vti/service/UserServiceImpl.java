//package com.vti.service;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.vti.entity.User;
//import com.vti.repository.IUserRepository;
//
//
//@Service
//public class UserServiceImpl implements IUserService {
//
//	@Autowired
//	private IUserRepository repository;
//
//	/*
//	 * @see com.vti.template.service.UserService#getAllUsers()
//	 */
//	@Override
//	public List<User> getAllUsers() {
//		return repository.findAll();
//	}
//
//	/*
//	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
//	 */
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// Check user exists by user name
//		User user = repository.findByUserName(username);
//
//		if (user == null) {
//			throw new UsernameNotFoundException(username);
//		}
//
//		return new org.springframework.security.core.userdetails.User(
//				user.getUserName(), 
//				user.getPassword(),
//				AuthorityUtils.createAuthorityList(user.getRole()));
//	}
//
//	@Override
//	public User findByUserName(String username) {
//		return repository.findByUserName(username) ;
//	}
//}
