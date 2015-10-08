package com.harpoontech.demo.config;

import java.net.URL;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@ConfigurationProperties(prefix = "harpoontech")
public class HarpoonTechProperties {

    @Min(25)
    @Max(2500)
    @NotNull
    private Integer port;

    private URL url;

    @NotNull
    @Size(max = 75)
    private String companyName;

    private String notDescribed;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNotDescribed() {
        return notDescribed;
    }

    public void setNotDescribed(String notDescribed) {
        this.notDescribed = notDescribed;
    }
}
