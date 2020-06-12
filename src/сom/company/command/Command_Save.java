package сom.company.command;

import сom.company.Ticket;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Command_Save implements Command, Serializable {
    private static final long serialVersionUID = 14L;

    @Override
    public void Execute(TreeSet<Ticket> tickets, Scanner[] in,
                        String savePath, boolean[] isScannerFromSystem, List<String> executed_scripts){
        BufferedWriter bufferedWriter;
        String line = "";
        try {

            BufferedOutputStream bout = new BufferedOutputStream( ( new FileOutputStream(savePath)));
            Iterator<Ticket> iterator=tickets.iterator();
            line="<Tickets>"+"\n";
            bout.write(line.getBytes());
            while (iterator.hasNext()){
                Ticket ticket=iterator.next();
                line="  <Ticket>"+"\n";
                bout.write(line.getBytes());

                line="    <ID>"+" "+ticket.getId()+" "+"</ID>"+"\n";
                bout.write(line.getBytes());

                line="    <name>"+" "+ticket.getName()+" "+"</name>"+"\n";
                bout.write(line.getBytes());

                line="    <coordinatesX>"+" "+ticket.getCoordinates().getX()+" "+"</coordinatesX>"+"\n";
                bout.write(line.getBytes());

                line="    <coordinatesY>"+" "+ticket.getCoordinates().getY()+" "+"</coordinatesY>"+"\n";
                bout.write(line.getBytes());

                line="    <price>"+" "+ticket.getPrice()+" "+"</price>"+"\n";
                bout.write(line.getBytes());

                line="    <comment>"+" "+ticket.getComment()+" "+"</comment>"+"\n";
                bout.write(line.getBytes());

                line="    <type>"+" "+ticket.getType()+" "+"</type>"+"\n";
                bout.write(line.getBytes());

                line="    <eventType>"+" "+ticket.getEvent().getEventType()+" "+"</eventType>"+"\n";
                bout.write(line.getBytes());

                line="    <eventName>"+" "+ticket.getEvent().getName()+" "+"</eventName>"+"\n";
                bout.write(line.getBytes());

                line="    <eventID>"+" "+ticket.getEvent().getId()+" "+"</eventID>"+"\n";
                bout.write(line.getBytes());

                line="    <Refundable>"+" "+ticket.getRefundable()+" "+"</Refundable>"+"\n";
                bout.write(line.getBytes());

                line="  </Ticket>"+"\n";
                bout.write(line.getBytes());

            }
            line="</Tickets>";
            bout.write(line.getBytes());
            bout.flush();

        } catch (NullPointerException e){
            System.out.println("Эксепшон шо поделать");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ///подумай че сделать как запихнуть в байтовый поток
    }
}
