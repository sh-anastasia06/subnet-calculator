package com.network;

public class IPAddress {
    public static int toInt(String ip) {
        String[] octets = ip.split("\\.");
        int result = 0;

        for (int i = 0; i < 4; i++) {
            int octet = Integer.parseInt(octets[i]);

            result |= (octet << (24 - (8 * i)));
        }

        return result;
    }

    public static String toString(int ip) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octet = (ip >>> (24 - (8 * i))); // сдвиг и получение нужных 8 бит
            octet = octet & 0xFF; // обнуление всех битов, кроме последних 8
            result.append(octet);
            if (i != 3) result.append(".");
        }
        return result.toString();
    }
}
