/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-20 01:18:20
 * @modify date 2020-09-20 01:18:20
 * @desc Custom AOP logger
 */
package com.cg.inventoryauthservice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class CustomLogger {

  @Pointcut("execution(* com.cg.*.*.*.*(..)))")
  public void everyWhere() {
  }

  @Before("everyWhere()")
  public void logBefore(JoinPoint point) {
    log.debug("@Before class: " + point.getTarget().getClass().getSimpleName());
    log.debug("@Before method: " + point.getSignature().toShortString());
    log.debug("Arguments: ");
    Object[] objects = point.getArgs();
    for (Object object : objects) {
      log.debug("->" + object);
    }
  }

  @AfterReturning(pointcut = "everyWhere()", returning = "result")
  public void logAfter(JoinPoint point, Object result) {
    log.debug("@AfterReturning class: " + point.getTarget().getClass().getSimpleName());
    log.debug("@AfterReturning method: " + point.getSignature().toShortString());
    log.debug("Returning Value: " + result);
  }

}
