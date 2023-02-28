package com.arshiya.kitchenstory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arshiya.kitchenstory.model.Cart;
import com.arshiya.kitchenstory.model.User;
import com.arshiya.kitchenstory.model.UserLogin;
import com.arshiya.kitchenstory.repository.CartItemRepository;
import com.arshiya.kitchenstory.repository.CartRepository;
import com.arshiya.kitchenstory.repository.OrderItemRepository;
import com.arshiya.kitchenstory.repository.OrdersRepository;
import com.arshiya.kitchenstory.repository.ProductRepository;
import com.arshiya.kitchenstory.repository.UserRepository;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	CartRepository cartrepo;
	
	@Autowired
	CartItemRepository cartitemrepo;
	
	@Autowired
	OrdersRepository orderrepo;
	
	@Autowired
	OrderItemRepository orderitemrepo;
	
	@PostMapping("allusers")
	public List<User> getAllUsers(@RequestBody User user) throws Exception{
		
		User tempuser = userrepo.findById(user.getUserid()).get();
		boolean admincheck = tempuser.isAdminrights();
		if (admincheck) {
			List<User> userslist = (List<User>) userrepo.findAll();
			return userslist;
		}else {
			throw new Exception("Cannot get all users - Not Admin");
		}
	}
	@PostMapping("create")
	public Optional<User> createNewUser(@RequestBody User user) {
		User newUser = new User();
		newUser = user;
		
		Cart newCart = new Cart();
		newCart.setUser(newUser);
		newCart.setStatus("Empty");
		cartrepo.save(newCart);
		
		newUser.setCart(newCart);
		userrepo.save(newUser);
		
		return userrepo.findById(newUser.getUserid());
		
	}
	@GetMapping("getuser/{id}")
	public User getOneUser(@PathVariable long id) {
		return userrepo.findById(id).orElse(null);
	}
	@DeleteMapping("delete")
	public void deleteUser(@RequestBody User user) throws Exception {
		User tempuser = userrepo.findById(user.getUserid()).orElse(null);
		Cart tempcart = cartrepo.findById(tempuser.getCart().getCartid()).orElse(null);
		
		if(tempuser != null && tempcart != null) {
			cartrepo.delete(tempcart);
			userrepo.delete(tempuser);
		}
		else {
			throw new Exception("Error deleting user");
		}
	}
	
	@PostMapping("login")
	public User loginUser(@RequestBody UserLogin user) throws Exception {
		System.out.println("Email:"+user.getEmail());
		System.out.println("Password:"+user.getPassword());
		User usercheck = userrepo.findByEmail(user.getEmail());
		if(usercheck.getPassword().equals(user.getPassword())) {
			return usercheck;
		}else {
			throw new Exception("Login Error - Email/Password mismatched!");
		}
	}
	
	@PutMapping("resetpassword")
	public User resetPassword(@RequestBody User user) throws Exception {
		User tempuser = userrepo.findById(user.getUserid()).orElse(null);
		if (tempuser != null) {
			tempuser.setPassword(user.getPassword());
			return userrepo.save(tempuser);
		}else {
			throw new Exception("Error resetting password");
		}
		
		
	}
	
	

}
