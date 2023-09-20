package DTO;

public class RegistrationDTO {

    private String name;
    private String gender;
    private String team_id;
    private int price;

    public RegistrationDTO(String name, String gender, String team_id, int price) {
        this.name = name;
        this.gender = gender;
        this.team_id = team_id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getTeam_id() {
        return team_id;
    }

    public int getPrice() {
        return price;
    }
}
