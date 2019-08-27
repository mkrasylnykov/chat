/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.vo;

/**
 *
 * @author mkrasilnikov
 */

public class UserMessage {
    private String time;
    private String name;
    private String message;
    private Long timeMS;

    public Long getTimeMS() {
        return timeMS;
    }

    public void setTimeMS(Long timeMS) {
        this.timeMS = timeMS;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
