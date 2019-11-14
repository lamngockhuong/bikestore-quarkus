//package com.ngockhuong.resource;
//
//import com.coxautodev.graphql.tools.SchemaParser;
//import com.ngockhuong.repository.LinkRepository;
//import com.ngockhuong.resolver.Query;
//import graphql.schema.GraphQLSchema;
//import graphql.servlet.SimpleGraphQLServlet;
//
//import javax.servlet.annotation.WebServlet;
//
//@WebServlet(urlPatterns = "/graphql")
//public class GraphQLEndpoint extends SimpleGraphQLServlet {
//    public GraphQLEndpoint() {
//
//        super(buildSchema());
//    }
//
//    private static GraphQLSchema buildSchema() {
//        LinkRepository linkRepository = new LinkRepository();
//        return SchemaParser.newParser()
//                .file("schema.graphqls")
//                .resolvers(new Query(linkRepository))
//                .build()
//                .makeExecutableSchema();
//    }
//}
