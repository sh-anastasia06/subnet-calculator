package com.network;

public class SubnetCalculator {
    public static int getMask(int prefix) {
        if (prefix == 0) return 0;
        return (int) 0xFFFFFFFF << (32 - prefix);
    }

    public static SubnetInfo calculate(String ip, int prefix) {
        int ipInt = IPAddress.toInt(ip);
        int mask = getMask(prefix);

        int network = ipInt & mask;
        int broadcast = network | ~mask; // ~ replace all 0 to 1, and 1 to 0
        int firstHost = network + 1;
        int lastHost = broadcast - 1;
        int usable = lastHost - firstHost + 1;

        return new SubnetInfo(ip, prefix, mask, network, broadcast, firstHost, lastHost, usable);
    }
}
