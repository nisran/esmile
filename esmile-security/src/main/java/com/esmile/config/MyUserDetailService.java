// package com.esmile.config;
//
// import com.esmile.common.domain.Role;
// import com.esmile.common.domain.User;
// import com.esmile.common.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @Configuration
// public class MyUserDetailService implements UserDetailsService {
//
//     @Autowired
//     private UserService userService;
//
//     /**
//      * 通过用户名，查询数据中的用户名，然后返回User（sprig security对象）
//      * 问题：后面怎么处理，与UsernamePasswordAuthenticationFilter有什么关系
//      * @param username
//      * @return
//      * @throws UsernameNotFoundException
//      */
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//         User user = userService.getByName(username);
//         if (user == null) {
//             throw new UsernameNotFoundException("userName not found");
//         }
//         final List<Role> roles = userService.getRolesByUserId(user.getUserId());
//         roles.stream().toArray(role -> new SimpleGrantedAuthority(role.getRoleName()));
//         String pass = new BCryptPasswordEncoder().encode(user.getPassword());
//         final ArrayList<GrantedAuthority> authList = new ArrayList<>();
//         return new org.springframework.security.core.userdetails.User(username, pass, authList);
//     }
// }
