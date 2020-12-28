package main.java.bgu.spl.net.impl.bgrs;

import java.time.LocalDateTime;
import main.resources.*;
public class BgrsProtocol implements bgu.spl.net.api.MessagingProtocol<T> {

    private boolean shouldTerminate = false;
    private Database database;
    @Override
    public String process(String msg) {


        Type1Message;

        int opcode = this.toInt(msg.substring(0,8));
        int courseNumber;
        String username,password;
        String errorMessage = "13";

        if (opcode==1) // if opcode = 1
        {

            try {
                database.RegisterAdmin(username,password);
            }
            catch (Exception e){
                // send error message
                errorMessage=errorMessage+opcode;

            }

        }
        if (opcode==2){
            try {
                database.StudentRegister(username,password);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==3){
            try {
                database.login(username,password);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==4){
            try {
                database.logout(connectedUser.username,connectedUser.password);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;


            }
        }
        if (opcode==5){
            try {
            database.registerToCourse(courseNumber);
        }
        catch (Exception e){
            errorMessage=errorMessage+opcode;

        }
    }
        if (opcode==6){
            try {
                database.kdamCourse(courseNumber);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==7){
            try {
                database.CourseSeats(courseNumber);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==8){
            try {
                database.studentStat(username);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==9){
            try {
                database.isRegisterd(courseNumber);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==10){
            try {
                database.unregister(courseNumber);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;

            }
        }
        if (opcode==11){
            try {
                database.myCourses(courseNumber);
            }
            catch (Exception e){
                errorMessage=errorMessage+opcode;
                flag=false;

            }
            if (flag)
                // good message
        }



        shouldTerminate = "/n".equals(msg);


    }

    private int toInt(String substring) {
        int answer=0;
        if (substring.charAt(0)=='1')
            answer=answer+1;
        if (substring.charAt(1)=='1')
            answer=answer+2;
        if (substring.charAt(2)=='1')
            answer=answer+4;
        if (substring.charAt(3)=='1')
            answer=answer+8;

        return answer;

    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}

