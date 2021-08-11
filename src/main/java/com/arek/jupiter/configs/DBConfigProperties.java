package com.arek.jupiter.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jdbc")
public class DBConfigProperties {
    private String url;
    private String driver;
    private String user;
    private String password;

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setDriver(final String driver) {
        this.driver = driver;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
