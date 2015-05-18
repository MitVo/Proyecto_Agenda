
package com.agenda.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Fantasma {
    
       //algoritmos
    private String MD2 = "MD2";
    private String MD5 = "MD5";
    private String SHA1 = "SHA-1";
    private String SHA256 = "SHA-256";
    private String SHA384 = "SHA-384";
    private String SHA512 = "SHA-512";

    /***
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     * @param digest arreglo de bytes a convertir
     * @return String creado a partir de <code>digest</code>
     */
    private String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    /***
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     * @param message texto a encriptar
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
     * @return mensaje encriptado
     */
    public String getStringMessageDigest(String message, String algorithm) throws Exception{
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            throw  new Exception(ex.getMessage());
        }
        return toHexadecimal(digest);
    } 

    public String getMD2() {
        return MD2;
    }

    public void setMD2(String MD2) {
        this.MD2 = MD2;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getSHA1() {
        return SHA1;
    }

    public void setSHA1(String SHA1) {
        this.SHA1 = SHA1;
    }

    public String getSHA256() {
        return SHA256;
    }

    public void setSHA256(String SHA256) {
        this.SHA256 = SHA256;
    }

    public String getSHA384() {
        return SHA384;
    }

    public void setSHA384(String SHA384) {
        this.SHA384 = SHA384;
    }

    public String getSHA512() {
        return SHA512;
    }

    public void setSHA512(String SHA512) {
        this.SHA512 = SHA512;
    }
    
    
}
