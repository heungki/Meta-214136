package com.shinhansec.meta.study.domain.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
//    @Autowired
    UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
