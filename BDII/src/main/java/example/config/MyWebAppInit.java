package example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebAppInit implements WebApplicationInitializer {



    public void onStartup(ServletContext servletContext) throws ServletException {

        //create root context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebMvcConfiguration.class);


        //add root context to servlet context as listener
        servletContext.addListener(new ContextLoaderListener(rootContext));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(rootContext)
        );

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }

}
