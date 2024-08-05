// src\main\java\devquest\config\SecurityConfig.java

package devquest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

// @EnableWebSecurity 설명
// 1. 스프링 시큐리티의 기본 설정을 활성화
// 2. 사용자 정의 보안 설정을 정의하기 위해 SecurityConfigurer를 확장하는 클래스를 작성할 수 있도록 함
// 3. 어노테이션이 적용된 클래스가 스프링 시큐리티 설정 클래스로 인식되며,
// 4. HTTP 보안 설정 및 인증, 인가 설정을 위한 메서드를 정의할 수 있게 됨
// 참고: SecurityConfig와 SecurityConfigurer는 다르다
// SecurityConfig는 보통 사용자가 직접 정의하는 클래스 이름
// SecurityConfigurer는 스프링 시큐리티 프레임워크의 일부로, 보안 설정을 구성하기 위해 제공되는 인터페이스
@Configuration
@EnableWebSecurity
public class SecurityConfig { // 보안 설정을 정의하는데 사용되는 클래스

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        System.out.println("SecurityConfig.securityFilterChain");
        http
                // 모든 HTTP 요청이 HTTPS(SSL/TLS)를 통해 전달되도록 요구
                .requiresChannel(channel -> channel
                        .anyRequest()
                        .requiresSecure()
                )
                // 모든 HTTP 요청에 대해 인증 없이 접근을 허용
                //                .authorizeHttpRequests(auth -> auth
                //                        .anyRequest()
                //                        .permitAll()
                //                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/company/**", "/job/**", "/resume/**", "/team/**", "/quest/**", "/webinar/**").permitAll()
                        .requestMatchers("/user/login", "/user/signup").permitAll()
                        .requestMatchers("/user/profile").authenticated()
                        .anyRequest().permitAll() // .authenticated() 으로 바꾸면 글꼴 등 제대로 로딩 안됨
                )
                /*
                 * Spring Security 5.4 이상 버전에서는 antMatchers 메서드 대신
                 * authorizeRequests와 requestMatchers 메서드를 사용해야 함
                 * */
                // .authorizeHttpRequests(auth -> auth
                // .antMatchers("/company/**", "/job/**", "/resume/**").permitAll() // 공용 경로에 대한 접근 허용
                // .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                // )
                /*
                 * Spring Security 5.5 이상에서는 authorizeRequests 대신
                 * authorizeHttpRequests를 사용하며,
                 * requestMatchers 메서드를 사용하는 것이 권장됨
                 * */
                // .authorizeRequests(auth -> auth
                // .requestMatchers("/public/**").permitAll()
                // .requestMatchers("/company/**").permitAll()
                // .requestMatchers("/job/**").permitAll()
                // .requestMatchers("/resume/**").permitAll()
                // .anyRequest().authenticated()
                // )
                //                .authorizeHttpRequests(auth -> auth
                //                        .requestMatchers("/company/**").permitAll()
                //                        .requestMatchers("/job/**").permitAll()
                //                        .requestMatchers("/resume/**").permitAll()
                //                        .requestMatchers("/quest/**").permitAll()
                //                        .requestMatchers("/webinar/**").permitAll()
                //                        .anyRequest().authenticated()
                //                )
                .formLogin(form -> form
                        .loginPage("/user/login").permitAll()
                )
                // 람다를 메서드 참조로 바꿀 수 있음
                // .logout(logout -> logout
                //         .permitAll()
                // );
                .logout(LogoutConfigurer::permitAll
                );

        // HTTPS 설정에서 무한 리디렉션 루프가 발생할 수 있음
        // 이것을 방지하기 위한 설정
        // 스프링 시큐리티 6.1 이상에서 지원 중단
        // http.csrf().disable();

        // 스프링 시큐리티 6.1 이상에서 지원 중단
        // http.sessionManagement()
        //        .invalidSessionUrl("/login")
        //        .sessionFixation().none();

        // 기본 설정으로 CSRF 보호 활성화
        //                .csrf(csrf -> csrf
        //                        .ignoringRequestMatchers("/company/**", "/job/**", "/resume/**", "/quest/**", "/webinar/**", "/resume/**")
        //                )

        // 세션 관리 설정
        //                .sessionManagement(session -> session
        //                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        //                );
        // 리디렉션 / 쿠키 관련 문제 떠서 주석 처리

        // 설정이 완료된 HttpSecurity 객체를 기반으로 SecurityFilterChain 객체를 생성하고 반환
        return http.build();
    } // End of securityFilterChain method
} // End of SecurityConfig class
