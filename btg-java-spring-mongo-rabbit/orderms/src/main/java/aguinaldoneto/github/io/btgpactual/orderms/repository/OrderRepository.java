package aguinaldoneto.github.io.btgpactual.orderms.repository;

import aguinaldoneto.github.io.btgpactual.orderms.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
