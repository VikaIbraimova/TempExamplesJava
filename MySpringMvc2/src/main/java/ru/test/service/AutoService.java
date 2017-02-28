package ru.test.service;

import ru.test.model.Auto;
import java.util.List;


public interface AutoService {
    public List<Auto> findAll();
    public Auto findById(Long id);
    public Auto save(Auto auto);
    public void delete(Auto auto);
}
