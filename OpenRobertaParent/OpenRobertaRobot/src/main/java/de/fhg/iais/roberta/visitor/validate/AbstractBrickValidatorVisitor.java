package de.fhg.iais.roberta.visitor.validate;

import java.util.Arrays;
import java.util.Map;

import de.fhg.iais.roberta.components.Configuration;
import de.fhg.iais.roberta.components.ConfigurationComponent;
import de.fhg.iais.roberta.factory.BlocklyDropdownFactory;
import de.fhg.iais.roberta.syntax.action.sound.VolumeAction;
import de.fhg.iais.roberta.syntax.action.sound.VolumeAction.Mode;
import de.fhg.iais.roberta.syntax.sensor.ExternalSensor;
import de.fhg.iais.roberta.typecheck.NepoInfo;

public abstract class AbstractBrickValidatorVisitor extends AbstractProgramValidatorVisitor {

    private final Map<String, String[]> sensorTypes;

    public AbstractBrickValidatorVisitor(Configuration brickConfiguration, BlocklyDropdownFactory blocklyDdf) {
        super(brickConfiguration, blocklyDdf);
        sensorTypes = blocklyDdf.getSensorTypes();

    }

    @Override
    protected final void checkSensorPort(ExternalSensor<Void> sensor) {
        ConfigurationComponent usedSensor = robotConfiguration.optConfigurationComponent(sensor.getPort());
        String sensorType = sensor.getKind().getName();
        String[] validSensorStatementNames = sensorTypes.get(sensorType);

        if ( usedSensor == null || validSensorStatementNames == null ) {
            sensor.addInfo(NepoInfo.error("CONFIGURATION_ERROR_SENSOR_MISSING"));
            errorCount++;
        } else {
            String componentType = usedSensor.getComponentType();
            if ( !Arrays.stream(validSensorStatementNames).anyMatch(componentType::equals) ) {
                sensor.addInfo(NepoInfo.error("CONFIGURATION_ERROR_SENSOR_WRONG"));
                errorCount++;
            }
        }
    }

    @Override
    public Void visitVolumeAction(VolumeAction<Void> volumeAction) {
        if ( volumeAction.getMode() == Mode.SET ) {
            volumeAction.getVolume().visit(this);
        }
        return null;
    }
}
