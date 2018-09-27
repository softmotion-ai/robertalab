package de.fhg.iais.roberta.visitors.arduino;

import de.fhg.iais.roberta.syntax.expressions.arduino.LedMatrix;
import de.fhg.iais.roberta.syntax.sensor.generic.AccelerometerSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;
import de.fhg.iais.roberta.syntax.sensors.arduino.mbot.FlameSensor;
import de.fhg.iais.roberta.syntax.sensors.arduino.mbot.Joystick;

public interface MbotAstVisitor<V> extends ArduinoAstVisitor<V> {
    /**
     * visit a {@link VoltageSensor}.
     *
     * @param temperatureSensor to be visited
     */
    V visitJoystick(Joystick<V> joystick);

    @Override
    V visitAccelerometer(AccelerometerSensor<V> accelerometer);

    V visitFlameSensor(FlameSensor<V> flameSensor);

    V visitImage(LedMatrix<V> ledMatrix);
}
