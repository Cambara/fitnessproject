package br.com.fitnessproject.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionMD5 {
	private static MessageDigest md = null;
	
	static{
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static char[] hexCodes(byte[] text) { 
		char[] hexOutput = new char[text.length * 2]; 
		String hexString; 
		for (int i = 0; i < text.length; i++) 
		{ 
			hexString = "00" + Integer.toHexString(text[i]); 
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
			}
		return hexOutput; } 
	public static String encrypt(String pwd) 
	{ 
		if (md != null) { 
			return new String(hexCodes(md.digest(pwd.getBytes()))); 
			} 
		return null; }

	
}
