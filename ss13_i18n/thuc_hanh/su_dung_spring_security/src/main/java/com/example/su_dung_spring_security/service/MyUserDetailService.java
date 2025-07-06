package com.example.su_dung_spring_security.service;

import com.example.su_dung_spring_security.model.MyUser;
import com.example.su_dung_spring_security.repository.IMyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    private IMyUserRepository myUserRepository;

    @Autowired
    public MyUserDetailService(IMyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user =myUserRepository.findByUsername(username);
        if (user.isPresent()){
            var userObj=user.get();
            return   User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();

        }else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(MyUser userObj) {
        if (userObj.getRole()==null){
            return new String[]{"USER"};
        }
        return userObj.getRole().split(",");
    }
}
