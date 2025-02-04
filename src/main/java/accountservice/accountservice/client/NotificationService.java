package accountservice.accountservice.client;

import accountservice.accountservice.model.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:9083", fallback = NotificationServiceFallback.class)
public interface NotificationService {
    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}

@Component
class NotificationServiceFallback implements NotificationService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendNotification(MessageDTO messageDTO) {
        // fallback implementation
        logger.error("Notification service is not available or slow");
    }
}