package org.example.karka.mongo.model;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="Data_Model",database ="post_database")
public record DataModel(
    Long id,
    String name
) {}
