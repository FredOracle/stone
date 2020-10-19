package com.example.demo.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Fred
 */

public enum ServiceType {
    DISCARD("Discard", "discard"),
    PASSTHROUGH("Passthrough", "passthrough"),
    INTERNET("Internet", "internet"),
    CLOUD("Cloud", "cloud"),
    INTRANET("Intranet", "intranet"),
    CONDUIT("Conduit", "conduit"),
    LAN_GRE_TUNNEL("LAN GRE Tunnel", "lan_gre_tunnel"),
    LAN_IPSEC_TUNNEL("LAN IPsec Tunnel", "lan_ipsec_tunnel"),
    LOCAL("Local", "local"),
    IPHOST("IP Host", "iphost"),
    ANY("Any", "any");

    private String literalString;

    private String value;


    public String getLiteralString() {
        return literalString;
    }

    public void setLiteralString(String literalString) {
        this.literalString = literalString;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private static final class StaticFields {
        private static Map<String, ServiceType> enumByValue = new HashMap<>();
    }

    private ServiceType(String literalString, String value) {
        this.literalString = literalString;
        this.value = value;
        StaticFields.enumByValue.put(value, this);
    }

    public static ServiceType fromValue(String value) {
        return StaticFields.enumByValue.get(value);
    }
}
