package DTO;

public class TeamDTO {

    private String teamName;
    private int totalParticipant;


    public TeamDTO(String teamName, int totalParticipant) {
        this.teamName = teamName;
        this.totalParticipant = totalParticipant;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalParticipant() {
        return totalParticipant;
    }
}
