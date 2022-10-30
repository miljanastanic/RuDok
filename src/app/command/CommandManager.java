package app.command;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<AbstactCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstactCommand command){
        while (currentCommand < commands.size()){
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }
    public void doCommand(){
        if (currentCommand<commands.size()){
            commands.get(currentCommand++).doCommand();
        }
        if(currentCommand == commands.size()){

        }
    }
    public void undoCommand(){
        if(currentCommand >0){
            commands.get(--currentCommand).undoCommand();
        }if(currentCommand == 0){

        }
    }
}
