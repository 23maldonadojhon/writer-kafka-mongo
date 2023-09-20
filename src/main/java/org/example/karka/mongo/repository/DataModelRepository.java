package org.example.karka.mongo.repository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.example.karka.mongo.model.DataModel;

@ApplicationScoped
public class DataModelRepository implements ReactivePanacheMongoRepository<DataModel> {

    public Uni<Void> save(DataModel dataModel){
        return persist(dataModel).map(item->null);
    }

}
