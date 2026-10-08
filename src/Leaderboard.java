import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Leaderboard {
    // This class has its main purpose of receive data, save it and display it 
    private static final String FILE_NAME = "leaderboard.txt";
    
    public static void savePlayer(String name, int duration){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("User name is not found");
        if (duration < 0) throw new IllegalArgumentException("Duration cannot contain negative value");
        try(FileWriter writer = new FileWriter(FILE_NAME,true);  ){
            writer.write("%s,%d%n".formatted(name,duration));
        } 
        catch(IOException e){
            System.out.println("Data cannot be saved");
        }
    }

    public static void displayPlayer(){
        int index = 1;
        try(Scanner read = new Scanner(new File(FILE_NAME));){
            System.out.printf("===== PLAYER LEADERBOARD =====%n");
            while(read.hasNextLine()){
                String data = read.nextLine();
                String[] dataContainer = data.split(","); // Data format by now is [name],[duration]
                if (dataContainer.length == 2){
                    try{
                        String parseName = dataContainer[0];
                        int parseDuration = Integer.parseInt(dataContainer[1].trim());
                        System.out.printf("%d, %s with the duraton of %d seconds %n",index,parseName,parseDuration);
                        index ++;
                        
                    }catch(NumberFormatException e){
                        
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("User has no score yet!");
        }
    }
}
