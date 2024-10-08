package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InstrumentDAO {
    private Connection connection;

    public InstrumentDAO() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/db.properties"));
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Instrument> getAllInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM instruments";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                instruments.add(new Instrument(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public void addInstrument(Instrument instrument) {
        try {
            String sql = "INSERT INTO instruments (name, price) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, instrument.getName());
            preparedStatement.setDouble(2, instrument.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
