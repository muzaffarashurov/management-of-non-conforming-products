package uz.auto.nonconforming_products.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.auto.nonconforming_products.security.annotation.CurrentUser;
import uz.auto.nonconforming_products.security.model.UserPrincipal;
import uz.auto.nonconforming_products.user.dto.UserSummary;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {

        System.out.println(currentUser.getId());

        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getAuthorities());

        System.out.println(userSummary);
        return userSummary;

    }

}
