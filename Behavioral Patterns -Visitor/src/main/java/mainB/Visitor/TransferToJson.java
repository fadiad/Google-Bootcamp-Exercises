package mainB.Visitor;

public class TransferToJson implements Visitor {
    @Override
    public void visit(User user) {
        System.out.println("user to json");
    }

    @Override
    public void visit(Asset asset) {
        System.out.println("asset to json");
    }

    @Override
    public void visit(Group group) {
        System.out.println("group to json");
    }

}


