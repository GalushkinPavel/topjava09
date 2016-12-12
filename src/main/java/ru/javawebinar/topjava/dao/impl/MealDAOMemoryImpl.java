package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAOMemoryImpl implements MealDAO {
    private AtomicInteger id = new AtomicInteger(0);
    private final List<Meal> meals;

    public MealDAOMemoryImpl() {
        this.meals = Collections.synchronizedList(Arrays.asList(
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2016, Month.APRIL, 20, 10, 0), "Завтрак", 400),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2016, Month.APRIL, 20, 13, 0), "Обед", 500),
                new Meal(id.incrementAndGet(), LocalDateTime.of(2016, Month.APRIL, 20, 20, 0), "Ужин", 910)
        ));
    }

    @Override
    public List<Meal> getAllMeal() {
        return meals;
    }
}
