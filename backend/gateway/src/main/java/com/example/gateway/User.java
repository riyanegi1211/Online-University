// package com.example.gateway;

// import java.util.Arrays;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class User implements UserDetails {
//     String username = "";
//     String password = "";
//     String role = "";

//     @Override
//     public String getUsername() {
//         return this.getUsername();
//     }

//     @Override
//     public String getPassword() {
//         return this.getPassword();
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return Arrays.stream(this.role
//             .split(","))
//             .map(s -> "ROLE_" + s)
//             .map(SimpleGrantedAuthority::new)
//             .toList();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
