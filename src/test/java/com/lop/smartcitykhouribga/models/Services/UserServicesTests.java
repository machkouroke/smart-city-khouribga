package com.lop.smartcitykhouribga.models.Services;
import static org.assertj.core.api.Assertions.assertThat;

import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Enum.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.multipart.MultipartFile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserServicesTests {
    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {


        User newUser = new User("Oke",
                "Machkour",
                "machkouroke@gmail.com",
                Role.APPLICANT,
                "test",
                ".jpg",
                ".pdf"
        );

        User savedUser = userService.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
