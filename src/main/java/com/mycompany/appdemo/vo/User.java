/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.vo;

/**
 *
 * @author mkrasilnikov
 */

public class User {
    private String name;
    private Long lastRequest;

    public Long getLastRequest() {
        return lastRequest;
    }

    public void setLastRequest(Long lastRequest) {
        this.lastRequest = lastRequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
