package сom.company.command;

import сom.company.Ticket;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Remove_by_id implements Command, Serializable {
    private static final long serialVersionUID = 12L;
    long id;
    public Command_Remove_by_id(long id){this.id=id;}

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        boolean found=false;
        try {
            found = tickets.removeIf((i) -> {
                return i.id == id;
            });
            if(found) {
                System.out.println("Успешно удален эллемент с id  = " + id + ".");
            }else{
                System.out.println("Не обнаружен билет с данным id");
            }
        } catch (Exception e) {
            System.out.println("ЭКСЕПШОН");
        }
    }
}
