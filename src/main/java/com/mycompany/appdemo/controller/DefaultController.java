package com.mycompany.appdemo.controller;

import com.mycompany.appdemo.dao.AccountDao;
import com.mycompany.appdemo.dao.AuthorityDao;
import com.mycompany.appdemo.model.Account;
import com.mycompany.appdemo.model.Authority;
import com.mycompany.appdemo.service.MessageService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DefaultController {
    @Autowired
    MessageService messageservice;
    
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AuthorityDao authorityDao;
    
    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;
   
    @Value("${application.lang}")
    private String applicationLang;
    

    
    @RequestMapping(value = "register.htm", method = RequestMethod.GET)
    public ModelAndView getRegister(){
        ModelAndView mav = new ModelAndView("page-register");
        
        return mav;
    }

    @RequestMapping(value = "register.htm", method = RequestMethod.POST)
    public ModelAndView setRegister(
            HttpServletRequest request,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "password1", required = false) String password,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "sec_code", required = false) String sec_code){

        ModelAndView mav;

        Account account = accountDao.getAccount(name);
        if (account == null) {
            account = new Account();
            
            mav = new ModelAndView("page-login");
            
            PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
            String pswdHash = passwordEncoder.encodePassword(password, name);

            account.setUsername(name);
            account.setPassword(pswdHash);
            account.setEmail(email);

            account.setEnabled(true);

            Authority authority = new Authority();
            authority.setAuthority("ROLE_USER");
            authority.setUsername(name);
            
            authorityDao.addAuthority(authority);
            accountDao.addAccount(account);
            
            mav.addObject("userName", name);
        } else {
            mav = new ModelAndView("page-register");
            mav.addObject("userMess", "Данное имя уже зарегистрировано");
        }

        return mav;
    }
    
    @RequestMapping(value = "testuser.htm", method = RequestMethod.POST)
    public ModelAndView getTestUser(
            HttpServletRequest request,
            @RequestParam(value = "name", required = false) String name){

        String infotxt = "";

        Account account = accountDao.getAccount(name);
        if (account == null) {
            infotxt = "<font color = #10AF10>&bull; Такого пользователя ещё нет!</font>";
        } else {
            infotxt = "<font color = #FF0000>&bull; Данное имя уже используется!</font>";
        }

        ModelAndView smd = new ModelAndView("div-info");
        smd.addObject("titletxt", "Проверка текущего имени пользователя:");
        smd.addObject("infotxt", infotxt);
        
        return smd;
    }

    @RequestMapping(value="loginpage.htm", method= RequestMethod.GET)
    public ModelAndView getLoginPage(){
        ModelAndView mav = new ModelAndView("page-login");
        mav.addObject("lang", applicationLang);
        
        return mav;
    }
    
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="color.htm", method= RequestMethod.GET)
    public ModelAndView getColor(){
        ModelAndView mav = new ModelAndView("frame-color");
        
        return mav;
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="smile.htm", method= RequestMethod.GET)
    public ModelAndView getSmile(){
        ModelAndView mav = new ModelAndView("frame-smile");
        
        return mav;
    }
    
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="main.htm", method= RequestMethod.GET)
    public ModelAndView getMain(){
        ModelAndView mav = new ModelAndView("page-main");
        mav.addObject("lang", applicationLang);
        
        return mav;
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="send-msg.htm", method= RequestMethod.POST)
    public ModelAndView addNewMassage(HttpServletRequest request,
		@RequestParam(value = "messages", required = false) String messages) {

        ModelAndView mav= new ModelAndView("div-out");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        
        messageservice.addNewMessage(userName, messageservice.cutMessageSize(messages)).cutMessageListSize();

        mav.addObject("um", messageservice.getDeltaMessageList(userName));

        return mav;
    }
    
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="get-delta-msg.htm", method= RequestMethod.GET)
    public ModelAndView getDeltaMessageList(HttpServletRequest request) {
        ModelAndView mav= new ModelAndView("div-out");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        mav.addObject("um", messageservice.getDeltaMessageList(userName));

        return mav;
    }
    
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="get-all-msg.htm", method= RequestMethod.GET)
    public ModelAndView getMessageList(HttpServletRequest request) {
        ModelAndView mav= new ModelAndView("div-out");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        mav.addObject("um", messageservice.getMessageList(userName));

        return mav;
    }
    
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping(value="who-is-online.htm", method= RequestMethod.POST)
    public ModelAndView getOnline(HttpServletRequest request) {
        ModelAndView mav= new ModelAndView("div-online");
        mav.addObject("lang", applicationLang);
        
        mav.addObject("users", sessionRegistry.getAllPrincipals());

        return mav;
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value="admin-page.htm", method= RequestMethod.GET)
    public ModelAndView getAdminPage(
            @RequestParam(value = "command", required = false, defaultValue = "none") String command){
        ModelAndView mav = new ModelAndView("page-admin");
        String resp_msg = "";
        
        if (command.equals("del_all_msg")){
            messageservice.clearAll();
            resp_msg = "Удалили все сообщения!";
        }

        mav.addObject("resp_msg", resp_msg);

        return mav;
    }
    
}
