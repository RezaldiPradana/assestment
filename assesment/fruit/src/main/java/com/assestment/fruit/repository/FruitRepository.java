package com.assestment.fruit.repository;

import com.assestment.fruit.model.Fruit;

import java.util.List;

public interface FruitRepository  {
    // additional queries if needed
    Fruit findFruitBySeqId(String seqId);
    void insertFruit(Fruit fruit);
    void updateFruit(Fruit fruit);
    void deleteFruit(String seqId);
}