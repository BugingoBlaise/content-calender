package com.blaise.contentcalender.repository;


import com.blaise.contentcalender.model.Content;
import com.blaise.contentcalender.model.Status;
import com.blaise.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
     private final List<Content> contentList =new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content>findall(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c ->c.id().equals(id)).findFirst();
    }

    public void save( Content content) {
        contentList.removeIf(c ->c.id().equals(content.id()) );
        contentList.add(content);
    }



    @PostConstruct
    public void init(){
        Content c=new Content(
                1,
                "My first blog post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "http://localhost:8080/api/content"
        );
         contentList.add(c);

    }
    @PostConstruct
    public void initial(){
        Content c=new Content(
                2,
                "My second blog post",
                "My second blog post",
                Status.COMPLETED,
                Type.COURSE,
                LocalDateTime.now(),
                null,
                "http://localhost:8080/api/content"
        );
        contentList.add(c);

    }


    public boolean existsById(Integer id) {
        return contentList.stream().filter(c ->c.id().equals(id)).count()==1;
    }

    public void delete(Integer id) {
      contentList.removeIf(c ->c.id().equals(id) );
    }
}
