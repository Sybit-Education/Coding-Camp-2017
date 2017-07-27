package com.sybit.r750explorer;

/**
 * Created by fzr on 06.03.17.
 */
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Application extends SpringBootServletInitializer {

    @Autowired
    private CacheManager cacheManager;

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Scheduled(fixedRate = 10 * 60 * 1000, initialDelay = 500)
    public void clearChache() {
        log.info("Flush Cache " + new Date());
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
    }

}
