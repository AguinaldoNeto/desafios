package aguinaldoneto.github.io.btgpactual.orderms.listener;

import aguinaldoneto.github.io.btgpactual.orderms.listener.dto.OrderCreatedEvent;
import aguinaldoneto.github.io.btgpactual.orderms.service.OrderService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


import static aguinaldoneto.github.io.btgpactual.orderms.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    private final OrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Messagem Consumed: {} ", message);

        orderService.save(message.getPayload());
    }

}
