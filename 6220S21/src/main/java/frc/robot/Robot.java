
package frc.robot;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private DifferentialDrive Chassis;
  private double SM = 1;

  @Override
  public void robotInit() {

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    Chassis = new DifferentialDrive(Constants.LS, Constants.RS);

    //encoders
    Constants.LDE01.setDistancePerPulse(Constants.DTENC/256.);
    Constants.RDE23.setDistancePerPulse(Constants.DTENC/256.);
    Shuffleboard.getTab("Example tab").add((Sendable) Constants.CCG00);

    

  }

  @Override
  public void robotPeriodic() {} //unused

  @Override
  public void autonomousInit() {

    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

  }

  @Override
  public void autonomousPeriodic() {

    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:

        for (int i = 0; i < 5; i++) {
          Control.DriveToDistance(5);
          Control.DriveRotate(90);
        }

        break;
    }

  }

  @Override
  public void teleopInit() {} //use robotinit instead

  @Override
  public void teleopPeriodic() {
    
   /*SM=(Constants.MSJ00.getThrottle()+Constants.MSJ01.getThrottle())/2;
    Chassis.tankDrive(Constants.MSJ00.getY()*Constants.TeleopMX*SM, Constants.MSJ01.getY()*Constants.TeleopMX*SM);
    System.out.println(Constants.MSJ00.getY()*Constants.TeleopMX*SM+","+Constants.MSJ01.getY()*Constants.TeleopMX*SM);*/
    System.out.println(Constants.RDE23.getRate());
    System.out.println(Constants.LDE01.getRate());
    Chassis.tankDrive(SM*Constants.XBC02.getRawAxis(1), SM*Constants.XBC02.getRawAxis(5));
    System.out.println(SM);

    while(Constants.XBC02.getRawButtonPressed(6)){
      SM=1;
    }/*else{SM=0;}*/
    
    if(Constants.MSJ00.getRawButtonPressed(4)){
      Control.DriveFollowCamera(Constants.LSD);
    }

    if(Constants.MSJ00.getRawButtonPressed(4)){
      Control.DriveTrackCamera();
    }
  }

  @Override
  public void disabledInit() {} //unused

  @Override
  public void disabledPeriodic() {} //unused

  @Override
  public void testInit() {} //unused

  @Override
  public void testPeriodic() {} //unused
}
