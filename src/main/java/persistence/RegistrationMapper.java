package persistence;

import DTO.RegistrationDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationMapper {

    private Database database;

    //opretter konstruktøren i tilfælde af at RegistrationMapper skal benyttes til andre databaser i andre klasser.
    public RegistrationMapper(Database database) {
        this.database = database;
    }

    public void addToTeam(int member_id, String team_id, int price){

        String sql = "INSERT into registration (member_id, team_id, price) values (?,?,?)";

        try (Connection connection = database.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, member_id);
            ps.setString(2, team_id);
            ps.setInt(3, price);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Registrering af medlemsnummer: " + member_id + " blev fuldført.");
            } else {
                System.out.println("Registreringen mislykkedes.");
            }
        } catch (SQLException throwables) {
            // TODO: Handle the exception appropriately, e.g., log it or rethrow it.
            throwables.printStackTrace();
        }
    }

    public List<RegistrationDTO> getAllRegistrations(){

        List<RegistrationDTO> listOfRegistrations = new ArrayList<>();

        String sql = "SELECT name, gender, team_id, price  " +
                "FROM member join registration using(member_id) join team using(team_id) " +
                "ORDER BY name";

        try(Connection connection = database.connect()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String team = rs.getString("team_id");
                int price = rs.getInt("price");

                listOfRegistrations.add(new RegistrationDTO(name, gender, team, price));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listOfRegistrations;
    }

}
