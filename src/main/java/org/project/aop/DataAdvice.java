package org.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//可以对异常进行处理
@Component
@Aspect
public class DataAdvice {
    //  切入点表达式标准格式︰动作关键字（访问修饰符   返回值   包名.类/接口名.方法名（参数）异常名)
    //@Pointcut("execution(boolean org.project.service.*Service.*(*,*))")
    /*切入点表达式书写技巧
    1.按标准规范开发
    2.查询操作的返回值建议使用*匹配
    3.减少使用..的形式描述包
    4.对接口进行描述，使用*表示模块名，例如UserService的匹配描述为*Service
    5.方法名书写保留动词，例如get，使用*表示名词，例如getById匹配描述为getBy*
    6.参数根据实际情况灵活调整  */
    @Pointcut("")//“”双引号里写入对方法名的匹配
    private void servicePt(){}

    @Around("DataAdvice.servicePt()")//环绕通知
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            //判断参数是不是字符串
            if(args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }
        Object ret = pjp.proceed(args);//对原始方法的调用
        return ret;
    }
    //另一种方式
    @Around("")//环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");//前置通知
            result = joinPoint.proceed();//目标对象（连接点）方法的执行
            System.out.println("环绕通知-->目标对象方法返回值之后");//返回通知
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");//异常通知
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");//后置通知
        }
        return result;
    }
}
