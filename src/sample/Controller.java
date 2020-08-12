package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * Controller []
 *
 * @author RunBrick <zhouwei9280@gmail.com>
 * @version 1.0.0
 * @description ""
 */
public class Controller {

    @FXML
    DatePicker birth;

    @FXML
    VBox listBirth;

    @FXML
    public void enterSearch(ActionEvent actionEvent) {
        LocalDate birthValue = birth.getValue();
        if (birthValue == null) {
//            resourceLabel.setText("请先选择一个日期!");
            return;
        }
        // 先定义一个今天日子
        LocalDate toDay = LocalDate.now();
        // 计算两个日子相差的年份
        Long y = ChronoUnit.YEARS.between(birthValue, toDay);
        Long m = ChronoUnit.MONTHS.between(birthValue, toDay);
        Long d = ChronoUnit.DAYS.between(birthValue, toDay);
        List<String> list = Arrays.asList("您的年龄:" + y.toString() + "岁", "距离出生过了:" + m.toString() + "个月",
                "距离出生过了:" + d.toString() + "天");
        listBirth.getChildren().clear();
        for (String l : list
        ) {
            returnResult(l);
        }

    }

    public void returnResult(String l) {
        Label label = new Label(l);
        label.setStyle("-fx-font-size: 14px;-fx-text-alignment: center");
        listBirth.getChildren().add(label);
    }
}
