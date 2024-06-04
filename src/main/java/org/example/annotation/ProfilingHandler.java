package org.example.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilingHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(org.example.annotation.Profiling)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final int COUNT = 10000;

        var signature = (MethodSignature) joinPoint.getSignature();
        var method = signature.getMethod();
        var annotation = method.getAnnotation(Profiling.class);
        var value = annotation.queryType();

        var before = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            joinPoint.proceed();
        }

        var result = joinPoint.proceed();
        var executionTimePerOneCall = (System.currentTimeMillis() - before) / COUNT;

        logger.info(value + " Method execution: " + executionTimePerOneCall + " ms");

        return result;
    }
}
