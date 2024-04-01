package com.ebos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebos.Response.DeleteResponse;
import com.ebos.Response.SetListResponse;
import com.ebos.Service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public SetListResponse findAll() {
		return userService.findAll();
	}
	
	@DeleteMapping("/deleteuser")
    public ResponseEntity<?> deleteUser() {
		
		try {
			return new ResponseEntity<DeleteResponse>(userService.deleteUser(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DeleteResponse>(userService.deleteUser(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
