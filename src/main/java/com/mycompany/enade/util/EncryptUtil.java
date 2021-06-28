package com.mycompany.enade.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class EncryptUtil {

    public static String encrypt(String value) {
        return Hashing.sha256().hashString(value, StandardCharsets.UTF_8).toString();
    }
    
}
