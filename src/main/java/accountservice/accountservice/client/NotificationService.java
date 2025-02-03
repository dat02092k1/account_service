package accountservice.accountservice.client;

import accountservice.accountservice.model.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:9083")
public interface NotificationService {
    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}
