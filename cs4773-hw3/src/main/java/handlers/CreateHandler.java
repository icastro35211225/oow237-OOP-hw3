package handlers;

import commands.commands.*;;

public class CreateHandler implements Handler {
    Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void request(String command) {
        String[] splitCommand = command.split(" ");
        if(!splitCommand[0].equals("CREATE")){
            nextHandler.request(command);
        }
        
        try{
            String shapeType = splitCommand[1];
            if(shapeType.equals("RECTANGLE")){
                int height = Integer.parseInt(splitCommand[2]);
                int width = Integer.parseInt(splitCommand[3]);
                CreateRectangle create = new CreateRectangle();
                create.execute(height, width);
            }
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
