package com.xinhuanet.demo;

import java.sql.*;

/**
 * Hello world!
 */
public class Simple {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Make sure Neo4j Driver is registered
        Class.forName("org.neo4j.jdbc.Driver");

        // Connect
        Connection con = DriverManager.getConnection("jdbc:neo4j://192.168.74.203:7474", "neo4j", "xinhua");

        // Querying
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("MATCH (n:UserNode{userId:2955888}) RETURN n ");
            while (rs.next()) {
                System.out.println(rs.getString("n"));
            }
        }
    }
}
