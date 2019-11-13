package com.luluh.WaterBnB.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.luluh.WaterBnB.models.Pool;
import com.luluh.WaterBnB.models.Review;
import com.luluh.WaterBnB.models.User;
import com.luluh.WaterBnB.repositories.PoolRepository;
import com.luluh.WaterBnB.repositories.RoleRepository;
import com.luluh.WaterBnB.repositories.UserRepository;
import com.luluh.WaterBnB.repositories.ReviewRepository;
@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PoolRepository poolRepository;
    private ReviewRepository reviewRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, ReviewRepository reviewRepository, RoleRepository roleRepository, PoolRepository poolRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.poolRepository = poolRepository;
        this.reviewRepository = reviewRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public List<User> allUsers() {
        return userRepository.findAll();
    }
    public List<Pool> allPools() {
        return poolRepository.findAll();
    }
    public List<Review> allReviews() {
        return reviewRepository.findAll();
    }
    public Pool createPool(Pool b) {
        return poolRepository.save(b);
    }
    
    public Review createReview(Review b) {
        return reviewRepository.save(b);
    }
    
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public Pool findPool(Long id) {
        Optional<Pool> optionalPool = poolRepository.findById(id);
        if(optionalPool.isPresent()) {
            return optionalPool.get();
        } else {
            return null;
        }
    }
    


    
	public @Valid Pool updatePool(@Valid Pool pool) {
		Optional<Pool> optionalPool = poolRepository.findById(pool.getId());
	
		  if(optionalPool.isPresent()) {
			  Pool optionalPool1 = optionalPool.get();
			  optionalPool1.setAddress(pool.getAddress());
			  optionalPool1.setCost(pool.getCost());
			  optionalPool1.setDescription(pool.getDescription());
			  optionalPool1.setSize(pool.getSize());
			  return poolRepository.save(optionalPool1);   
	        } else {
	            return null;
	        }
	}
	
}