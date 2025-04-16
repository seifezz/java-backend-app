package com.Jobsearch.demo.DAO;

import com.Jobsearch.demo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchPostDao {

    List<Post> findByText(String text);
}
