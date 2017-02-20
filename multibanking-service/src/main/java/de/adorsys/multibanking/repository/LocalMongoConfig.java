package de.adorsys.multibanking.repository;

import com.mongodb.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexg on 08.02.17.
 */
@Configuration
@PropertySource(value = "classpath:/mongo.properties")
public class LocalMongoConfig {

    @Autowired
    Environment env;

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(50);
        builder.writeConcern(WriteConcern.JOURNALED);
        builder.readPreference(ReadPreference.secondaryPreferred());
        MongoClientOptions options = builder.build();

        MongoCredential mongoCredential = MongoCredential
                .createMongoCRCredential(env.getProperty("mongo.userName"), env.getProperty("mongo.databaseName"),
                        env.getProperty("mongo.password").toCharArray());

        if (mongoCredential.getUserName().isEmpty()) {
            return new MongoClient(
                    new ServerAddress(env.getProperty("mongo.server"), Integer.parseInt(env.getProperty("mongo.port"))),
                    options);
        } else {
            return new MongoClient(
                    new ServerAddress(env.getProperty("mongo.server"), Integer.parseInt(env.getProperty("mongo.port"))),
                    Arrays.asList(mongoCredential),
                    options);
        }
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient(),
                env.getProperty("mongo.databaseName"));

        return mongoDbFactory;

    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new ContinueOnBatchErrorTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    private class ContinueOnBatchErrorTemplate extends MongoTemplate {

        private static final String ID_FIELD = "_id";

        public ContinueOnBatchErrorTemplate(MongoDbFactory mongoDbFactory) {
            super(mongoDbFactory);
        }

        protected List<ObjectId> insertDBObjectList(final String collectionName, final List<DBObject> dbDocList) {
            if (dbDocList.isEmpty()) {
                return Collections.emptyList();
            }

            execute(collectionName, new CollectionCallback<Void>() {
                public Void doInCollection(DBCollection collection) throws MongoException, DataAccessException {
                    MongoAction mongoAction = new MongoAction(null, MongoActionOperation.INSERT_LIST, collectionName, null,
                            null, null);
                    WriteConcern writeConcernToUse = prepareWriteConcern(mongoAction);
                    //TODO remove this bullshit when springframework data supports InsertOptions
                    InsertOptions insertOptions = (new InsertOptions()).writeConcern(writeConcernToUse).continueOnError(collectionName.equals("booking"));

                    WriteResult writeResult = collection.insert(dbDocList, insertOptions);
                    handleAnyWriteResultErrors(writeResult, null, MongoActionOperation.INSERT_LIST);
                    return null;
                }
            });

            List<ObjectId> ids = new ArrayList<ObjectId>();
            for (DBObject dbo : dbDocList) {
                Object id = dbo.get(ID_FIELD);
                if (id instanceof ObjectId) {
                    ids.add((ObjectId) id);
                } else {
                    // no id was generated
                    ids.add(null);
                }
            }
            return ids;
        }
    }
}
