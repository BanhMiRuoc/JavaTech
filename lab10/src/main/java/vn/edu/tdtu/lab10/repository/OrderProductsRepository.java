package vn.edu.tdtu.lab10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab10.model.OrderProducts;

@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}
