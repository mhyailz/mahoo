package com.utils;


import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * Created by mahoo on 2015/11/12.
 */
public class MahooAppMd5 {


    /**
     * 登录时密码进行加密
     *
     * @param psw 原密码
     * @param key 密钥
     * @return
     */
    public static String encodeMd5Password(String psw, String key) {
        if (StringUtils.isEmpty(psw) || StringUtils.isEmpty(key)) {
            return null;
        }
        String waitingToEncode = psw + key;
        char[] charArray = waitingToEncode.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = digest.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
