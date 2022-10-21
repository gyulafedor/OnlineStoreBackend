package com.example.gyula.fedor.OnlineStore.cartElements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartElementsRepository extends JpaRepository<CartElements, Long> {
}
