package com.orgon;

import com.orgon.config.Config;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicationEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            Config.HOSTNAME = Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Config.PORT = environment.getProperty("local.server.port");

        log.info("Application is running on http://" + Config.HOSTNAME + ":" + Config.PORT + "api/chemtrails");
    }
}
