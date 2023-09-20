package org.example.karka.mongo.service;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.example.karka.mongo.model.DataModel;

@ApplicationScoped
public class KafkaService {


    @Inject
    @Channel("qui-eve")
    MutinyEmitter<DataModel> kafkaEmitter;

    public Uni<Void> sendMessage(DataModel data) {
        return kafkaEmitter.send(data).map(item->null);
    }

}
