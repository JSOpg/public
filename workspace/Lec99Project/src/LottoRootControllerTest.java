import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LottoRootControllerTest implements Initializable{
	
	@FXML TextArea outD;
	@FXML TextArea inputNum;
	@FXML TextField inPut1;
	@FXML TextField inPut2;
	@FXML TextField inPut3;
	@FXML TextField inPut4;
	@FXML TextField inPut5;
	@FXML TextField inPut6;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

	int[] lotto = new int[45];
	
	public void createNum(ActionEvent event) { // 로또 번호 생성
		
		// 로또 번호 추첨할때마다 입력한 값, 파일 출력 구문 초기화
		inPut1.clear();
		inPut2.clear();
		inPut3.clear();
		inPut4.clear();
		inPut5.clear();
		inPut6.clear();
		inputNum.setText("Ready...");
		
		for (int i = 0; i < lotto.length; i++) { // 1부터 45 출력
			lotto[i] = (i + 1);
		}
		System.out.println();

		int temp = 0;
		// lotto = {1, 2, 3, 4, 5, 6, ... 44, 45}
		for (int i = 0; i < 100; i++) {
			int idx = (int) (Math.random() * lotto.length); // 임의의 인덱스 번호

			// 정렬
			temp = lotto[0]; // temp에 원래 lotto[0] 의 값을 담아준다.
			lotto[0] = lotto[idx];
			lotto[idx] = temp;
		}
		outD.setText("로또 번호 추첨 완료. 숫자 6개를 입력해주세요.\n >>>>> 당첨 번호 <<<<< \n");
		
/*		
  		String ent = "";
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				ent = "\n";
				outD.appendText(lotto[i] + "  " + ent);
			} else {
				outD.appendText(lotto[i] + "  " + ent);
			}
		}
		

		/////////////////////////////////////////////////////////

		PrintWriter writer = null; // 파일 출력 구문
		try {

			writer = new PrintWriter(new FileWriter("/home/pc36/lottoNum.txt"));
			writer.print(outD.getText());
			inputNum.setText("/home/pc36/과제/lottoNum.txt로 출력됨\n");
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
*/
	}

	public void clearArea(ActionEvent event) { // 초기화 버튼 누르면 모두 초기화 시킴.
		outD.clear();
		inputNum.clear();
		inPut1.clear();
		inPut2.clear();
		inPut3.clear();
		inPut4.clear();
		inPut5.clear();
		inPut6.clear();
	}

	public void correctNum(ActionEvent event) throws NumberFormatException, IOException { // 입력한 값과 비교...
		
		int[] mylotto = new int[6];
		int count=0;
		SimpleDateFormat fm = new SimpleDateFormat("YYYY:HH:mm:ss");
		Date date = new Date();
			
			mylotto[0] = Integer.parseInt(inPut1.getText());
			mylotto[1] = Integer.parseInt(inPut2.getText());
			mylotto[2] = Integer.parseInt(inPut3.getText());
			mylotto[3] = Integer.parseInt(inPut4.getText());
			mylotto[4] = Integer.parseInt(inPut5.getText());
			mylotto[5] = Integer.parseInt(inPut6.getText());
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(lotto[i] == mylotto[j]) {
					count++;
				}
			}
		}
		
		//
		String ent = "";
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				ent = "\n";
				outD.appendText(lotto[i] + "  " + ent);
			} else {
				outD.appendText(lotto[i] + "  " + ent);
			}
		}
		//
		
		inputNum.appendText(count + "개 맞췄습니다. 입력한 번호");
		inputNum.appendText("(");
		for(int i =0; i<6; i++) {
			inputNum.appendText(mylotto[i] + " ");
		}
		inputNum.appendText(")");
		
		PrintWriter writer = null; // 파일 출력 구문
		try {

			writer = new PrintWriter(new FileWriter("./result.txt"));
			
			inputNum.setText("현재 디렉터리에 result.txt 출력됨 " + "( " +fm.format(date) + " )\n");
//			inputNum.setText("/home/ssam/result.txt에 출력됨 " + "( " +fm.format(date) + " )\n");

			inputNum.appendText(count + "개 맞췄습니다. 입력한 번호");
			inputNum.appendText("( ");
			for(int i =0; i<6; i++) {
				inputNum.appendText(mylotto[i] + " ");
			}
			inputNum.appendText(")");
			
			writer.print(inputNum.getText() +"\n\n" + outD.getText());

			
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
		
	}
}
	