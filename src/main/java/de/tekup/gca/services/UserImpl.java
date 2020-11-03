package de.tekup.gca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.gca.entities.User;
import de.tekup.gca.repository.UserRepo;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User addAccount(User user) {
		
			return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long user_id) {

		   userRepo.deleteById(user_id);
		
	}

	@Override
	public void updateUser(User user) {

		   userRepo.save(user);
	}

	@Override
	public User findUser(Long user_id) {

		return userRepo.findById(user_id).orElseThrow(() -> new RuntimeException("User not exist"));
		
	}

	@Override
	public List<User> allUsers() {

		return userRepo.findAll();
	}


	@Override
	public void acceptUser(Long user_id) {
		
		User user = userRepo.findById(user_id).orElseThrow(() -> new RuntimeException("User not exist"));
		if (!user.equals(null)) {
			user.setAccepted(true);
			userRepo.save(user);
		}
	}

	@Override
	public void refuseUser(Long user_id) {

			userRepo.deleteById(user_id);
	}
	
	@Override
	public void resetPassword(String newPwd, Long user_id) {

		
		User user = userRepo.findById(user_id).orElseThrow(() -> new RuntimeException("User not exist"));
		if (!user.equals(null)) {
			user.setPassword(newPwd);
			userRepo.save(user);
		}
	}

	@Override
	public void resetPassword(String newPwd, String oldPwd, Long user_id) {
		
		User user = userRepo.findById(user_id).orElseThrow(() -> new RuntimeException("User not exist"));
		
		if (!user.equals(null) && user.getPassword().equals(oldPwd)) {   // equals (oldPwd) eli bech yji mel formulaire
			user.setPassword(newPwd);
			userRepo.save(user);
		}
		
	}

}
