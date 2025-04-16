package com.Jobsearch.demo.DAO;

import com.Jobsearch.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends MongoRepository<Post,String> {

}
