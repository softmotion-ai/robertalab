package de.fhg.iais.roberta.visitor.validate;

import de.fhg.iais.roberta.components.Configuration;
import de.fhg.iais.roberta.factory.BlocklyDropdownFactory;

public final class NxtBrickValidatorVisitor extends AbstractBrickValidatorVisitor {

    public NxtBrickValidatorVisitor(Configuration brickConfiguration, BlocklyDropdownFactory blocklyDdf) {
        super(brickConfiguration, blocklyDdf);
    }

}
