/**
 * Title: DemoConsumer.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gigold.pay.demo.rpc.IDemoDubboService;
import com.gigold.pay.framework.core.exception.PendingException;

/**
 * Title: DemoConsumer<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月28日下午3:08:21
 *
 */
public class DemoConsumer {
    
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext(new String[] {"/spring/Democonsumer.xml"});
        context.start();
 
        IDemoDubboService demoService = (IDemoDubboService)context.getBean("aaaService");// 获取远程服务代理
        String hello = demoService.sayHello("world");// 执行远程方法
 
        System.out.println( hello );// 显示调用结果
        
       try{
         hello = demoService.sayHello2("world");// 执行远程方法
        
        System.out.println( hello );// 显示调用结果
       }catch(PendingException e){
           System.out.println(e.getMessage());
           e.printStackTrace();
       }
    }
}
