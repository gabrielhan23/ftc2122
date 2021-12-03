package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.hardware.Blinker;
// import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
// import java.util.concurrent.TimeUnit
@Autonomous
public class AutoRedOpMode extends LinearOpMode {
  private Blinker expansion_Hub_2;
  private Gyroscope imu;
  private DcMotor left;
  private DcMotor right;
  private DcMotor carouselRight;
  private DcMotor carouselLeft;
  @Override
  public void runOpMode() {
      expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
      // imu = hardwareMap.get(Gyroscope.class, "imu");
      left = hardwareMap.get(DcMotor.class, "left");
      right = hardwareMap.get(DcMotor.class, "right");
      left.setDirection(DcMotor.Direction.REVERSE);
    
      carouselRight = hardwareMap.get(DcMotor.class, "carouselRight");
      carouselLeft = hardwareMap.get(DcMotor.class, "carouselLeft");
      // USE THE FOLLOWING LINES TO CHANGE THE CAROUSEL SPIN FOR THE ENTIRE FILE
      carouselRight.setDirection(DcMotor.Direction.REVERSE);
      carouselLeft.setDirection(DcMotor.Direction.REVERSE);
      
      telemetry.addData("Status", "Initialized");
      telemetry.update();
      // Wait for the game to start (driver presses PLAY)
      waitForStart();
      left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      // run until the end of the match (driver presses STOP)
      while (opModeIsActive()) {
          // push forward
          // left.setPower(0.2);
          // right.setPower(0.2);
        
          // // turn carousel
          // carouselRight.setPower(1);
          // carouselLeft.setPower(1);
          // robotsleep(1500);
          
          // left.setPower(0);
          // right.setPower(0);
          // carouselRight.setPower(0);
          // carouselLeft.setPower(0);
          // robotsleep(1000);
        
          // turn
          left.setPower(1);
          right.setPower(-1);
          
          left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
          right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
          left.setTargetPosition(5000);
          right.setTargetPosition(-5000);
          // robotsleep(700);
          // left.setPower(0);
          // right.setPower(0);
          // robotsleep(1000);
        
          // drive forward
          // left.setPower(1);
          // right.setPower(1);
          // robotsleep(500);
        
          // stop
          // left.setPower(0);
          // right.setPower(0);
          // robotsleep(50000);
            
          //telemetry data reported to Driver Hub
          // telemetry.addData("Target Power Left", tgtPowerLeft);
          telemetry.addData("Left Encoder", left.getCurrentPosition());
          telemetry.addData("Right Encoder", right.getCurrentPosition());
          telemetry.addData("Left Motor Power", left.getPower());
          // telemetry.addData("Target Power Right", tgtPowerRight);
          telemetry.addData("Right Motor Power", right.getPower());
          telemetry.addData("Status", "Running");
          telemetry.update();
    
      }
  }
  public void robotsleep(long timeout){
      if (timeout > 0) {
          try {
              TimeUnit.MILLISECONDS.sleep(timeout);
          } catch (InterruptedException e){
              System.out.print(e);
          }
      }
  }
}
 
 
 



