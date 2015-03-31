package com.xinhuanet.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by conanca on 15-3-30.
 */

@Repository
public class UserNodeDao {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<UserNode> find() {
        List<UserNode> users = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("MATCH (n:UserNode) RETURN n LIMIT 10 ");
            while (rs.next()) {
                System.out.println();
                UserNode user = JSON.parseObject(rs.getString("n"), UserNode.class);
                users.add(user);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

