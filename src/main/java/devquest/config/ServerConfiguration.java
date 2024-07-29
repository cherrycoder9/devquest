// src\main\java\devquest\config\ServerConfiguration.java

package devquest.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// XML 설정의 단점을 보완하고자 도입한 어노테이션
// XML 기반 설정과 달리 Java 코드로 빈을 정의함으로써 컴파일 타임에 타입 오류를 검출
// Spring 컨텍스트에 빈을 등록할 때 사용
// Spring 컨텍스트란 애플리케이션에서 객체를 생성하고 구성하며 관리하는 역할
// 애플리케이션의 전반적인 설정과 빈을 정의하고 관리하는 중앙 저장소로 작동함
// @Profile 어노테이션을 함께 사용하면 개발, 테스트, 프로덕션 환경별로 다른 설정 적용 가능
// @Configuration 클래스는 내부적으로 @Component 어노테이션을 사용하므로 Spring의 컴포넌트 스캔에 의해 관리됨
// 동일한 이름의 빈을 여러 곳에서 정의하면 충돌이 발생할 수 있으니 주의
@Configuration
public class ServerConfiguration {

    // XML 설정 파일 대신 자바 클래스를 사용해 구성 정보를 정의하고자 할 때 사용
    // 빈의 초기화가 복잡하거나 외부 라이브러리 객체를 스프링 빈으로 등록해야 할 때 유용
    // 특정 조건에서만 빈을 등록하고자 할때는 @Conditional 과 함께 사용될 수 있음
    // @Bean(name = "beanName")과 같이 이름을 명시적으로 지정할 수 있음
    // 기본적으로 @Bean은 싱글톤 스코프를 가짐. 따라서 상태를 가지는 객체를 빈으로 등록시 주의
    // @Scope 어노테이션을 사용해 프로토타입 스코프를 명시할 수 있음
    // @Autowired를 이용해 다른 빈을 주입받을 때는 반드시 필요한 빈이 모두 등록되었는지 확인해야 함
    // 순환 의존성 문제가 생길 수 있는데 방지하기 위해서는 @Lazy 어노테이션을 활용할 수 있음
    // @Bean 메서드에서 비동기 처리가 필요한 경우 @Async를 적절히 활용해야 함
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
        // TomcatServletWebServerFactory: Apache Tomcat을 내장 서버로 사용하기 위한 스프링 부트의 구성 요소
        // Tomcat 서버를 쉽게 설정하고 커스터마이징할 수 있게 해줌
        // WebServerFactoryCustomizer: 스프링 부트(Spring Boot)에서 내장 웹 서버의 설정을 커스터마이징하기 위해 사용되는 인터페이스
        // 기본 설정 파일에서 제공되지 않는 특정 설정을 적용해야 할 때 사용
        // 서버 초기화 시점에 특정 로직을 추가하거나 설정을 적용해야 할 때
        System.out.println("ServerConfiguration.servletContainer");
        return factory -> factory.addAdditionalTomcatConnectors(createStandardConnector());
    } // End of servletContainer method

    private Connector createStandardConnector() {
        System.out.println("ServerConfiguration.createStandardConnector");
        final Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(8080); // HTTP 포트
        return connector;
    } // End of createStandardConnector method
} // End of ServerConfiguration class

