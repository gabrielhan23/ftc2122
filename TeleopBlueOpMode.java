public class teleopblue {
    
}
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.hardware.Blinker;
// import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
//import java.util.concurrent.TimeUnit
import org.firstinspires.ftc.teamcode.TimedMotor;
@TeleOp
public class TeleopBlueOpMode extends LinearOpMode {
 private Blinker expansion_Hub_2;
 // private Gyroscope imu;
 private DcMotor left;
 private DcMotor right;
 private DcMotor carouselLeft;
 private DcMotor carouselRight;
 private TimedMotor carouselLeftTimer;
 private TimedMotor carouselRightTimer;
 @Override
 public void runOpMode() {
     expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
     // imu = hardwareMap.get(Gyroscope.class, "imu");
     left = hardwareMap.get(DcMotor.class, "left");
     right = hardwareMap.get(DcMotor.class, "right");
     carouselLeft = hardwareMap.get(DcMotor.class, "carouselLeft");
     carouselRight = hardwareMap.get(DcMotor.class, "carouselRight");
     carouselLeftTimer = new TimedMotor();
     carouselRightTimer = new TimedMotor();
     // USE THE FOLLOWING LINES TO CHANGE THE CAROUSEL SPIN FOR THE ENTIRE FILE
      // carouselRight.setDirection(DcMotor.Direction.REVERSE);
      // carouselLeft.setDirection(DcMotor.Direction.REVERSE);
  
     telemetry.addData("Status", "Initialized");
     telemetry.update();
     // Wait for the game to start (driver presses PLAY)
     waitForStart();
  
     double tgtPowerLeft = 0;
     double tgtPowerRight = 0;
     int endgame = -1;
     // run until the end of the match (driver presses STOP)
     while (opModeIsActive()) {
      
         // DriveTrain program
         tgtPowerLeft = this.gamepad1.left_stick_y;
         //og was set to - for above
         left.setPower(tgtPowerLeft);
         tgtPowerRight = -this.gamepad1.right_stick_y;
         //og was set to + for above
         right.setPower(tgtPowerRight);
      
         // Carousel program
      
         if(this.gamepad1.y == true) {
             carouselRight.setPower(1);
             carouselLeft.setPower(1);
             robotsleep(100);
             carouselRight.setPower(0);
             carouselLeft.setPower(0);
         }
         //endgame
         if(this.gamepad1.a == true) {
             if(carouselRightTimer.isRunning()){
               carouselRightTimer.cancelMotor();
             } else {
               carouselRightTimer.runMotor(1500, 10, 1000);
               carouselRight.setPower(1);
             }
             if(carouselLeftTimer.isRunning()){
               carouselLeftTimer.cancelMotor();
             } else {
               carouselLeftTimer.runMotor(1500, 10, 1000);
               carouselLeft.setPower(1);
             }
         }
      
         // check motors
      
         carouselRight.setPower(carouselRightTimer.running());
         carouselLeft.setPower(carouselLeftTimer.running());
      
         //telemetry data reported to Driver Hub
         telemetry.addData("Target Power Left", tgtPowerLeft);
         telemetry.addData("Left Motor Power", left.getPower());
         telemetry.addData("Target Power Right", tgtPowerRight);
         telemetry.addData("Right Motor Power", right.getPower());
         telemetry.addData("Left Motor Encoder", left.getCurrentPosition());
         telemetry.addData("Right Motor Encoder", right.getCurrentPosition());
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
 
 
 



