package bsu.rfe.java.group7.lab7.Bibikov.varA;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class CorrectIP {
    public static boolean isCorrectIpAdress(String ip) {
        try {
            return !Inet4Address.getByName(ip)
                    .getHostAddress().equals(ip);
        } catch (UnknownHostException ex) {
            return true;
        }
    }
}