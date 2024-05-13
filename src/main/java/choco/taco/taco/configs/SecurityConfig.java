package choco.taco.taco.configs;

import choco.taco.taco.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
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

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorizeHttpRequests) ->
//                authorizeHttpRequests.requestMatchers("/design", "/orders").hasRole("USER")
//                .requestMatchers("/", "/**").permitAll()
//                .anyRequest().authenticated()
//        ).formLogin((e) -> e.loginPage("/login")
//                .defaultSuccessUrl("/design")
//        ).oauth2Login((e) -> e.loginPage("/login"));
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorizeHttpRequests) ->
//                authorizeHttpRequests.requestMatchers("/design", "/orders").hasRole("USER")
//                        .requestMatchers("/", "/**").permitAll()
//                        .anyRequest().authenticated()
//        ).formLogin((e) -> e.loginPage("/login")
//                .defaultSuccessUrl("/design")
//        );
//        return http.build();
//    }
//
    /* CREATE FAKE USE WITH IN MEMORY USER DETAIL .... */
//    @Bean
//    public UserDetailsService userDetailService (PasswordEncoder encoder) {
//        List<UserDetails> userLists = new ArrayList<>();
//        userLists.add(
//                new User("buzz", encoder.encode("password"),
//                        List.of(new SimpleGrantedAuthority("ROLE_USER")))
//        );
//        userLists.add(
//                new User("woddy", encoder.encode("password"),
//                        List.of(new SimpleGrantedAuthority("ROLE_USER")))
//        );
//        return new InMemoryUserDetailsManager(userLists);
//    }

    /* FOR GOOGLE OAUTH this part is good, and run successfully.... */
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((e) ->
                e.anyRequest().authenticated()
                ).oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    /* OMIT THIS PART ------------------------------------------------------*/
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
//    }
//
//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService(
//            ClientRegistrationRepository clientRegistrationRepository) {
//        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
//    }
//
//    @Bean
//    public OAuth2AuthorizedClientRepository authorizedClientRepository(
//            OAuth2AuthorizedClientService authorizedClientService) {
//        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
//    }
//
//    private ClientRegistration googleClientRegistration() {
//        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
//                .clientId("google-client-id")
//                .clientSecret("google-client-secret")
//                .build();
//    }
    /* OMIT THIS PART ------------------------------------------------------*/
}
