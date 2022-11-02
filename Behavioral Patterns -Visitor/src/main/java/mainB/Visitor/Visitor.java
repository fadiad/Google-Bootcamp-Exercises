package mainB.Visitor;

public interface Visitor {
    void visit(User user);

    void visit(Asset asset);

    void visit(Group group);


}
