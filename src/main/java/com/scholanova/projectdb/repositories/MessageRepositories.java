package com.scholanova.projectdb.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scholanova.projectdb.models.Message;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MessageRepositories {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public int insert(Message m) {
        return jdbcTemplate.update(
                "insert into message (content) values(?)", m.getContent());
    }

    public List<Message> listAll(){

        return jdbcTemplate.query("select * from message",(rs,rowNum) -> new Message(rs.getInt("id"),rs.getString("content")));
    }

}