package mvcFx.casual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;

public class MVCCalculator extends Application {
    public static final String TOPSCREEN_PATH = "/CalculatorView.fxml";

    /**
     * Chuyển path sang dạng URL để cho vào FXMLLoader
     * >> không phải cấu hình resource cho project
     *
     * @param path từ ./src/main/mvc...
     *             ("/view/CalculatorView.fxml")
     * @return URL để cho vào FXMLLoader
     */
    public static URL convertToURL(String path) {
        try {
            String passedInPath = "./src/main/mvcFx/casual" + path;
            URL url = FileSystems.getDefault().getPath(passedInPath)
                    .toUri().toURL();
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(convertToURL(TOPSCREEN_PATH));
//        Parent root = FXMLLoader.load(convertToURL(TOPSCREEN_PATH));
        Parent root = loader.load();
        CalculatorController controller = loader.getController();
        controller.setModel(new CalculatorModel());
        primaryStage.setTitle("CASIO FX 007");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
