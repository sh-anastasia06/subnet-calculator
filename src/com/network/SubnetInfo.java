package com.network;

public class SubnetInfo {
    private String ip;
    private int prefix;
    private int mask;
    private int network;
    private int broadcast;
    private int firstHost;
    private int lastHost;
    private int usableHosts;

    public SubnetInfo(String ip, int prefix, int mask, int network,
                      int broadcast, int firstHost, int lastHost, int usableHosts){
        this.ip = ip;
        this.prefix = prefix;
        this.mask = mask;
        this.network = network;
        this.broadcast = broadcast;
        this.firstHost = firstHost;
        this.lastHost = lastHost;
        this.usableHosts = usableHosts;
    }

    @Override
    public String toString() {
        return "IP Address      : " + ip +
                "\nSubnet Mask     : " + IPAddress.toString(mask) +
                "\nNetwork Address : " + IPAddress.toString(network) +
                "\nBroadcast       : " + IPAddress.toString(broadcast) +
                "\nFirst Host      : " + IPAddress.toString(firstHost) +
                "\nLast Host       : " + IPAddress.toString(lastHost) +
                "\nUsable Hosts    : " + usableHosts +
                "\nCIDR Notation   : /" + prefix;
    }
}
