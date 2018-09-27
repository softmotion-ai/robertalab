package de.fhg.iais.roberta.visitors.arduino;

import de.fhg.iais.roberta.syntax.actors.arduino.PinWriteValueAction;
import de.fhg.iais.roberta.syntax.actors.arduino.SerialWriteAction;
import de.fhg.iais.roberta.visitor.actor.AstActorControlVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorDisplayVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorLightVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorMotorVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorSoundVisitor;
import de.fhg.iais.roberta.visitor.sensor.AstSensorsVisitor;

/**
 * Interface to be used with the visitor pattern to traverse an AST (and generate code, e.g.).
 */
public interface ArduinoAstVisitor<V> extends AstSensorsVisitor<V>, AstActorDisplayVisitor<V>, AstActorMotorVisitor<V>, AstActorLightVisitor<V>,
    AstActorSoundVisitor<V>, AstActorControlVisitor<V> {

    /**
     * visit a {@link LedOnAction}.
     *
     * @param ledOnAction phrase to be visited
     */

    V visitPinWriteValueAction(PinWriteValueAction<V> pinWriteValueSensor);

    V visitSerialWriteAction(SerialWriteAction<V> serialWriteAction);

}
