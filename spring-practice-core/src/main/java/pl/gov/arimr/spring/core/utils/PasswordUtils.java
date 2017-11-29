package pl.gov.arimr.spring.core.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class PasswordUtils {

    public static String getPassword(final String password) {
        try {
            byte[] passwordBytes = password.getBytes("UTF-8");
            return DigestUtils.md5DigestAsHex(passwordBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
