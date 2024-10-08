import controller.InstrumentController;
import model.InstrumentDAO;
import view.InstrumentView;

public class Main {
    public static void main(String[] args) {
        InstrumentView view = new InstrumentView();
        InstrumentDAO model = new InstrumentDAO();
        InstrumentController controller = new InstrumentController(view, model);
    }
}
