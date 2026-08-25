import java.util.Scanner;

abstract class Team {
    private String name;
    private int matchesPlayed;
    private int wins;
    private int draws;

    public Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }
    
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public abstract int calculatePoints();
    public abstract String getSportType();

    @Override
    public String toString() {
        return "Team: " + name + " (" + getSportType() + ") Points: " + calculatePoints();
    }
}

class CricketTeam extends Team {
    public CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        // Win = 2 points, Draw = 1 point
        return (getWins() * 2) + (getDraws() * 1);
    }

    @Override
    public String getSportType() {
        return "Cricket";
    }
}

class FootballTeam extends Team {
    public FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        // Win = 3 points, Draw = 1 point
        return (getWins() * 3) + (getDraws() * 1);
    }

    @Override
    public String getSportType() {
        return "Football";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            
            String[] details = line.split(",");
            
            if (details.length == 5) {
                String sport = details[0].trim();
                String name = details[1].trim();
                int matchesPlayed = Integer.parseInt(details[2].trim());
                int wins = Integer.parseInt(details[3].trim());
                int draws = Integer.parseInt(details[4].trim());
                
                Team team = null;
                
                if (sport.equalsIgnoreCase("Cricket")) {
                    team = new CricketTeam(name, matchesPlayed, wins, draws);
                } else if (sport.equalsIgnoreCase("Football")) {
                    team = new FootballTeam(name, matchesPlayed, wins, draws);
                }
                
                if (team != null) {
                    System.out.println(team.toString());
                } else {
                    System.out.println("Invalid sport type entered.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
        
        scanner.close();
    }
}