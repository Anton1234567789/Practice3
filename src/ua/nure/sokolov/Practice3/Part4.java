package ua.nure.sokolov.Practice3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        digest.update("password".getBytes());
//        byte[] hash = digest.digest();
//        System.out.println(Arrays.toString(hash));
        long start = System.nanoTime();

        System.out.println(hash("password", "SHA-256"));
        long finish = System.nanoTime();
        long end = finish - start;
        System.out.println(end);

        System.out.println(hash("passwort", "SHA-256"));
        long finish1 = System.nanoTime();
        long end1 = finish1 - start;
        System.out.println(end1);
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        StringBuilder hexStr = new StringBuilder();

        try {
            messageDigest = MessageDigest.getInstance(algorithm);
            byte[] hashByte = messageDigest.digest(input.getBytes());

            for (byte byt : hashByte){
                hexStr.append(byt).append(" ");
//                for (int j = 0; j < hashByte.length; j++){
//                hexStr.append(Integer.toHexString(0x0100 + (hashByte[j] & 0x00FF)).substring(1));
//                }
            }
//            messageDigest.reset();
            messageDigest.update(input.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);

        String algoritmHexInput = bigInt.toString(16);
//        while( algoritmHexInput.length() < 32 ){
//            algoritmHexInput = "0" + algoritmHexInput;
//        }
        return hexStr.toString();
    }
}
