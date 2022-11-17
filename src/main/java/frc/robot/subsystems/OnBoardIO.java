package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OnBoardIO extends SubsystemBase {
    private final DigitalInput m_buttonA = new DigitalInput(channel:0);
    private final DigitalOutput m_yellowLed = new DigitalOutput(channel:3);

    private DigitalInput m_buttonB;
    private DigitalOutput m_greenLed;
    
    private DigitalInput m_buttonC;
    private DigitalOutput m_redLed;

    private static final double MESSAGE_INTERVAL = 1.0;
    private double m_nextMessageTime;

    public enum ChannelMode {
        INPUT,
        OUTPUT
    }
    
    /**
     * @param dio1
     * @param dio2
     */
    public OnBoardIO
}