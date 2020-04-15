package name.electricalqzhang.springbootlearn.workers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
//@EnableScheduling
@Slf4j
@EnableAsync
public class ClearnOrderSkuEsJob {
    private boolean clean = true;

    @Scheduled(cron = "0/25 * * * * ?")
    @Async
    public void stopCleanTask() {
        clean = false;
        log.info("stop clean task");
    }

    @Scheduled(cron = "0 * * * * ?")
    @Async
    public void clean() {
        clean = true;
        for (int i = 0; i < 50; i++) {
            if (clean == false) {
                return;
            }
            log.info("Scheduled task i={}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("thread sleep error", e);
            }
        }
    }
}
