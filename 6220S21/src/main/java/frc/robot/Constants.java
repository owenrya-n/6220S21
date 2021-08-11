package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Constants {

    /*
    Control Layer
    */

    //Control Interface
    public static final Joystick MSJ00 = new Joystick(0);
    public static final Joystick MSJ01 = new Joystick(1);
    public static final XboxController XBC02 = new XboxController(2);
    
    //Chassis Motor Control (top down front north orientation)
    public static final WPI_VictorSPX FLX00 = new WPI_VictorSPX(0);
    public static final WPI_VictorSPX FRX01 = new WPI_VictorSPX(1);
    public static final WPI_VictorSPX MLX02 = new WPI_VictorSPX(2);
    public static final WPI_VictorSPX MRX03 = new WPI_VictorSPX(3);
    public static final WPI_VictorSPX BLX04 = new WPI_VictorSPX(4);
    public static final WPI_VictorSPX BRX05 = new WPI_VictorSPX(5);
    
    public static final SpeedControllerGroup LS = new SpeedControllerGroup(FLX00, MLX02, BLX04);
    public static final SpeedControllerGroup RS = new SpeedControllerGroup(FRX01, MRX03, BRX05);
    public static final SpeedControllerGroup DT = new SpeedControllerGroup(LS, RS);

    //Sensors
    public static final Encoder LDE01 = new Encoder(0, 1);
    public static final Encoder RDE23 = new Encoder(2, 3);
    public static final ADXRS450_Gyro CCG00 = new ADXRS450_Gyro(SPI.Port.kMXP);

    //Datastream
    public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public static NetworkTableEntry tx = table.getEntry("tx");
    public static NetworkTableEntry ty = table.getEntry("ty");
    public static NetworkTableEntry ta = table.getEntry("ta");
    public static NetworkTableEntry tv = table.getEntry("tv");
    public static double LX = tx.getDouble(0.0); //target horizontal offset
    public static double LY = ty.getDouble(0.0);
    public static double LA = ta.getDouble(0.0); //target area
    public static double LV = tv.getDouble(0.0); //returns presence
    public static double LSD = 25; //Limelight ideal Distance Value-- needs to be calibrated

    //Statics
    public static final double TeleopMX = .9;
    public static final double DTENC = 1; //feet per encoder rotation

    //PID
    public static final double kP0 = .6;
    public static final double kI0 = 1.2;
    public static final double kD0 = 3;

    public static final double kP1 = .6;
    public static final double kI1 = 1.2;
    public static final double kD1 = 3;

    public static final double kP2 = 1;
    public static final double kI2 = 1;
    public static final double kD2 = 1;
    /* 
    Mechanism Layer
    */
    public void DTSC(){

    }
}