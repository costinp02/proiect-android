package com.example.proiect.products;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Insert
    void insert(Product product);

    @Query("SELECT COUNT(*) FROM Product")
    int getProductCount();

}
