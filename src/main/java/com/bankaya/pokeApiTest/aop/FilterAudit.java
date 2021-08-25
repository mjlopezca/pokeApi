package com.bankaya.pokeApiTest.aop;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bankaya.pokeApiTest.model.Audit;
import com.bankaya.pokeApiTest.service.AuditService;

/**
 * @author dakze
 *
 */
@Aspect
@Component
public class FilterAudit {

    @Autowired
    private HttpServletRequest httpServletRequest;
    
    @Autowired
    AuditService auditService;
    
    /**
     * catch all request and response and save audit
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.bankaya.pokeApiTest.endpoint.*.*(*))")
   	public Object tiempoPasado(ProceedingJoinPoint point) throws Throwable {

    	try {
            final Object retVal = point.proceed(); point.proceed();                       
			Audit audit= Audit.builder().method(point.getSignature().getName()).originIp( httpServletRequest.getRemoteAddr()).build();    
            auditService.saveAudit(audit);
            return retVal;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
   	}
    
  

}
