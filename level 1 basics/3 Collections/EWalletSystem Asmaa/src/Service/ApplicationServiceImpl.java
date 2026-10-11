package Service;

import model.WalletSystem;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService{
    @Override
    public void start() {
        System.out.println("_> Welcome to " + WalletSystem.name);
        Integer count=0;

        while (true){
            System.out.println("please choose ..........");
            System.out.println("1.login      2.signup       3.exit");
            Scanner scanner=new Scanner(System.in);
            int choose = scanner.nextInt();
            Boolean isExit =false;
            switch (choose){
                case 1:
                    System.out.println("login feature");
                    break;
                case 2:
                    System.out.println("signup feature");
                    break;
                case 3:
                    System.out.println(" have a nice day :) ");
                    isExit=true;
                    break;

                default:
                    System.out.println("invalid choose :( ");
                    count++;
            }
            if(isExit){
                break;
            }
            if (count==4){
                System.out.println("pls contact with Admin :(");
                break;
            }
        }

    }
}
