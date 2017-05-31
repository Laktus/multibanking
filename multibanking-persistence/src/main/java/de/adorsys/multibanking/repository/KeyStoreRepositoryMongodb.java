package de.adorsys.multibanking.repository;

import de.adorsys.multibanking.domain.AccountAnalyticsEntity;
import de.adorsys.multibanking.domain.KeyStoreEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by alexg on 07.02.17.
 */
@Repository
@Profile({"mongo", "fongo"})
public interface KeyStoreRepositoryMongodb extends MongoRepository<KeyStoreEntity, String> {

}
