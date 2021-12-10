package com.example.spring4.aspect;

import com.example.spring4.domain.entity.User;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author dkotov
 * @since 09.12.2021
 */
@Aspect
@Component
public class UserAspect {

    @Pointcut("execution(* com.example.spring4.service.UserService.create(..))")
    public void createUserPointcut() {
    }

    @Pointcut("within(com.example.spring4.service.*)")
    public void createUserServicePointcut() {
    }

    @Before(value = "createUserPointcut() && args(user)")
    public void before(User user) {
        System.out.println("before create");
    }

    @Before(value = "createUserPointcut() && args(user)")
    public void before1(User user) {
        System.out.println("before1 create");
    }

    @After(value = "createUserPointcut() && args(user)")
    public void after(User user) {
        System.out.println("after create");
    }

    @AfterThrowing(value = "createUserPointcut() && args(user)")
    public void afterThrowing(User user) {
        System.out.println("afterThrowing create");
    }

    @AfterReturning(value = "createUserPointcut() && args(user)")
    public void afterReturning(User user) {
        System.out.println("afterReturning create");
    }

    @SneakyThrows
    @Around(value = "createUserPointcut() && args(user)")
    public Object around(final ProceedingJoinPoint joinPoint, final User user) {
        //before
        System.out.println("before around create");
        final Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            //afterThrowing
            //after
            throw throwable;
        }
        //after
        //afterReturning
        System.out.println(" create");
        return result;
    }

}
