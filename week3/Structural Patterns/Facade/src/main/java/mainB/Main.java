package mainB;

import mainB.Client.Client;
import mainB.facade.FacadeHttpRequests;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FacadeHttpRequests httpRequests = new FacadeHttpRequests();
            String pagNumber = "11";

            Client client = new Client();

            client.getPage(pagNumber);

            client.postPage();

            client.putUser();

            client.deleteUser();


        } catch (IOException e) {
            System.out.println("Fail to connecting the API ! , reason : " + e.getMessage());
            System.out.println("\n " + "Sorry! App wil not complete running");
        }
    }
}
