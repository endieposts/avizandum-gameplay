package com.endie.avizandum.gameplay.config;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface WithMockUser {
    String value() default "user";

    String username() default "";

    String[] roles() default {"USER"};

    String password() default "password";
}
