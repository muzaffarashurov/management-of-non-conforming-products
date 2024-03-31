package uz.auto.nonconforming_products.security.annotation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
@Target({ElementType.PARAMETER, ElementType.TYPE})
public @interface CurrentUser {
}
