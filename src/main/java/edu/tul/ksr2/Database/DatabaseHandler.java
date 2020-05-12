package edu.tul.ksr2.Database;

import edu.tul.ksr2.GameEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    public static void initialize() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./ksrLOLdatabase", "sa", "");
        String setup = "create table if not exists LOLMatches as select * from CSVREAD('./src/main/resources/data/LOLAllData.csv');";
        Statement statement = connection.createStatement();
        statement.execute(setup);
        statement.close();
        connection.close();
    }
    

    public static ArrayList<GameEntity> loadAllFromDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./ksrLOLdatabase", "sa", "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from LOLMatches");

        ArrayList<GameEntity> gameEntities = new ArrayList<>();
        while (resultSet.next()) {
            GameEntity gameEntity = new GameEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13),
                    resultSet.getString(14),
                    resultSet.getString(15),
                    resultSet.getString(16),
                    resultSet.getString(17),
                    resultSet.getString(18),
                    resultSet.getString(19),
                    resultSet.getString(20),
                    resultSet.getString(21),
                    resultSet.getString(22),
                    resultSet.getString(23),
                    resultSet.getString(24),
                    resultSet.getString(25),
                    resultSet.getString(26),
                    resultSet.getString(27),
                    resultSet.getString(28),
                    resultSet.getString(29),
                    resultSet.getString(30),
                    resultSet.getString(31),
                    resultSet.getString(32),
                    resultSet.getString(33),
                    resultSet.getString(34),
                    resultSet.getString(35),
                    resultSet.getString(36),
                    resultSet.getString(37),
                    resultSet.getString(38),
                    resultSet.getString(39),
                    resultSet.getString(40),
                    resultSet.getString(41),
                    resultSet.getString(42),
                    resultSet.getString(43),
                    resultSet.getString(44),
                    resultSet.getString(45),
                    resultSet.getString(46),
                    resultSet.getString(47),
                    resultSet.getString(48),
                    resultSet.getString(49),
                    resultSet.getString(50)
            );
            gameEntities.add(gameEntity);
        }

        statement.close();
        connection.close();
        return gameEntities;
    }
    
}
