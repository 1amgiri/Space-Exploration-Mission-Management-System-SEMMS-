package services;

import database.*;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MissionManagementService {

    public void addSpacecraft(Spacecraft spacecraft) {
        String query = "INSERT INTO Spacecraft (name, type, capacity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, spacecraft.getName());
            stmt.setString(2, spacecraft.getType());
            stmt.setInt(3, spacecraft.getCapacity());
            stmt.executeUpdate();
            System.out.println("Spacecraft added: " + spacecraft.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMission(Mission mission) {
        String query = "INSERT INTO Mission (mission_name, destination, launch_date, spacecraft_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, mission.getMissionName());
            stmt.setString(2, mission.getDestination());
            stmt.setDate(3, mission.getLaunchDate());
            stmt.setInt(4, mission.getSpacecraftId());
            stmt.executeUpdate();
            System.out.println("Mission added: " + mission.getMissionName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Spacecraft> listSpacecrafts() {
        List<Spacecraft> spacecrafts = new ArrayList<>();
        String query = "SELECT * FROM Spacecraft";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Spacecraft spacecraft = new Spacecraft(rs.getInt("id"), rs.getString("name"),
                                                        rs.getString("type"), rs.getInt("capacity"));
                spacecrafts.add(spacecraft);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spacecrafts;
    }

    public List<Mission> listMissions() {
        List<Mission> missions = new ArrayList<>();
        String query = "SELECT * FROM Mission";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Mission mission = new Mission(rs.getInt("id"), rs.getString("mission_name"),
                                              rs.getString("destination"), rs.getDate("launch_date"),
                                              rs.getInt("spacecraft_id"));
                missions.add(mission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return missions;
    }
}
