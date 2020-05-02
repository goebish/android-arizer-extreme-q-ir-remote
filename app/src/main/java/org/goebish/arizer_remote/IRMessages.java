package org.goebish.arizer_remote;

public class IRMessages
{
    // Arizer Extreme Q remote control buttons
    public static IRMessage ARIZER_EXTREME_Q_AUDIO;
    public static IRMessage ARIZER_EXTREME_Q_LIGHT;
    public static IRMessage ARIZER_EXTREME_Q_POWER;

    public static IRMessage ARIZER_EXTREME_Q_TIMER_0H;
    public static IRMessage ARIZER_EXTREME_Q_TIMER_2H;
    public static IRMessage ARIZER_EXTREME_Q_TIMER_4H;

    public static IRMessage ARIZER_EXTREME_Q_FAN_1;
    public static IRMessage ARIZER_EXTREME_Q_FAN_2;
    public static IRMessage ARIZER_EXTREME_Q_FAN_3;

    public static IRMessage ARIZER_EXTREME_Q_50_DEG;
    public static IRMessage ARIZER_EXTREME_Q_FAN0;
    public static IRMessage ARIZER_EXTREME_Q_100_DEG;

    public static IRMessage ARIZER_EXTREME_Q_200_DEG;
    public static IRMessage ARIZER_EXTREME_Q_PLUS;
    public static IRMessage ARIZER_EXTREME_Q_210_DEG;

    public static IRMessage ARIZER_EXTREME_Q_220_DEG;
    public static IRMessage ARIZER_EXTREME_Q_MINUS;
    public static IRMessage ARIZER_EXTREME_Q_230_DEG;

    public static void initialize()
    {
        // Remote Control Codes
        ARIZER_EXTREME_Q_AUDIO = IRNecFactory.create(0x48, 0x01, 0);
        ARIZER_EXTREME_Q_LIGHT = IRNecFactory.create(0x58, 0x01, 0);
        ARIZER_EXTREME_Q_POWER = IRNecFactory.create(0x78, 0x01, 0);

        ARIZER_EXTREME_Q_TIMER_0H = IRNecFactory.create(0x80, 0x01, 0);
        ARIZER_EXTREME_Q_TIMER_2H = IRNecFactory.create(0x40, 0x01, 0);
        ARIZER_EXTREME_Q_TIMER_4H = IRNecFactory.create(0xc0, 0x01, 0);

        ARIZER_EXTREME_Q_FAN_1 = IRNecFactory.create(0x20, 0x01, 0);
        ARIZER_EXTREME_Q_FAN_2 = IRNecFactory.create(0xa0, 0x01, 0);
        ARIZER_EXTREME_Q_FAN_3 = IRNecFactory.create(0x60, 0x01, 0);

        ARIZER_EXTREME_Q_50_DEG = IRNecFactory.create(0xe0, 0x01, 0);
        ARIZER_EXTREME_Q_FAN0 = IRNecFactory.create(0x10, 0x01, 0);
        ARIZER_EXTREME_Q_100_DEG = IRNecFactory.create(0x90, 0x01, 0);

        ARIZER_EXTREME_Q_200_DEG = IRNecFactory.create(0x50, 0x01, 0);
        ARIZER_EXTREME_Q_PLUS = IRNecFactory.create(0xd8, 0x01, 0);
        ARIZER_EXTREME_Q_210_DEG = IRNecFactory.create(0xf8, 0x01, 0);

        ARIZER_EXTREME_Q_220_DEG = IRNecFactory.create(0x30, 0x01, 0);
        ARIZER_EXTREME_Q_MINUS = IRNecFactory.create(0xb0, 0x01, 0);
        ARIZER_EXTREME_Q_230_DEG = IRNecFactory.create(0x70, 0x01, 0);
    }
}
