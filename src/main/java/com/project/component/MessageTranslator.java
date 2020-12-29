package com.project.component;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class MessageTranslator {

    private static ResourceBundleMessageSource messageSource;

    public MessageTranslator(ResourceBundleMessageSource _messageSource) {
        this.messageSource = _messageSource;
    }

    public static String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    public String getMessage(String code,Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, locale);
    }
}
