package com.appcoy.ace.api.repository;

import com.appcoy.ace.api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ItemRepository extends JpaRepository<Item, Long> {

}
