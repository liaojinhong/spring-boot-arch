package com.me.demo.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * 公钥加密，私钥解密工具类
 */
public class KeysRSAUtil {


    // 密钥长度
    private static final int KEYSIZE = 1024;

    public static String readKeyFile(InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readLine;
        StringBuilder sb = new StringBuilder();
        while ((readLine = br.readLine()) != null) {
            if (readLine.charAt(0) == '-') {
                continue;
            } else {
                sb.append(readLine);
                sb.append('\r');
            }
        }
        return sb.toString();
    }

    /**
     * 根据密钥地址获得密钥
     *
     * @param privateKeyPath
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKeyPath) {
        try {
            File f = new File(privateKeyPath);
            InputStream fis = new FileInputStream(f);
            byte[] keyBytes = Base64.decodeBase64(readKeyFile(fis).getBytes("UTF-8"));
            fis.close();
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据公钥地址获得公钥
     * s
     * @param publicKeyPath
     * @return
     */
    public static PublicKey getPublicKey(String publicKeyPath) {
        try {
            File f = new File(publicKeyPath);
            InputStream fis = new FileInputStream(f);
            byte[] keyBytes = Base64.decodeBase64(readKeyFile(fis).getBytes("UTF-8"));
            fis.close();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(spec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据公钥加密
     *
     * @param input
     * @param keyPath
     * @return
     */
    public static String encryptionByPub(String input, String keyPath) {
        try {
            PublicKey publicKey = getPublicKey(keyPath);
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPublicKey pubKey = (RSAPublicKey) publicKey;
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            int maxBlockSize = KEYSIZE / 8 - 11;
            int inputLen = input.getBytes("UTF-8").length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            for(int i = 0; inputLen - offSet > 0; offSet = i * maxBlockSize) {
                byte[] cache;
                if(inputLen - offSet > maxBlockSize) {
                    cache = cipher.doFinal(input.getBytes("UTF-8"), offSet, maxBlockSize);
                } else {
                    cache = cipher.doFinal(input.getBytes("UTF-8"), offSet, inputLen - offSet);
                }

                out.write(cache, 0, cache.length);
                ++i;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return new String(Base64.encodeBase64(encryptedData),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据私钥解密
     *
     * @param input
     * @param keyPath
     * @return
     */
    public static String decryptionByPriv(String input, String keyPath) {
        try {
            PrivateKey privateKey = getPrivateKey(keyPath);
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPrivateKey privKey = (RSAPrivateKey) privateKey;
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            int maxBlockSize = KEYSIZE / 8;
            byte[] cipherText = Base64.decodeBase64(input.getBytes("UTF-8"));
            int inputLen = cipherText.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            for(int i = 0; inputLen - offSet > 0; offSet = i * maxBlockSize) {
                byte[] cache;
                if(inputLen - offSet > maxBlockSize) {
                    cache = cipher.doFinal(cipherText, offSet, maxBlockSize);
                } else {
                    cache = cipher.doFinal(cipherText, offSet, inputLen - offSet);
                }

                out.write(cache, 0, cache.length);
                ++i;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
