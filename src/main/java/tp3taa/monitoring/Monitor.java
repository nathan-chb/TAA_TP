package tp3taa.monitoring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitor {

    @Before(" execution(* tp3taa..*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("Class : " + joinPoint.getTarget() + ", method : " + joinPoint);
    }

    @Around("traceInvocationPointcut()")
    public void check(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - start;

            System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Pointcut("execution(* tp3taa.classes.Client.run())")
    public void traceInvocationPointcut() {
    }
}
