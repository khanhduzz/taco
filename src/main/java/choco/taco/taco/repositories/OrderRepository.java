package choco.taco.taco.repositories;

import choco.taco.taco.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

//    List<TacoOrder> findByDeliveryZip (String deliveryZip);

//    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

//    List<TacoOrder> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);

//    TacoOrder save(TacoOrder tacoOrder);

}
