package com.hrms.sample;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    private static LinkRepository linkRepository;

    static {
        MongoClientURI mongoUrl = new MongoClientURI("mongodb://rony:rony123@localhost:27017/?authSource=graphqltest");
        MongoClient mongoClient = new MongoClient(mongoUrl);
        MongoDatabase mongo = mongoClient.getDatabase("graphqltest");
        linkRepository = new LinkRepository(mongo.getCollection("links"));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    public static GraphQLSchema buildSchema () {
        log.info("repository is open", linkRepository);
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository), new Mutation(linkRepository))
                .build()
                .makeExecutableSchema();

    }
}
