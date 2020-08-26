package br.com.dgdc.diariobordoapi.domain.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class CriptografiaService {

	public static String criptografar(String senha) {
		MessageDigest md;
		String msgCriptografada = "";
		
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			msgCriptografada = hash.toString(8);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return msgCriptografada;
	}
}
