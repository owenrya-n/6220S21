package frc.robot;

import edu.wpi.first.wpilibj.controller.PIDController;

public class Control {

    public static void DriveToDistance(double setpoint){
        PIDController gogo = new PIDController(Constants.kP0, Constants.kI0, Constants.kD0);// will have to be changed depending on natural dir of rotation
        PIDController tata = new PIDController(Constants.kP0, Constants.kI0, Constants.kD0);
        try {
            Constants.RS.set(gogo.calculate(Constants.RDE23.getDistance(), setpoint)+tata.calculate(Constants.CCG00.getAngle(), 0));
            Constants.LS.set(gogo.calculate(Constants.RDE23.getDistance(), setpoint)-tata.calculate(Constants.CCG00.getAngle(), 0));
        } finally {
            gogo.close();
            tata.close();
        }
    }

    public static void DriveRotate(double setpoint){
        PIDController tata = new PIDController(Constants.kP0, Constants.kI0, Constants.kD0);// will have to be changed depending on natural dir of rotation
        try{
            if(setpoint<Constants.CCG00.getAngle()){
                Constants.RS.set(tata.calculate(Constants.CCG00.getAngle(), setpoint));
                Constants.LS.set(-tata.calculate(Constants.CCG00.getAngle(), setpoint));
            }

            if(setpoint>Constants.CCG00.getAngle()){
                Constants.RS.set(-tata.calculate(Constants.CCG00.getAngle(), setpoint));
                Constants.LS.set(tata.calculate(Constants.CCG00.getAngle(), setpoint));
            }
        } finally {
            tata.close();
          }
    }

}