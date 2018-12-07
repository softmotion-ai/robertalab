package de.fhg.iais.roberta.visitor.validate;

import de.fhg.iais.roberta.components.Configuration;
import de.fhg.iais.roberta.factory.BlocklyDropdownFactory;

public final class NxtSimValidatorVisitor extends AbstractSimValidatorVisitor {

    public NxtSimValidatorVisitor(Configuration brickConfiguration, BlocklyDropdownFactory blocklyDdf) {
        super(brickConfiguration, blocklyDdf);
    }
}
