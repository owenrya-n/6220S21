package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.*;

public class Constants {

    /*
    Control Layer
    */

    //Control Interface
    public static final Joystick MSJ00 = new Joystick(0);
    public static final Joystick MSJ01 = new Joystick(1);
    public static final XboxController XBC02 = new XboxController(2);
    
    //Chassis Motor Control (top down front north orientation)
    public static final WPI_TalonSRX FLX00 = new WPI_TalonSRX(0);
    public static final WPI_TalonSRX FRX01 = new WPI_TalonSRX(1);
    public static final WPI_TalonSRX MLX02 = new WPI_TalonSRX(2);
    public static final WPI_TalonSRX MRX03 = new WPI_TalonSRX(3);
    public static final WPI_TalonSRX BLX04 = new WPI_TalonSRX(4);
    public static final WPI_TalonSRX BRX05 = new WPI_TalonSRX(5);
    
    public static final SpeedControllerGroup LS = new SpeedControllerGroup(FLX00, MLX02, BLX04);
    public static final SpeedControllerGroup RS = new SpeedControllerGroup(FRX01, MRX03, BRX05);
    public static final SpeedControllerGroup DT = new SpeedControllerGroup(LS, RS);

    //Sensors
    public static final Encoder LDE01 = new Encoder(0, 1);
    public static final Encoder RDE23 = new Encoder(2, 3);
    public static final ADXRS450_Gyro CCG00 = new ADXRS450_Gyro(SPI.Port.kMXP);

    //Datastream

    //Statics
    public static final double TeleopMX = .9;
    public static final double DTENC = 1; //feet per encoder rotation

    //PID
    public static final double kP0 = 1;
    public static final double kI0 = 1;
    public static final double kD0 = 1;

    public static final double kP1 = 1;
    public static final double kI1 = 1;
    public static final double kD1 = 1;

    public static final double kP2 = 1;
    public static final double kI2 = 1;
    public static final double kD2 = 1;
    /* 
    Mechanism Layer
    */
    public void DTSC(){

    }
}