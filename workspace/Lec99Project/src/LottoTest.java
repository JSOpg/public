import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// 로또 번호 생성(Hidden) 후 Input 값에 6개의 숫자를 입력하면, 입력한 숫자와 생성된 로또 번호 간의 맞춘 갯수를 출력해주는 프로그램.
public class LottoTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("LottoRootTest.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lotto");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
