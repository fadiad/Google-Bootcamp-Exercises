package mainB.Client;

import mainB.facade.FacadeHttpRequests;

import java.io.IOException;

public class Client {

    private FacadeHttpRequests facade;

    public Client() {
        facade = new FacadeHttpRequests();
    }

    public void getPage(String pageNum) throws IOException {
        int status = facade.getPage(pageNum);
        print("GET", status);
    }

    public void postPage() throws IOException {
        int status = facade.postPage();
        print("POST", status);
    }

    public void putUser() throws IOException {
        int status = facade.putUser();
        print("PUT", status);
    }

    public void deleteUser() throws IOException {
        int status = facade.deleteUser();
        print("DELETE", status);
    }


    private void print(String type, int status) {
        if (status >= 200 & status < 400)
            System.out.println("Success status Code : " + status + " . \n");
        else
            System.out.println("Can't " + type + " page !");
    }

}
