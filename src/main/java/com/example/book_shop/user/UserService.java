package com.example.book_shop.user;

import com.example.book_shop.security.dto.RegisterDto;
import com.example.book_shop.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new BadCredentialsException("Username or password is not correct"));
    }

    @Transactional
    public void register(RegisterDto registerDto) {

        User user = new User( registerDto.getName(), registerDto.getPhoneNumber(), registerDto.getEmail(), registerDto.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword())); //passwordni yashirish uchun
        user.setId(UUID.randomUUID());
//        AbstractAuthenticationToken
        User save = userRepository.save(user);
//        System.out.println(save);

    }


}