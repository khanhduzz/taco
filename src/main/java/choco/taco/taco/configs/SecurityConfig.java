package choco.taco.taco.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailService (PasswordEncoder encoder) {
        List<UserDetails> userLists = new ArrayList<>();
        userLists.add(
                new User("buzz", encoder.encode("password"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
        );
        userLists.add(
                new User("woddy", encoder.encode("password"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
        );
        return new InMemoryUserDetailsManager(userLists);
    }
}
