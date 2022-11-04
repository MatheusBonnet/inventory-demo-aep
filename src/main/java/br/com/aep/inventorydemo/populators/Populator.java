package br.com.aep.inventorydemo.populators;

import org.springframework.stereotype.Service;

@Service
public interface Populator<SOURCE, TARGET>{

    void populate(SOURCE source, TARGET target);

}