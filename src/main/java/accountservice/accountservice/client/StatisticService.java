package accountservice.accountservice.client;

import accountservice.accountservice.model.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", url = "http://localhost:9082", fallback = StatisticServiceFallback.class)
public interface StatisticService {
    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO);
}

@Component
class StatisticServiceFallback implements StatisticService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void add(StatisticDTO statisticDTO) {
        // fallback implementation
        logger.error("Statistic service is not available or slow");
    }
}
