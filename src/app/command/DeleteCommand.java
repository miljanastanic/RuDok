package app.command;

import app.repository.Page;
import app.repository.element.SlotDevice;

import java.util.ArrayList;

public class DeleteCommand extends AbstactCommand{

    private Page page;
    private ArrayList<SlotDevice> selectedSlots;


    public DeleteCommand(Page page) {
        this.page = page;
        this.selectedSlots = new ArrayList<>(this.page.getSelectedSlots());
    }

    @Override
    public void doCommand() {
        page.deleteSelectedSlots();
    }

    @Override
    public void undoCommand() {
        page.addSlotElements(selectedSlots);
        page.getSelectedSlots().addAll(selectedSlots);
    }
}
