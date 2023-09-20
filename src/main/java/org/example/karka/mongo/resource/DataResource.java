package org.example.karka.mongo.resource;


import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.karka.mongo.model.DataModel;
import org.example.karka.mongo.repository.DataModelRepository;
import org.example.karka.mongo.service.KafkaService;

@Path("/reactive")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataResource {

    @Inject
    KafkaService kafkaService;

    @Inject
    DataModelRepository dataModelRepository;

    @POST
    public Uni<Void> add(DataModel dataModel){

        Uni<Void> mongoResult = dataModelRepository.save(dataModel);

        Uni<Void> kafkaResult = kafkaService.sendMessage(dataModel);

        return Uni.combine().all().unis(kafkaResult, mongoResult).discardItems();

    }

}
