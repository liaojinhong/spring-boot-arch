package com.me.demo.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DES加密算法
 * 
 * @author ljh
 *
 */
public class KeysDESUtil {

	private static final Log logger = LogFactory.getLog(KeysDESUtil.class);

	// TODO: decide which algorithm to use
	// TODO: make this setting configurable
	private static final String ENCRYPTION_ALGORITHM = "DES";
	// TODO: choose a better key
	// TODO: make this setting configurable
	private static final String key = "1234567890";

	/**
	 * Try to encrypt data using DES algorithm and a shared key.
	 * 
	 * @param data
	 *            the text to be encrypted
	 * @return encrypted data if success, otherwise null
	 */
	public static String encrypt(String data) {
		try {
			return encryptInternal(data);
		} catch (Exception ignored) {
			logger.debug("Encryption fails");
		}

		return null;
	}

	/**
	 * Try to decrypt data using DES algorithm and a shared key.
	 * 
	 * @param data
	 *            encrypted data
	 * @return decrypted data if success, otherwise null
	 */
	public static String decrypt(String data) {
		try {
			return decryptInternal(data);
		} catch (Exception ignored) {
			logger.debug("Decryption fails");
		}

		return null;
	}

	private static String encryptInternal(String data)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidKeySpecException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {
		if (data == null) {
			return null;
		}
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, getKey());
		byte[] original = data.getBytes();
		byte[] encrypted = cipher.doFinal(original);

		return Base64Utils.encode(encrypted);
	}

	private static String decryptInternal(String data)
			throws NoSuchPaddingException, NoSuchAlgorithmException,
			BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException, InvalidKeyException {
		if (data == null) {
			return null;
		}
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, getKey());
		Base64Utils.decode(data.toCharArray());
		byte[] encrypted = Base64Utils.decode(data.toCharArray());
		;
		byte[] decrypted = cipher.doFinal(encrypted);

		return new String(decrypted);
	}

	private static Key getKey() throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException {
		DESKeySpec keySpec = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(ENCRYPTION_ALGORITHM);

		return keyFactory.generateSecret(keySpec);
	}
}
