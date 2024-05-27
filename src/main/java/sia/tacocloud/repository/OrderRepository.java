package sia.tacocloud.repository;

import sia.tacocloud.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
