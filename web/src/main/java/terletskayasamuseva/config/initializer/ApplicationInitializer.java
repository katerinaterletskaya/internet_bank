package terletskayasamuseva.config.initializer;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import terletskayasamuseva.config.AppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        encodingFilter(servletContext);
    }

    private void encodingFilter(ServletContext servletContext){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");

        FilterRegistration.Dynamic apiLoggingFilter=servletContext.addFilter(
                "encodingFilter",
                filter
        );
        apiLoggingFilter.addMappingForUrlPatterns(
                null,
                false,
                "/*"
        );
    }
}
