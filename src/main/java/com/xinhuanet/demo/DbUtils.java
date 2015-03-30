package com.xinhuanet.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.json.JSONUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by conanca on 15-3-30.
 */
public class DbUtils {
    public static void main(String[] args) throws SQLException {


        // Create a ResultSetHandler implementation to convert the
// first row into an Object[].
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:neo4j://192.168.74.203:7474");
        dataSource.setDriverClassName("org.neo4j.jdbc.Driver");
        dataSource.setUsername("neo4j");
        dataSource.setPassword("xinhua");

        // Create a QueryRunner that will use connections from
        // the given DataSource
        QueryRunner run = new QueryRunner(dataSource);
        ResultSetHandler<List<UserNode>> h = new BeanListHandler<UserNode>(UserNode.class);

        // Execute the query and get the results back from the handler
        List<UserNode> result = run.query("MATCH (n:UserNode) RETURN n LIMIT 10 ",h);
        System.out.println(JSONUtils.toJSONString(result));
    }
}
