package sample;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
import java.util.Random;
import java.util.Scanner;
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

public class Main {
    private static final int DEFAULT = 10;
    private static Random random = new Random();



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int [] stones = new int [5];
        for (int i = 0; i < 5; i++) {
            stones[i] = DEFAULT;
        }

        int decisionPoints = 0;
        String[] names = {"red", "green", "blue", "yellow", "pink"};
        //int[] a = eventGenerator();
        while (stones[0] >= 1 && stones[1] >= 1 && stones[2] >= 1 && stones[3] >= 1 && stones[4] >= 1 && decisionPoints >= 0){
            System.out.println(names[0] + " --> " + stones[0] + "  ||  " +
                            names[1] + " --> " + stones[1] + "  ||  " +
                            names[2] + " --> " + stones[2] + "  ||  " +
                            names[3] + " --> " + stones[3] + "  ||  " +
                            names[4] + " --> " + stones[4] + "  ||  " );
            int[] event = eventGenerator();
            System.out.println(names[event[1]] + " " + event[3]);
            System.out.println(names[event[0]] + " +" + event[2]);
            System.out.println("Вы согласны на обмен? если согласитесь (напишите 1), получите 1 очко решения, если откажетесь (напишите 0), потратите 3 очка решения.");
            System.out.println("Ваши текущие очки " +  decisionPoints + "  ");
            int decision;
            decision = scanner.nextInt();
            if (decision == 0) {
                decisionPoints -= 3;
            }else{
                decisionPoints++;
                stones[event[1]] += event[3];
                stones[event[0]] += event[2];
            }
        }


        //System.out.print(names[a[0]] + " " + names[a[1]] + " +" + a[2] + " " + a[3]);

    }
    public static int[] eventGenerator(){
        int[] a = new int[4];
        a[0] = random.nextInt(5);
        a[1] = (a[0] + random.nextInt(4) + 1) % 5;
        a[2] = random.nextInt(5) + 1;
        a[3] = -a[2];
        return a;
    }
}