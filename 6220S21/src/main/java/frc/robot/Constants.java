package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
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
    public static final TalonSRX FLX00 = new TalonSRX(0);
    public static final TalonSRX FRX01 = new TalonSRX(1);
    public static final TalonSRX MLX02 = new TalonSRX(2);
    public static final TalonSRX MRX03 = new TalonSRX(3);
    public static final TalonSRX BLX04 = new TalonSRX(4);
    public static final TalonSRX BRX05 = new TalonSRX(5);

    //Mechanism Motor Control
    public static final TalonSRX ARM06 = new TalonSRX(6);
    
    //Sensors
    public static final Encoder LDE01 = new Encoder(0, 1);
    public static final Encoder RDE23 = new Encoder(2, 3);
    public static final ADXRS450_Gyro CCG00 = new ADXRS450_Gyro(SPI.Port.kMXP);

    //Datastream

    //Statics

   /* 
    Mechanism Layer
    */
    public void DTMC(){

    }
}