package app.state.TransformStates;

import app.command.DeleteCommand;
import app.repository.Page;
import app.repository.element.SlotDevice;
import app.state.State;

import java.awt.event.MouseEvent;

public class DeleteState extends State {

    private Page med;
    private SlotDevice slotDevice;

    public DeleteState(Page med) {
        this.med = med;
    }

    @Override
    public void mousePressed(MouseEvent e) {

       med.getCommandManager().addCommand(new DeleteCommand(med));
       med.notifySubscriber(this);

    }
}
