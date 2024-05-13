package choco.taco.taco.configs;

import choco.taco.taco.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService (UserRepository userRepository) {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user != null) return user;
//            throw new UsernameNotFoundException("User '" + username + "' not found");
//        };
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests.requestMatchers("/design", "/orders").hasRole("USER")
                .requestMatchers("/", "/**").permitAll()
                .anyRequest().authenticated()
        ).formLogin((e) -> e.loginPage("/login")
                .defaultSuccessUrl("/design")
        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService (PasswordEncoder encoder) {
        List<UserDetails> userLists = new ArrayList<>();
        userLists.add(
                new User("buzz", encoder.encode("password"),
                        List.of(new SimpleGrantedAuthority("ROLE_USER")))
        );
        userLists.add(
                new User("woddy", encoder.encode("password"),
                        List.of(new SimpleGrantedAuthority("ROLE_USER")))
        );
        return new InMemoryUserDetailsManager(userLists);
    }
}
