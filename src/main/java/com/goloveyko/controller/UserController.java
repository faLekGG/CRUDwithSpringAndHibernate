package com.goloveyko.controller;

import com.goloveyko.entity.User;
import com.goloveyko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listUsers(Model model) {

		List<User> users = userService.users();

		model.addAttribute("listOfUsers", users);

		return "list-users";
	}

	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model){

		User user = new User();

		model.addAttribute("user", user);

		return "user-form";
	}

	@PostMapping("/add")
	public String addUser(@ModelAttribute("user") User user){

		userService.addUser(user);

		return "redirect:/user/list";
	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int id, Model model){

		model.addAttribute("user", userService.getUserById(id));

		return "user-form";
	}

	@RequestMapping("delete")
	public String removeUser(@RequestParam("userId") int id){

		userService.removeUser(id);

		return "redirect:/user/list";
	}

	@PostMapping("/search")
	public String searchUsers(@RequestParam("theSearchName") String theSearchName,
																Model theModel) {

		System.out.println(theSearchName);

		List<User> theUsers = userService.searchUsers(theSearchName);

		for(User user : theUsers) {
			System.out.println(user);
		}

		theModel.addAttribute("listOfUsers", theUsers);

		return "list-users";
	}

}
