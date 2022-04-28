package com.saumya.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public interface Encryption {
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		// Step - 1: Let know the fact, which algorithm you would like MessageDigest to use.
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		// Step - 2: Update messageDigest with the plainPassword so received, and make sure to send it in form of bytes.
		messageDigest.update(plainPassword.getBytes());
		// Step - 3: Store the encrypted password in an array of bytes, by letting the MessageDigest to digest the password.
		byte[] encrypt = messageDigest.digest();
//		[B@dskdjskd
		// Step - 4: Convert the byte array to a string and then store it in encryptedPassword variable.
		StringBuffer stringBuffer = new StringBuffer();
		for(byte b : encrypt) {
			stringBuffer.append(b);
		}
		
//		encryptedPassword = String.valueOf(encrypt);
		encryptedPassword = stringBuffer.toString();
		return encryptedPassword;
	}
	
}
