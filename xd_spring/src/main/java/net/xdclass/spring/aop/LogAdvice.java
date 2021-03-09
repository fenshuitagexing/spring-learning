package net.xdclass.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component

// 声明切面类，里面可以定义切入点和通知
@Aspect
public class LogAdvice {

    // 切入点表达式
    @Pointcut("execution(* net.xdclass.spring.service.VideoServiceImpl.*(..))")
    public void aspect() {

    }

    // @Before("aspect()")
    @Before("execution(* net.xdclass.spring.service.VideoServiceImpl.*(..))")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice beforeLog");
    }

    @After("aspect()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice afterLog");
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint) {

        Object target = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("调用者： " + target
                + " 方法： " + joinPoint.getSignature()
                + " 参数： " + args[0]);

        long start = System.currentTimeMillis();
        System.out.println("环绕通知 环绕前");

        try {
            ((ProceedingJoinPoint)joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("环绕通知 环绕后");

        System.out.println("time = " + (end - start) + " ms");
    }
}
