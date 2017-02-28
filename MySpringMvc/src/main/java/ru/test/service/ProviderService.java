package ru.test.service;

import ru.test.model.Provider;

import java.util.List;

public interface ProviderService {
    public List<Provider> findAll();
    public Provider findById(Long id);
    public Provider save(Provider provider);
    public void delete(Provider provider);
}