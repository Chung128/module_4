package com.example.tich_hop_security_cho_ung_dung_blog.config;

import com.example.tich_hop_security_cho_ung_dung_blog.model.MyUser;
import com.example.tich_hop_security_cho_ung_dung_blog.repository.IMyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        if (userObj.getUserRoles() == null || userObj.getUserRoles().isEmpty()) {
            System.out.println("🔥 No roles found for user " + userObj.getUsername() + ", defaulting to USER");
            return new String[]{"USER"};
        }
        String[] roles = userObj.getUserRoles().stream()
                .map(userRole -> userRole.getRole().getName())
                .toArray(String[]::new);
        System.out.println("🔥 Roles for user " + userObj.getUsername() + ": " + Arrays.toString(roles));
        return roles;
    }

//    private String[] getRoles(MyUser userObj) {
//        if (userObj.getUserRoles()==null){
//            return new String[]{"USER"};
//        }
//        // Lấy danh sách tên vai trò từ Set<UserRole> bằng Stream API
//        return userObj.getUserRoles().stream()
//                .map(userRole -> userRole.getRole().getName()) // Lấy tên vai trò từ UserRole
//                .toArray(String[]::new);
//    }
}
