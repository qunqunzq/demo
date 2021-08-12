package com.example.demo.jd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张群
 * @version 1.0
 * @date 2021/8/12 4:53 下午
 */
@RestController
@RequestMapping("/jd")
public class Controller {



    @GetMapping("/ps")
    public String ps() throws IOException, URISyntaxException, InterruptedException, ParseException {
        Start.pid="100019378198";
        CookieHandler.setDefault(Start.manager);
        Login.login();
        Start.judgePruchase("100019378198");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new RushToPurchase());
        }
        return "success";
    }

    @GetMapping("/maotai")
    public String maotai() throws IOException, URISyntaxException, InterruptedException, ParseException  {
        Start.pid="100012043978";
        CookieHandler.setDefault(Start.manager);
        Login.login();
        Start.judgePruchase("100012043978");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new RushToPurchase());
        }
         return "success";
    }
}