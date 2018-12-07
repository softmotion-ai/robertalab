package de.fhg.iais.roberta.visitor.validate;

import de.fhg.iais.roberta.components.Configuration;
import de.fhg.iais.roberta.components.ConfigurationComponent;
import de.fhg.iais.roberta.factory.BlocklyDropdownFactory;
import de.fhg.iais.roberta.syntax.SC;
import de.fhg.iais.roberta.syntax.action.light.LightAction;
import de.fhg.iais.roberta.syntax.action.light.LightStatusAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.sound.PlayNoteAction;
import de.fhg.iais.roberta.syntax.action.sound.ToneAction;
import de.fhg.iais.roberta.syntax.sensor.ExternalSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.typecheck.NepoInfo;

public final class WedoBrickValidatorVisitor<V> extends AbstractBrickValidatorVisitor {

    public WedoBrickValidatorVisitor(Configuration brickConfiguration, BlocklyDropdownFactory blocklyDdf) {
        super(brickConfiguration, blocklyDdf);
    }

    @Override
    public Void visitKeysSensor(KeysSensor<Void> keysSensor) {
        checkSensorPort(keysSensor);
        return null;
    }

    @Override
    protected void checkSensorPort(ExternalSensor<Void> sensor) {
        ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(sensor.getPort());
        if ( usedConfigurationBlock == null ) {
            sensor.addInfo(NepoInfo.error("CONFIGURATION_ERROR_SENSOR_MISSING"));
            errorCount++;
        } else {
            switch ( sensor.getMode() ) {
                case "INFRARED_SENSING":
                    if ( !usedConfigurationBlock.getComponentType().equals("INFRARED") ) {
                        sensor.addInfo(NepoInfo.error("CONFIGURATION_ERROR_SENSOR_WRONG"));
                        errorCount++;
                    }
                    break;
                case "GYRO_SENSING":
                    if ( !usedConfigurationBlock.getComponentType().equals("GYRO") ) {
                        sensor.addInfo(NepoInfo.error("CONFIGURATION_ERROR_SENSOR_WRONG"));
                        errorCount++;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public Void visitMotorOnAction(MotorOnAction<Void> motorOnAction) {
        if ( motorOnAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(motorOnAction.getUserDefinedPort());
            boolean duration = motorOnAction.getParam().getDuration() != null;
            if ( usedConfigurationBlock == null ) {
                motorOnAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
                errorCount++;
            } else if ( SC.OTHER.equals(usedConfigurationBlock.getComponentType()) && duration ) {
                motorOnAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_OTHER_NOT_SUPPORTED"));
            }
        }
        return null;
    }

    @Override
    public Void visitMotorStopAction(MotorStopAction<Void> motorStopAction) {
        if ( motorStopAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(motorStopAction.getUserDefinedPort());
            if ( usedConfigurationBlock == null ) {
                motorStopAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
                errorCount++;
            }
        }
        return null;
    }

    @Override
    public Void visitLightAction(LightAction<Void> lightAction) {
        if ( lightAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(lightAction.getPort());
            if ( usedConfigurationBlock == null ) {
                lightAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
                errorCount++;
            }
        }
        return null;
    }

    @Override
    public Void visitPlayNoteAction(PlayNoteAction<Void> playNoteAction) {
        if ( playNoteAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(playNoteAction.getPort());
            if ( usedConfigurationBlock == null ) {
                playNoteAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
                errorCount++;
            }
        }
        return null;
    }

    @Override
    public Void visitLightStatusAction(LightStatusAction<Void> lightStatusAction) {
        if ( lightStatusAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.optConfigurationComponent(lightStatusAction.getPort());
            if ( usedConfigurationBlock == null ) {
                lightStatusAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
                errorCount++;
            }
        }
        return null;
    }

    @Override
    public Void visitToneAction(ToneAction<Void> toneAction) {
        if ( toneAction.getInfos().getErrorCount() == 0 ) {
            ConfigurationComponent usedConfigurationBlock = robotConfiguration.getConfigurationComponent(toneAction.getPort());
            if ( usedConfigurationBlock == null ) {
                toneAction.addInfo(NepoInfo.error("CONFIGURATION_ERROR_ACTOR_MISSING"));
            }
            errorCount++;
        }
        return null;
    }
}