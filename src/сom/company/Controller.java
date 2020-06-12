package сom.company;


import сom.company.command.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Controller implements Serializable{
    private static final long serialVersionUID = 1403L;
        static TreeSet<Ticket> tickets = new TreeSet<Ticket>();
        static Scanner[] in = new Scanner[]{new Scanner(System.in)};
        static String savePath;
        static boolean[] isScannerFromSystem = new boolean[]{true};
        static boolean isCommandsFromOutside;
    public static List<String> executed_scripts = new ArrayList();
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        in = new Scanner[]{new Scanner(System.in)};
        isScannerFromSystem = new boolean[]{true};
        tickets= new TreeSet();
        if (args.length > 0) {
            savePath = args[0];
            if (args.length > 1) {
                isCommandsFromOutside = args[1].equals("true");
            }
        } else {
            System.out.print("Введите путь к файлу: "); //если файл существует ,то просто добавь чтение
            savePath=read_string();

        }
        Saving();


        while (!isCommandsFromOutside) {
            //read from keyboard (lab 5)

            ExecuteCommand(CommandBuilder.Build(read_string()));
        }
    }
    public static  void ExecuteCommand(Command commandtoExecute){
        if(commandtoExecute==null){
            return;
        }
        commandtoExecute.Execute(tickets,in,savePath,isScannerFromSystem,executed_scripts);
    }
    public static  String read_string(){
        try {
            String nextLine = in[0].nextLine();
            if(!isScannerFromSystem[0]){
                if(nextLine.contains("execute_script")){
                    if(nextLine.split(" ").length>1){
                        String script_name = nextLine.split(" ")[1];
                        if(executed_scripts.contains(script_name)){
                            if(!executed_scripts.get(executed_scripts.size() - 1).equals(script_name)){
                                System.out.println("Recursion found");
                                Exit(true);
                            }
                        }
                        executed_scripts.add(script_name);
                    }
                }
                if(!in[0].hasNext()){
                    executed_scripts=new ArrayList();
                    in[0] = new Scanner(System.in);
                    isScannerFromSystem[0]=true;
                }
            }else{
                executed_scripts=new ArrayList();
                in[0] = new Scanner(System.in);
                isScannerFromSystem[0]=true;
            }
            return nextLine;
        }catch(java.util.NoSuchElementException e){

            in[0] = new Scanner(System.in);
            isScannerFromSystem[0]=true;
            return in[0].nextLine();
        }catch(Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
            Exit(true);
        }
        return null;
    }
    public static void Exit(boolean force){
        new Command_Exit(force).Execute(tickets,in,savePath,isScannerFromSystem,executed_scripts);
    }
    private static void Saving(){
        while (savePath.isEmpty()|| !savePath.endsWith(".xml") || (savePath.endsWith(".xml")&& savePath.length()==4)){
            if(savePath.isEmpty()){
                System.out.println("Путь не может быть пустым");
                savePath=read_string();
            }
            if(!savePath.endsWith(".xml")){
                System.out.println("Файл должен иметь расширение xml");
                savePath=read_string();
            }
            if (savePath.endsWith(".xml")&& savePath.length()==4){
                System.out.println("Файл должен иметь расширение .xml и содержать имя файла");
                savePath=read_string();
            }
        }

        File dataFile = new File(savePath);
        if(dataFile.exists()){
            System.out.println("Файл существует");
                try {
                    Scanner scanner = new Scanner(new File(savePath));
                    scanner.nextLine();
                    while (scanner.next().equals("<Ticket>")){

                        scanner.nextLine();
                        scanner.skip("    <ID>");
                        long ID=scanner.nextLong();
                        scanner.nextLine();
                        scanner.skip("    <name>");
                        String name=scanner.next();
                        scanner.nextLine();
                        scanner.skip("    <coordinatesX>");
                        String x=scanner.next();
                        scanner.nextLine();
                        scanner.skip("    <coordinatesY>");
                        String y=scanner.next();
                        scanner.nextLine();
                        Coordinates coordinates=new Coordinates(Float.valueOf(x),Double.valueOf(y));
                        scanner.skip("    <price>");
                        String price=scanner.next();
                        scanner.nextLine();
                        scanner.skip("    <comment>");
                        String comment=scanner.next();
                        scanner.nextLine();
                        scanner.skip("    <type>");
                        String typetype=scanner.next();
                        TicketType type;
                        type= TicketType.valueOf(typetype);
                        scanner.nextLine();
                        scanner.skip("    <eventType>");
                        String eventtypetype=scanner.next();
                        EventType eventType;
                        eventType= EventType.valueOf(eventtypetype);
                        scanner.nextLine();
                        scanner.skip("    <eventName>");
                        String eventName=scanner.next();
                        scanner.nextLine();
                        scanner.skip("    <eventID>");
                        long eventID=scanner.nextLong();
                        scanner.nextLine();
                        Event event=new Event(eventID,eventName,eventType, LocalDate.now());
                        scanner.skip("    <Refundable>");
                        boolean refundable=scanner.nextBoolean();
                        scanner.nextLine();
                        scanner.nextLine();
                        tickets.add(new Ticket(ID,name,coordinates,Float.parseFloat(price),comment,refundable,type,event,new Date()));

                    }
                }catch (IllegalArgumentException e){
                    System.out.println("Опачки.А тут эксепшион.Файл то у вас битый");
                }
                catch (NoSuchElementException e){
                    System.out.println("Файл наверное пустой или что то еще ");
                }
                catch (FileNotFoundException e){
                    System.out.println("Файл  для загрузки не найден");
                    System.out.println("Добавьте элемент через пользовательские команды");
                }catch (Exception e){
                    System.out.println("Экшепшоны повсюду");
                }
        }else
        {
            System.out.println("Создаю новый файл ");
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Exit(true);
            }
        }

    }
    private static List<String> ReadFile(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line=br.readLine())!=null ){
            lines.add(line);

        }
        inputStreamReader.close();
        return lines;
    }


}
