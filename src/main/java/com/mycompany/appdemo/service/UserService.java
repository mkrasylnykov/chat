/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.service;

import com.mycompany.appdemo.vo.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkrasilnikov
 */

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    
    public int getSize() {
        return userList.size();
    }
    
    private void addUser(String username) {
        Long time = System.currentTimeMillis();

        User user = new User();
        user.setName(username);
        user.setLastRequest(time);
        userList.add(user);
    }
    
    public void addNewUser(String username) {
        if (getSize() > 0){
            if (null == getUserByName(username)) {
                addUser(username);
            }
        } else {
            addUser(username);
        }
    }
    
    private User getUserByName(String username) {
        if (this.getSize() > 0){
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getName().equals(username)) {
                    return userList.get(i);
                }
            }
        }

        return null;
    }
    
    public Long getLastRequestTime(String username) {
        Long lastTime = 0L;

        if (null != getUserByName(username)) {
            lastTime = getUserByName(username).getLastRequest();
        }

        return lastTime;
    }
    
    public void setLastRequestTime(String username, Long time) {
        getUserByName(username).setLastRequest(time);
    }
}
