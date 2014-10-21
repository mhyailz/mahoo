package com.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public  class AESEncryptor {
	
	/**
	 * AES加密实现
	 * 注意：如果报异常的话，将返回null
	 */
	public static String enc(String sSrc, String sKey){
		
		// 判断sKey是否为空
		if (sKey == null) {
			return null;
		}
		// 判断sKey是否为16位
		if (sKey.length() != 16) {
			return null;
		}
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher;
		byte[] encrypted;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encrypted = cipher.doFinal(sSrc.getBytes());
		} catch (Exception e) {
			return null;
		}
		
		String relt = byte2hex(encrypted).toLowerCase();
		return relt;
	}

	/**
	 * AES解密实现
	 * 注意：如果报异常的话，将返回null
	 */
	public static String dec(String ciphertext, String sKey) {
		
		try {
			// 判断sKey是否为空
			if (sKey == null) {
				return null;
			}
			// 判断sKey是否为16位
			if (sKey.length() != 16) {
				return null;
			}
			byte[] raw = sKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(ciphertext);
			
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);

			return originalString;

		} catch (Exception ex) {
			return null;
		}
		
	}

	private static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int len = strhex.length();
		if ((len & 1) == 1) {
			return null;
		}
		byte[] b = new byte[len / 2];
		for (int i = 0; i != len / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);
		}
		return b;
	}

	private static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer("");
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs.append("0").append(stmp);
			} else {
				hs = hs.append(stmp);
			}
		}
		return hs.toString().toUpperCase();
	}
	
	public static String getAESKey(String s){
		return s.substring(0, 16);
	}
}
