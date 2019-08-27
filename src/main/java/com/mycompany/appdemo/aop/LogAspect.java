/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 *
 * @author maksym
 */
@Aspect
public class LogAspect {
    @Around("execution(* com.mycompany.appdemo.service.MessageService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        
        String ipAddress = "";
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details instanceof WebAuthenticationDetails)
            ipAddress = ((WebAuthenticationDetails) details).getRemoteAddress();
        
        System.out.println("IP:" + ipAddress + " Time Taken by " + joinPoint + " is " + timeTaken);
        return ret;
    }
}
