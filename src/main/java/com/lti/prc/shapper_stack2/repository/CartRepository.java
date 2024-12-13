package com.lti.prc.shapper_stack2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lti.prc.shapper_stack2.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
