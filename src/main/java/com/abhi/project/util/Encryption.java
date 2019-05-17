package com.abhi.project.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
public class Encryption
{
	public String getHash(byte[] pwd)
	{
		String hashpwd="";
		
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			md.update(pwd);
			byte[] digestedBytes=md.digest();
			hashpwd=DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashpwd;
		
	}
}