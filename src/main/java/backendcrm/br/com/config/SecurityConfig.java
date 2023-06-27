package backendcrm.br.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**", "/cupom/**", "/cliente/**", "/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().sameOrigin();
    }
    @Primary
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate rt = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        rt.setRequestFactory(requestFactory);
        return rt;
    }
}