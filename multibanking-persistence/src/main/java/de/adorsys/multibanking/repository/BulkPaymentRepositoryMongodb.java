package de.adorsys.multibanking.repository;

import de.adorsys.multibanking.domain.BulkPaymentEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexg on 07.02.17.
 */
@Repository
@Profile({"mongo", "fongo"})
public interface BulkPaymentRepositoryMongodb extends MongoRepository<BulkPaymentEntity, String> {


}
