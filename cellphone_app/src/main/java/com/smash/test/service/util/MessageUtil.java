package com.smash.test.service.util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import java.util.Locale;

/**
 * Utility class to read values from resource file
 */
@Component
public class MessageUtil {
    private final MessageSourceAccessor messageSourceAccessor;

    public MessageUtil(MessageSource messageSource){
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource, Locale.US);
    }

    public String get(String code){
        return messageSourceAccessor.getMessage(code);
    }
}
