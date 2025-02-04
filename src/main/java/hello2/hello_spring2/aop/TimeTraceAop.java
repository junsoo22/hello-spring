package hello2.hello_spring2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.instrument.classloading.SimpleThrowawayClassLoader;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello2.hello_spring2.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start=System.currentTimeMillis();
        System.out.println("Start: "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("End: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
