package com.fortegroupe.utill;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Provides caching and comparing with a cached password.
 */
public final class PasswordHelper {


    private PasswordHelper() {
    }


    /**
     * Encrypts a given password.
     * After encrypting given password .
     *
     * @param password a String password for encrypting
     * @return a String of encrypted password
     */
    public static String encryptPassword(String password) {
        return DigestUtils.md5Hex(password);
    }







}