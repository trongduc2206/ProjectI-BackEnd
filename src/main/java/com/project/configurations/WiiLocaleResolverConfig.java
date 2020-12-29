package com.project.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Slf4j
@Configuration
public class WiiLocaleResolverConfig extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Value("${message.default.locale}")
    private String default_local;

    List<Locale> LOCALES = Arrays.asList(
            new Locale("vi"),
            new Locale("en"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        Locale myLocale =  headerLang == null || headerLang.isEmpty()
                ? new Locale(default_local, "VN")
                : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
        log.info("Locale process {}",myLocale.getLanguage());
        return myLocale;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("i18n/messages");
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }
}
