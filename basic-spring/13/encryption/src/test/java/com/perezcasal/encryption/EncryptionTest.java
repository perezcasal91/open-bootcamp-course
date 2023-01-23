package com.perezcasal.encryption;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.test.context.annotation.SecurityTestExecutionListeners;

import java.util.HashMap;
import java.util.Map;

@SecurityTestExecutionListeners
public class EncryptionTest {

    @Test
    void bCryptTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode("admin");
        System.out.println(encryptedPassword);

        boolean match = bCryptPasswordEncoder.matches("admin", encryptedPassword);
        System.out.println(match);
    }

    @Test
    void bCryptCheckMultipleTimeTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            String encryptedPassword = bCryptPasswordEncoder.encode("admin");
            System.out.println(encryptedPassword);
        }
    }

    @Test
    void pBKDF2Test() {
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        String encryptedPassword = pbkdf2PasswordEncoder.encode("admin");
        System.out.println(encryptedPassword);

        boolean match = pbkdf2PasswordEncoder.matches("admin", encryptedPassword);
        System.out.println(match);
    }

    @Test
    void sCryptTest() {
        SCryptPasswordEncoder sCryptPasswordEncoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
        String encryptedPassword = sCryptPasswordEncoder.encode("admin");
        System.out.println(encryptedPassword);

        boolean match = sCryptPasswordEncoder.matches("admin", encryptedPassword);
        System.out.println(match);
    }

    @Test
    void argon2Test() {
        Argon2PasswordEncoder argon2PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        String encryptedPassword = argon2PasswordEncoder.encode("admin");
        System.out.println(encryptedPassword);

        boolean match = argon2PasswordEncoder.matches("admin", encryptedPassword);
        System.out.println(match);
    }

    @Test
    void stringEncryptAlgorithmsTest() {

        var encryptAlgorithms = new HashMap<String, PasswordEncoder>();
        encryptAlgorithms.put("bcrypt", new BCryptPasswordEncoder());
        encryptAlgorithms.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        encryptAlgorithms.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
        encryptAlgorithms.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());

        DelegatingPasswordEncoder delegatingPasswordEncoder = new DelegatingPasswordEncoder("bcrypt", encryptAlgorithms);
        String encryptedPassword = delegatingPasswordEncoder.encode("admin");
        System.out.println(encryptedPassword);

        boolean match = delegatingPasswordEncoder.matches("admin", encryptedPassword);
        System.out.println(match);
    }

}
