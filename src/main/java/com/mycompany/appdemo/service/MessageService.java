/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.service;

import com.mycompany.appdemo.util.MUtil;
import com.mycompany.appdemo.vo.UserMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkrasilnikov
 */

@Service
public class MessageService {
    @Autowired
    UserService userservice;
    
    private List<UserMessage> messageList= new ArrayList<>();
    
    @Value("${message.messageSize:1000}")
    private int messageSize;
    
    @Value("${message.messageListSize:100}")
    private int messageListSize;
    

    public MessageService addNewMessage(String username, String message) {
        Long time = System.currentTimeMillis();

        if (!message.isEmpty()) {
            UserMessage um = new UserMessage();
            um.setTimeMS(time);
            um.setTime(MUtil.now(1));
            um.setName(" " + username + ":");
            um.setMessage(replMessageRegEx(message));

            messageList.add(um);
        }
        return this;
    }
    
    public int getSize() {
        return messageList.size();
    }

    public List<UserMessage> getMessageList(String userName) {
         userservice.addNewUser(userName);
        return messageList;
    }
    
    public List<UserMessage> getDeltaMessageList(String userName) {
        Long timeLast = userservice.getLastRequestTime(userName);
        userservice.setLastRequestTime(userName, System.currentTimeMillis());

        return getMessagesByTimeMS(timeLast);
    }
    
    public List<UserMessage> getMessagesByTimeMS(Long timeMS) {
        List<UserMessage> newMsg = new ArrayList<>();

        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getTimeMS() > timeMS) {
                newMsg.add(messageList.get(i));
            }
        }

        return newMsg;
    }
    
    public void clearAll() {
        messageList.clear();
    }
    
    public void cutMessageListSize() {
        if (messageList.size() > messageListSize) {
            messageList.remove(0);
        }
    }

    public String cutMessageSize(String message) {
        if (message.length() > messageSize){ message = message.substring(1, messageSize); }
        return message;
    }
    
    private static String replMessageRegEx(String mes) {
        mes = MUtil.bbcode(mes);
        
        String FLINK = "-(\\d{6})-";
        Pattern pattern = Pattern.compile(FLINK);
        Matcher matcher = pattern.matcher(mes);
        String FRAGMENT = "<img src=\"img/smile/$1.gif\">";

        return matcher.replaceAll(FRAGMENT);
    }
}
