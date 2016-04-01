package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {ResourceNames.REST_API, ResourceNames.CONTROLLERS, ResourceNames.DAOS, ResourceNames.SERVICES})
public class WebConfig extends WebMvcConfigurerAdapter {

    // CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(3600);
    }
    

    // Web presenters
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    // Thymeleaf
    @Bean
    public TemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    // <bean id="templateResolver" class="org.thymeleaf.templateresolver.ServletContextTemplateResolver">
    // <property name="prefix" value="/WEB-INF/views/" />
    // <property name="suffix" value=".html" />
    // <property name="templateMode" value="HTML5" />
    // </bean>

    // Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    // Thymeleaf
    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[] {"thymeleaf/*"});
        return viewResolver;
    }

    // JSP
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        // Incompatible con "redirect:/action"
        viewResolver.setViewNames("jsp/*", "bootstrap/*");
        return viewResolver;
    }
    // <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    // <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    // <property name="prefix" value="/WEB-INF/jsp/"/>
    // <property name="suffix" value=".jsp"/>
    // </bean>


}
