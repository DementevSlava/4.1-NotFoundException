package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    //private ProductManager manager = new ProductManager(repository);
    Product product1 = new Book(1, "Гарри Поттер и философский камень", 249, "Дж. К. Роулинг");
    Product product99 = new Book(99, "Гарри Поттер и тайная комната", 249, "Дж. К. Роулинг");
    Product product2 = new Book(2, "Унесенные ветром", 119, "Маргарет Митчелл");
    Product product3 = new Book(3, "Игра престолов", 369, "Джордж Р. Р. Мартин");

    Product product4 = new Smartphone(5, "Samsung Galaxy S20", 69990, "Samsung");
    Product product5 = new Smartphone(6, "Samsung Galaxy A51", 19990, "Samsung");
    Product product6 = new Smartphone(7, "Huawei P40 Pro", 62990, "Huawei");
    Product product7 = new Smartphone(8, "Apple iPhone 11 Pro", 89990, "Apple");
    Product product8 = new Smartphone(9, "Apple iPhone 11", 64990, "Apple");

    @BeforeEach
    void setup() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        repository.save(product8);
        repository.save(product99);
    }

    @Test
    void removeByIdPositive(){
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                product2,
                product3,
                product4,
                product5,
                product6,
                product7,
                product8,
                product99
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNegativ() {
        assertThrows(NotFoundException.class, ()-> repository.removeById(100));
    }
}