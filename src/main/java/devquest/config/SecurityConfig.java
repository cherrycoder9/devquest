// src\main\java\devquest\config\SecurityConfig.java

package devquest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
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
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                );

        // 설정이 완료된 HttpSecurity 객체를 기반으로 SecurityFilterChain 객체를 생성하고 반환
        return http.build();
    } // End of securityFilterChain method
} // End of SecurityConfig class
