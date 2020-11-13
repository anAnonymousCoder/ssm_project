package com.ssm.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 加密工具类
 *
 * @author wqy
 * @version 1.0 2020/11/13
 */
public class EncryptUtil {

    //单例
    private EncryptUtil() {
    }

    //MD5加盐
    private static final String salt = "NUIST";

    /**
     * md5加密算法
     *
     * @param password 原密码
     * @return 加密后的32位密码
     */
    public static String encrypt(String password) {
        password = password.concat(salt);
        MessageDigest md5;
        byte[] bytes;
        try {
            md5 = MessageDigest.getInstance("md5");
            bytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] md5Bytes = md5.digest(bytes);
            StringBuilder hexValue = new StringBuilder();
            for (byte b : md5Bytes) {
                int val = ((int) b) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();  //打印错误
            return password;  //没有对应的加密算法则返回原密码
        }
    }

    /**
     * 将输入的密码和数据库中的密码进行比对
     *
     * @param password 输入的密码
     * @param md5      数据库取出的md5密码
     * @return 比对结果
     */
    public static boolean equals(String password, String md5) {
        return md5.contentEquals(encrypt(password));
    }


}
