package com.Jobsearch.demo.Service;


import com.Jobsearch.demo.DAO.PostDao;
import com.Jobsearch.demo.DAO.SearchPostDao;
import com.Jobsearch.demo.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService implements SearchPostDao {

    @Autowired
    PostDao dao ;

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    public List<Post> getPosts (){
       return dao.findAll();
    }

    public Post setPost(Post p){

        return dao.save(p);
    }

    public List<Post> SearchPost(String text){

        return this.findByText(text);
    }

    public List<Post> findByText(String text){
        List<Post> searched= new ArrayList<>();
        MongoDatabase database= this.client.getDatabase("Demo");
        MongoCollection<Document> collection = database.getCollection("Testing app");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", new Document("text", (new Document("query", text)).append("path", Arrays.asList("desc", "profile", "techs")))), new Document("$sort", new Document("exp", -1L)), new Document("$limit", 5L)));
        result.forEach(res -> searched.add(converter.read(Post.class,res)) );

        return searched;
    }
}
