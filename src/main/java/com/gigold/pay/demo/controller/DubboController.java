/**
 * Title: DubboController.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gigold.pay.demo.rpc.IDemoDubboService;


import com.gigold.pay.framework.base.log.impl.BizLogger;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.AbortException;


/**
 * Title: DubboController<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * 
 * @author Devin
 * @date 2015年9月29日上午11:57:05
 *
 */
@Controller
@RequestMapping("/")
public class DubboController {
    
    
    
    
    @Reference(version="1.0")
    private IDemoDubboService doubboService;
    /**
     * Title: query<br/>
     * Description: <br/>
     * 
     * @author ousei
     * @date 2014年12月15日下午9:05:03
     *
     * @param acNo
     *            账号
     * @return ${返回信息描述}
     * @throws Exception
     */
    @RequestMapping(value = "/rpc.do")
    public @ResponseBody DubboDemoResDto query() {

        BizLogger.info("调用query：");
        doubboService.sayHello("world");
        DubboDemoResDto res = new DubboDemoResDto();
        res.setRspCd(SysCode.SUCCESS);
        return res;
    }
    
    
    @RequestMapping(value = "/rpcadd.do")
    public @ResponseBody DubboDemoResDto add() {

        BizLogger.info("调用query：");
        try {
            doubboService.getUsers();
        } catch (AbortException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DubboDemoResDto res = new DubboDemoResDto();
        res.setRspCd(SysCode.SUCCESS);
        return res;
    }

}
